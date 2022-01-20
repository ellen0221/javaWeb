package com.javaweb.service.impl;

import com.javaweb.bean.User;
import com.javaweb.dao.UserDao;
import com.javaweb.dao.UserDaoImpl;
import com.javaweb.service.UserService;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author JingXu
 * @Date 1/10/22 10:03 PM
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public Boolean login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public User queryUserByUsername(String username) {
        return userDao.queryUserByUsername(username);
    }

    @Override
    public List<User> listAll() {
        return userDao.listAll();
    }

    @Override
    public Integer updateByUid(String username, String imgUrl) {
        return userDao.updateByUid(username, imgUrl);
    }
}
