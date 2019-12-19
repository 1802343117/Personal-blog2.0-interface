package com.blog.dao;

import cn.hutool.db.Entity;
import com.blog.entity.Comm;

import java.sql.SQLException;
import java.util.List;

public interface CommDao {
    /**
     * 查询所有文章评论
     * @return List<Entity>
     * @throws SQLException
     */
    List<Entity> CommAll() throws SQLException;

    int insertComm(Comm comm) throws SQLException;

    /**
     * 根据id删除评论，返回受影响的行数
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteCommById(int id) throws SQLException;

    /**
     * 根据文章id查找评论
     * @param id
     * @return
     * @throws SQLException
     */
    List<Entity> getComm(int id) throws SQLException;

    /**
     * 更新评论信息
     * @param comm
     * @return
     * @throws SQLException
     */
    int updateComm(Comm comm)throws SQLException;
}
