package com.blog.dao;

import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.List;

public interface CctavDao {
    /**
     *
     * @return
     * @throws SQLException
     */
    List<Entity> CctavAll() throws SQLException;
}
