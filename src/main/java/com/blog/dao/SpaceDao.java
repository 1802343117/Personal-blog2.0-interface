package com.blog.dao;

import cn.hutool.db.Entity;
import com.blog.entity.Space;

import java.sql.SQLException;
import java.util.List;

public interface SpaceDao {
    /**
     * 查询所有说说
     * @return List<Entity>
     * @throws SQLException
     */
    List<Entity> spaceAll() throws SQLException;

    //插入数据
    int insertSpace(Space space) throws SQLException;

    /**
     * 根据id删除说说，返回受影响的行数
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteSpaceById(int id) throws SQLException;

    /**
     * 根据id查找说说
     * @param id
     * @return
     * @throws SQLException
     */
    Entity getSpace(int id) throws SQLException;

    /**
     * 更新说说信息
     * @param id
     * @return
     * @throws SQLException
     */
    int updateSpace(Space space) throws SQLException;
}
