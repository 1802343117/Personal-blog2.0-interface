package com.blog.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.blog.dao.ToolDao;

import java.sql.SQLException;
import java.util.List;

public class ToolDaoImpl implements ToolDao {
    @Override
    public List<Entity> toolAll() throws SQLException {
        //查询
        return Db.use().query("select * from tool ORDER BY id DESC ");
    }
}
