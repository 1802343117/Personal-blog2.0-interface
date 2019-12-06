package com.blog.controller;


import cn.hutool.db.Entity;
import com.blog.factory.DaoFactory;
import com.blog.utils.ResponseObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * @classname:UserController
 * @description:音乐控制层
 * @author:zhuoran
 * @Date: 2019/10/10 10:33
 */
@WebServlet(urlPatterns = "/music")
public class MusicController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Entity> entityList = null;
        try {
            entityList = DaoFactory.getMusicDaoInstance().musicAll();
        } catch (SQLException e) {
            System.err.println("查询音乐数据出现异常");
        }

        ResponseObject rom = new ResponseObject();
        rom.setCode(resp.getStatus());
        if(resp.getStatus() == 200){
            rom.setMsg("请求成功");
        }else{
            rom.setMsg("请求失败");
        }
        rom.setData(entityList);

        resp.setHeader("Access-Control-Allow-Origin", "*");
        //设置响应对象的内容类型
        resp.setContentType("application/json;charset=utf-8");
        //创建一个Gson对象
        Gson gson = new GsonBuilder().create();
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(rom));
        out.close();
    }
}
