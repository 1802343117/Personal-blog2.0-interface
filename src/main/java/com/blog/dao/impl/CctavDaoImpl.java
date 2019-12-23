package com.blog.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.blog.dao.CctavDao;

import java.sql.SQLException;
import java.util.List;

public class CctavDaoImpl implements CctavDao {
    @Override
    public List<Entity> CctavAll() throws SQLException {
        //查询
        return Db.use().query("select * from cctav ORDER BY id DESC ");
    }
}
