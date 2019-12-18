package com.blog.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.blog.dao.UserDao;
import com.blog.entity.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @classname:UserController
 * @description:用户控制层
 * @author:zhuoran
 * @Date: 2019/10/10 10:33
 */
public class UserDaoImpl implements UserDao{
    @Override
    public List<Entity> findAll() throws SQLException {
        //查询
        return Db.use().query("select * from t_user ORDER BY id DESC ");
    }

    @Override
    public int insertUser(User user) throws SQLException {
        long id = Db.use().insertForGeneratedKey(
                Entity.create("t_user")
                        .set("account", user.getAccountsc())
//                        .set("password", user.getPassword())
                        .set("password", DigestUtils.md5Hex(user.getPassword()))                //密码加密
                        .set("nickname", user.getNickname())
                        .set("avatar", user.getAvatarmr())
                        .set("gender", user.getGender())
                        .set("birthday", user.getBirthdaysc())             //后台自动获取的时间
                        .set("address", user.getAddress())
                        .set("introduction", user.getIntroduction())
                        .set("follows", user.getFollows())
                        .set("create_time", user.getCreateTimesc())             //后台自动获取的时间
                        .set("status", user.getStatus())
                        .set("mobile", user.getMobile())
//                        .set("join_date", user.getJoinDate())
//                        .set("description", user.getDescription())
        );
        return (int) id;
    }

    @Override
    public int deleteUserById(int id) throws SQLException {
        return Db.use().del(Entity.create("t_user").set("id", id));
    }

    @Override
    public Entity getUser(int id) throws SQLException {
        return Db.use().find(Entity.create("t_user").set("id", id)).get(0);
    }

    @Override
    public int updateUser(User user) throws SQLException {
        return Db.use().update(
                Entity.create()
                        .set("nickname", user.getNickname())
                        .set("address", user.getAddress()),
                Entity.create("t_user").set("id", user.getId())
        );
    }

    @Override
    public Entity findUserByAccount(String account) throws SQLException {
//        return Db.use().query("select * from t_user ORDER BY id DESC ");
        return Db.use().find(Entity.create("t_user").set("account", account)).get(0);
    }
}