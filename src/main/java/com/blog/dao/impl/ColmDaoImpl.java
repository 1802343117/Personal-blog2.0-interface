package com.blog.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.blog.dao.ColmDao;
import com.blog.entity.Colm;

import java.sql.SQLException;
import java.util.List;

public class ColmDaoImpl implements ColmDao {
    @Override
    public List<Entity> ColmAll() throws SQLException {
        //查询
        return Db.use().query("select * from colm ORDER BY article_id DESC ");
    }

    @Override
    public int insertColm(Colm colm) throws SQLException {
        long id = Db.use().insertForGeneratedKey(
                Entity.create("colm")
                        .set("id", colm.getId())                            //文章ID
                        .set("user_id", colm.getUserid())                   //用户ID
//                        .set("article_id", comm.getArticleid())              //评论ID，该ID跟随用户ID（用于删除评论）
                        .set("content", colm.getContent())                  //评论内容
                        .set("user_name", colm.getUsername())               //用户昵称
                        .set("avatar", colm.getAvatar())                    //用户头像
                        .set("publish_time", colm.getPublishTimesc())       //添加数据时间
        );
        return (int) id;
    }

    /**
     * 根据id删除评论，返回受影响的行数
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteColmById(int id) throws SQLException {
        return Db.use().del(Entity.create("colm").set("article_id", id));
    }

    /**
     * 根据id查找评论
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public List<Entity> getColm(int id) throws SQLException {
        System.out.println("传入的值为："+id);
//        return Db.use().find(Entity.create("comments").set("id", id)).get(1);
        List<Entity> result = Db.use().query("SELECT * FROM  colm  WHERE id = ?", id);
        return result;
    }

    /**
     * 更新评论信息
     *
     * @param
     * @return
     * @throws SQLException
     */
    @Override
    public int updateColm(Colm colm) throws SQLException {
        return Db.use().update(
                Entity.create()
                        .set("content", colm.getContent()),
                Entity.create("colm")
                        .set("article_id", colm.getArticleid())
        );
    }
}
