package com.blog.dao;

import cn.hutool.db.Entity;
import com.blog.entity.Record;

import java.sql.SQLException;
import java.util.List;

public interface RecordDao {
    /**
     * 查询所有成长记录
     * @return List<Entity>
     * @throws SQLException
     */
    List<Entity> RecordAll() throws SQLException;

    //插入数据
    int insertRecord(Record record) throws SQLException;

    /**
     * 根据id删除成长记录，返回受影响的行数
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteRecordById(int id) throws SQLException;

    /**
     * 根据id查找成长记录
     * @param id
     * @return
     * @throws SQLException
     */
    Entity getRecord(int id) throws SQLException;

    /**
     * 更新成长记录信息
     * @param id
     * @return
     * @throws SQLException
     */
    int updateRecord(Record record) throws SQLException;
}
