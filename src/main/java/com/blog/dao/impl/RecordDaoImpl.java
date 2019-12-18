package com.blog.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.blog.dao.RecordDao;
import com.blog.entity.Record;

import java.sql.SQLException;
import java.util.List;

public class RecordDaoImpl implements RecordDao {
    @Override
    public List<Entity> RecordAll() throws SQLException {
        //查询
        return Db.use().query("select * from t_record ORDER BY id DESC ");
    }

    @Override
    public int insertRecord(Record record) throws SQLException {
        //插入
        long id = Db.use().insertForGeneratedKey(
                Entity.create("t_record")
//                        .set("id", space.getId())
                        .set("content", record.getContent())
                        .set("additional", record.getAdditional())
                        .set("publish_time", record.getPublishtimesc())
                        .set("modigy_time", record.getModigytimesc())
                        .set("likes", record.getLikes())
        );
        return (int) id;
    }

    @Override
    public int deleteRecordById(int id) throws SQLException {
        return Db.use().del(Entity.create("t_record").set("id", id));
    }

    @Override
    public Entity getRecord(int id) throws SQLException {
        return Db.use().find(Entity.create("t_record").set("id", id)).get(0);
    }

    @Override
    public int updateRecord(Record record) throws SQLException {
        return Db.use().update(
                Entity.create()
                        .set("likes", record.getLikes())
                        .set("modigy_time", record.getPublishtimesc()),
                Entity.create("t_record")
                        .set("id", record.getId())
        );
    }
}
