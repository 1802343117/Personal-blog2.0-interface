package com.blog.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.blog.dao.LeaveDao;
import com.blog.entity.Leave;

import java.sql.SQLException;
import java.util.List;

/**
 * @classname:UserController
 * @description:留言控制层
 * @author:zhuoran
 * @Date: 2019/10/10 10:33
 */
public class LeaveDaoImpl implements LeaveDao {
    @Override
    public List<Entity> leaveAll() throws SQLException {
        //查询
        return Db.use().query("select * from t_leave ORDER BY id DESC ");
    }


    @Override
    public int insertLeave(Leave leave) throws SQLException {
        //插入
        long id = Db.use().insertForGeneratedKey(
                Entity.create("t_leave")
//                        .set("id", leava.getId())
                        .set("switch", leave.getTswitch())
                        .set("user_name", leave.getUsername())
                        .set("content", leave.getContent())
                        .set("publish_time", leave.getpublishtimesc())
                        .set("likes", leave.getLikes())
                        .set("avatar", leave.getAvatar())
                        .set("additional", leave.getAdditional())
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
    public int deleteLeaveById(int id) throws SQLException {
        return Db.use().del(Entity.create("t_leave").set("id", id));
    }

    /**
     * 根据id查找留言
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Entity getLeave(int id) throws SQLException {
        return Db.use().find(Entity.create("t_leave").set("id", id)).get(0);
    }

    /**
     * 更新留言信息
     * @param
     * @return
     * @throws SQLException
     */
    @Override
    public int updateLeave(Leave leave) throws SQLException {
        return Db.use().update(
                Entity.create()
                        .set("switch", leave.getTswitch())
                        .set("likes", leave.getLikes()),
                Entity.create("t_leave")
                        .set("id", leave.getId())
        );
    }
}
