package com.blog.dao;

import cn.hutool.db.Entity;
import com.blog.entity.Leave;
import com.blog.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface LeaveDao {
    /**
     * 查询所有留言
     * @return List<Entity>
     * @throws SQLException
     */
    List<Entity> leaveAll() throws SQLException;

    //插入数据
    int insertLeave(Leave leava) throws SQLException;

    /**
     * 根据id删除留言，返回受影响的行数
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteLeaveById(int id) throws SQLException;

    /**
     * 根据id查找留言
     * @param id
     * @return
     * @throws SQLException
     */
    Entity getLeave(int id) throws SQLException;

    /**
     * 更新留言信息
     * @param id
     * @return
     * @throws SQLException
     */
    int updateLeave(Leave leave) throws SQLException;
}
