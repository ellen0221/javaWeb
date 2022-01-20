package com.javaweb.dao;

import com.javaweb.bean.User;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description
 * @Author JingXu
 * @Date 1/1/22 10:42 AM
 */
public interface UserDao {

    /**
     * @desc 用户登陆
     * @param username
     * @param password
     * @Return: void
     * @author: JingXu
     * @date:  1/1/22 12:01 PM
     */
    Boolean login(String username, String password);

    /**
     * @desc 根据用户名查找用户
     * @param username
     * @Return: com.javaweb.bean.User
     * @author: JingXu
     * @date:  1/17/22 7:23 PM
     */
    User queryUserByUsername(String username);

    /*
     * @desc 查询所有用户信息
     * @param
     * @Return: java.util.List<com.javaweb.bean.User>
     * @author: JingXu
     * @date:  1/10/22 10:12 PM
     */
    List<User> listAll();

    /**
     * @desc 根据用户名更新用户头像
     * @param username
     * @Return: java.lang.String
     * @author: JingXu
     * @date:  1/17/22 9:29 PM
     */
    Integer updateByUid(String username, String imgUrl);
}
