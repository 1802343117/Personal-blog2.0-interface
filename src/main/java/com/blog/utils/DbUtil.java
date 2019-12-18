//package com.blog.utils;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.*;
//import java.time.LocalDateTime;
//import java.util.Properties;
//import java.util.ResourceBundle;
//
///**
// * 数据库连接工具类
// *
// * @author mqxu
// * @date 2019-11-07
// */
//public class DbUtil {
//
//    private static String URL;
//    private static String USERNAME;
//    private static String PASSWORD;
//    private static Connection conn = null;
//    private static final Logger logger = LoggerFactory.getLogger(DbUtil.class);
//
//
//    /**
//     * 读取resources目录下的db-config.properties文件
//     */
//    private static Properties properties;
//    /**
//     * 私有的构造方法，单例模式，禁止外部创建对象
//     */
//    private DbUtil() {
//    }
//
//    // 使用静态代码块保证在类加载的时候立即加载对应的配置文件
//    static {
//        properties = new Properties();
//        try {
//            InputStream ins = DbUtil.class.getClassLoader().getResourceAsStream("db-config.properties");
//            assert ins != null;
//            properties.load(ins);
//            Class.forName(properties.getProperty("jdbc.driverClassName"));
//        } catch (FileNotFoundException e) {
//            logger.error("数据库配置文件未找到");
//        } catch (IOException e) {
//            logger.error("数据库配置文件读写错误");
//        } catch (ClassNotFoundException e) {
//            logger.error("数据库驱动未找到");
//        }
//    }
//
//    /**
//     * 获得数据库连接Connection
//     *
//     * @return Connection 数据库连接
//     */
//    public static Connection getConnection() {
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(
//                    properties.getProperty("jdbc.url"),
//                    properties.getProperty("jdbc.username"),
//                    properties.getProperty("jdbc.password"));
//        } catch (SQLException e) {
//            logger.error("数据库连接失败");
//        }
//        return connection;
//    }
//    /**
//     * 关闭数据库连接
//     *
//     * @param rs
//     * @param stat
//     * @param conn
//     */
//    public static void close(ResultSet rs, Statement stat, Connection conn) {
//        try {
//            if (rs != null) {
//                rs.close();
//            }
//            if (stat != null) {
//                stat.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        Connection connection = null;
//        for (int i = 0; i < 3; i++) {
//            connection = DbUtil.getConnection();
//        }
//    }
//}
