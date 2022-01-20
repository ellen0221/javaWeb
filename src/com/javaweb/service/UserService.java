package com.javaweb.service;

import com.javaweb.bean.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Description 用户Service
 * @Author JingXu
 * @Date 1/10/22 10:03 PM
 */
public interface UserService {

    // 登陆
    Boolean login(String username, String password);

    // 根据用户名查询用户
    User queryUserByUsername(String username);

    // 查询所有用户
    List<User> listAll();

    // 根据用户名更新用户头像
    Integer updateByUid(String username, String imgUrl);
}
