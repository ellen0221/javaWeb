package com.javaweb.util;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

/**
 * @ClassName BaseDao
 * @Description
 * @Author JingXu
 * @Date 12/31/21 9:13 PM
 */
public class DatabaseUtil {

    // Druid连接池
    private static DruidDataSource dataSource;

    // 数据库连接
    private Connection conn;

    // 预状态通道
    private PreparedStatement pps;

    // 受影响行数
    private int count;

    // 结果集
    private ResultSet resultSet = null;

    // 获取数据库连接参数
    static {
        Properties properties = new Properties();
        try {
            dataSource = new DruidDataSource();
            properties.load(DatabaseUtil.class.getClassLoader().getResourceAsStream("properties/db.properties"));
            dataSource.setDriverClassName(properties.getProperty("dbDriver"));
            dataSource.setUsername(properties.getProperty("user"));
            dataSource.setPassword(properties.getProperty("password"));
            dataSource.setUrl(properties.getProperty("url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**.
     * @desc 连接数据库
     * @param
     * @Return: java.sql.Connection
     * @author: JingXu
     * @date:  12/31/21 9:30 PM
     */
    protected Connection getConnection() {
        try {
            conn = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    /**
     * @desc 获取预状态通道
     * @param sql
     * @Return: java.sql.PreparedStatement
     * @author: JingXu
     * @date:  1/1/22 10:08 AM
     */
    protected PreparedStatement getPps(String sql) {
        try {
            pps = getConnection().prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pps;
    }

    /**
     * @desc 给预状态通道绑定参数
     * @param paramsList
     * @Return: void
     * @author: JingXu
     * @date:  1/1/22 10:09 AM
     */
    protected void params(List<Object> paramsList) {
        if (paramsList != null && paramsList.size() > 0) {
            for (int i = 0; i < paramsList.size(); i++) {
                try {
                    pps.setObject(i+1, paramsList.get(i));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    /**
     * @desc 执行insert、update、delete语句
     * @param sql
     * @param list
     * @Return: int
     * @author: JingXu
     * @date:  1/1/22 4:53 PM
     */
    protected int update(String sql, List<Object> list) {
        getPps(sql);
        params(list);
        try {
            count = pps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    /**
     * @desc 执行查询语句
     * @param sql
     * @param list
     * @Return: java.sql.ResultSet
     * @author: JingXu
     * @date:  1/1/22 4:54 PM
     */
    protected ResultSet query(String sql, List<Object> list) {
        getPps(sql);
        params(list);
        try {
            resultSet = pps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    /**
     * @desc 关闭所有资源
     * @param
     * @Return: void
     * @author: JingXu
     * @date:  1/1/22 5:01 PM
     */
    protected void closeResources() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (pps != null) {
                pps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
