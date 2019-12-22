package com.blog.dao;

import cn.hutool.db.Entity;
import com.blog.entity.Colm;

import java.sql.SQLException;
import java.util.List;

public interface ColmDao {
    /**
     * 查询所有说说评论
     * @return List<Entity>
     * @throws SQLException
     */
    List<Entity> ColmAll() throws SQLException;

    int insertColm(Colm colm) throws SQLException;

    /**
     * 根据id删除评论，返回受影响的行数
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteColmById(int id) throws SQLException;

    /**
     * 根据说说id查找评论
     * @param id
     * @return
     * @throws SQLException
     */
    List<Entity> getColm(int id) throws SQLException;

    /**
     * 更新评论信息
     * @param colm
     * @return
     * @throws SQLException
     */
    int updateColm(Colm colm)throws SQLException;
}
