package com.blog.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.blog.dao.SpaceDao;
import com.blog.entity.Space;

import java.sql.SQLException;
import java.util.List;

public class SpaceDaoImpl implements SpaceDao {
    @Override
    public List<Entity> spaceAll() throws SQLException {
        //查询
        return Db.use().query("select * from t_space ORDER BY id DESC ");
    }

    @Override
    public int insertSpace(Space space) throws SQLException {
        //插入
        long id = Db.use().insertForGeneratedKey(
                Entity.create("t_space")
//                        .set("id", space.getId())
                        .set("content", space.getContent())
                        .set("additional", space.getAdditional())
                        .set("publish_time", space.getPublishtimesc())
                        .set("likes", space.getLikes())
        );
        return (int) id;
    }

    /**
     * 根据id删除留言，返回受影响的行数
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteSpaceById(int id) throws SQLException {
        return Db.use().del(Entity.create("t_space").set("id", id));
    }

    /**
     * 根据id查找留言
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Entity getSpace(int id) throws SQLException {
        return Db.use().find(Entity.create("t_space").set("id", id)).get(0);
    }

    /**
     * 更新留言信息
     * @param
     * @return
     * @throws SQLException
     */
    @Override
    public int updateSpace(Space space) throws SQLException {
        return Db.use().update(
                Entity.create()
                        .set("likes", space.getLikes())
                        .set("publish_time", space.getPublishtime()),
                Entity.create("t_space")
                        .set("id", space.getId())
        );
    }
}
