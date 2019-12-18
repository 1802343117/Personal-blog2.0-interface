package com.blog.dao;

import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.List;

public interface ToolDao {
    /**
     *
     * @return
     * @throws SQLException
     */
    List<Entity> toolAll() throws SQLException;
}
