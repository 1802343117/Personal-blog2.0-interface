package com.blog.controller;

import cn.hutool.db.Entity;
import com.blog.entity.Leave;
import com.blog.entity.User;
import com.blog.factory.DaoFactory;
import com.blog.utils.ResponseObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @classname:UserController
 * @description:留言控制层
 * @author:zhuoran
 * @Date: 2019/10/10 10:33
 */
@WebServlet(urlPatterns = "/leave")
public class LeaveController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestPath = req.getRequestURI().trim();
        if("/leave".equals(requestPath)) {
            seletAll(req, resp);
        } else {
            getLeave(req, resp);
        }
    }

    /**
     * 根据id查找留言
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void getLeave(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //
        String requestPath = req.getRequestURI().trim();
        int position = requestPath.lastIndexOf("/");
        String id = requestPath.substring(position + 1);
        Entity leave = null;
        try {
            leave = DaoFactory.getLeaveDaoInstance().getLeave(Integer.parseInt(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int code = resp.getStatus();
        String msg = code == 200 ? "成功" : "失败";
        ResponseObject ro = ResponseObject.success(code, msg, leave);
        resp.setContentType("applacation/json;charset=utf-8");
        Gson gson = new GsonBuilder().create();
        PrintWriter out = resp.getWriter();
        String result = gson.toJson(ro);
        out.print(result);
        out.close();
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void seletAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Entity> entityList = null;
        try {
            entityList = DaoFactory.getLeaveDaoInstance().leaveAll();
        } catch (SQLException e) {
            System.err.println("查询用户数据出现异常");
        }

        ResponseObject ro = new ResponseObject();
        ro.setCode(resp.getStatus());
        if(resp.getStatus() == 200){
            ro.setMsg("请求成功");
        }else{
            ro.setMsg("请求失败");
        }
        ro.setData(entityList);

        resp.setHeader("Access-Control-Allow-Origin", "*");
        //设置响应对象的内容类型
        resp.setContentType("application/json;charset = utf-8");
        //创建一个Gson对象
        PrintWriter out = resp.getWriter();
        Gson gson = new GsonBuilder().create();
        out.print(gson.toJson(ro));
        out.close();
    }

    /**
     * 添加
     * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        BufferedReader resder = req.getReader();
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        while ((line = resder.readLine()) != null) {
            stringBuffer.append(line);
        }
        System.out.println(stringBuffer.toString());
        //将接受到的客户端JSON字符串转成User对象
        Gson gson = new GsonBuilder().create();
        Leave leave = gson.fromJson(stringBuffer.toString(), Leave.class);
        //补全日期信息
        leave.setPublishtime(LocalDateTime.now());
        int id = 0;
        try {
            id = DaoFactory.getLeaveDaoInstance().insertLeave(leave);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        leave.setId((long) id);
        resp.setContentType("application/json;charset=utf-8");
        int code = resp.getStatus();
        String msg = code == 200 ? "成功" : "失败";
        ResponseObject ro = ResponseObject.success(code, msg, leave);
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();
    }

    /**
     * 根据id删除留言，返回受影响的行数
     * @param
     * @return
     * @throws SQLException
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端传递的id参数
        String id = req.getParameter("id");
        int n = 0;
        try {
            n = DaoFactory.getLeaveDaoInstance().deleteLeaveById(Integer.parseInt(id));
//            n = DaoFactory.getUserDaoInstance().deleteUserById(Integer.parseInt(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int code = resp.getStatus();
        String msg = n == 1 ? "成功" : "失败";

        ResponseObject ro = ResponseObject.success(code, msg);
        Gson gson = new GsonBuilder().create();
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();
    }

    /**
     * 修改信息
     * */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        BufferedReader reader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        System.out.println(stringBuilder.toString());
        Gson gson = new GsonBuilder().create();
        Leave leave = gson.fromJson(stringBuilder.toString(), Leave.class);
        int n = 0;
        try {
            n = DaoFactory.getLeaveDaoInstance().updateLeave(leave);
//            n = DaoFactory.getUserDaoInstance().updateUser(leave);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.setContentType("application/json;charset=utf-8");
        int code = resp.getStatus();
        String msg = n == 1 ? "成功" : "失败";
        ResponseObject ro = ResponseObject.success(code, msg, leave);
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();
    }
}
