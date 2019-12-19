package com.blog.dao.impl;

import cn.hutool
        .db.Db;
import cn.hutool.db.Entity;
import com.blog.dao.CommDao;
import com.blog.entity.Comm;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.SQLException;
import java.util.List;

public class CommDaoImpl implements CommDao {
    @Override
    public List<Entity> CommAll() throws SQLException {
        //查询
        return Db.use().query("select * from comments ORDER BY article_id DESC ");
    }

    @Override
    public int insertComm(Comm comm) throws SQLException {
        long id = Db.use().insertForGeneratedKey(
                Entity.create("comments")
                        .set("id", comm.getId())                            //文章ID
                        .set("user_id", comm.getUserid())                   //用户ID
//                        .set("article_id", comm.getArticleid())              //评论ID，该ID跟随用户ID（用于删除评论）
                        .set("content", comm.getContent())                  //评论内容
                        .set("user_name", comm.getUsername())               //用户昵称
                        .set("avatar", comm.getAvatar())                    //用户头像
                        .set("publish_time", comm.getPublishTimesc())       //添加数据时间
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
    public int deleteCommById(int id) throws SQLException {
        return Db.use().del(Entity.create("comments").set("article_id", id));
    }

    /**
     * 根据id查找评论
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public List<Entity> getComm(int id) throws SQLException {
        System.out.println("传入的值为："+id);
//        return Db.use().find(Entity.create("comments").set("id", id)).get(1);
        List<Entity> result = Db.use().query("SELECT * FROM  comments  WHERE id = ?", id);
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
    public int updateComm(Comm comm) throws SQLException {
        return Db.use().update(
                Entity.create()
                        .set("content", comm.getContent()),
                Entity.create("comments")
                        .set("article_id", comm.getArticleid())
        );
    }
}
