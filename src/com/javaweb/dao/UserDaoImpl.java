package com.javaweb.dao;

import com.javaweb.bean.User;
import com.javaweb.util.DatabaseUtil;
import com.javaweb.util.EncryptUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserDaoImpl
 * @Description
 * @Author JingXu
 * @Date 1/1/22 12:02 PM
 */
public class UserDaoImpl extends DatabaseUtil implements UserDao {

    private ResultSet rs = null;

    @Override
    public Boolean login(String username, String password) {
        Boolean res = false;
        try {
            // 根据用户名查找是否存在该用户
            String sql = "select * from user where username = ?;";
            List<Object> params = new ArrayList<>();
            params.add(username);
            rs = query(sql, params);
            if (rs.next()) {
                // 若存在，则判断密码是否正确
                if (EncryptUtil.md5(password).equals(rs.getString("password"))) {
                    res = true;
                }
            } else {
                // 否则创建一个新用户
                String insert = "insert into user(username, password) values (?,?)";
                List<Object> param = new ArrayList<>();
                param.add(username);
                param.add(EncryptUtil.md5(password));
                int count = update(insert, param);
                if (count > 0) {
                    res = true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeResources();
        }
        return res;
    }

    @Override
    public User queryUserByUsername(String username) {
        User user = null;
        try {
            // 根据用户名查找是否存在该用户
            String sql = "select * from user where username = ?;";
            List<Object> params = new ArrayList<>();
            params.add(username);
            rs = query(sql, params);
            if (rs.next()) {
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUsername(username);
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getInt("sex"));
                user.setIntro(rs.getString("intro"));
                user.setImgurl(rs.getString("imgurl"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeResources();
        }
        return user;
    }

    @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from user";
        rs = query(sql, null);
        try {
            while (rs.next()) {
                User user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeResources();
        }
        return users.size() > 0 ? users : null;
    }

    @Override
    public Integer updateByUid(String username, String imgUrl) {

        String update = "update user set imgurl=? where username=?;";
        List<Object> param = new ArrayList<>();
        param.add(imgUrl);
        param.add(username);
        System.out.println(param.size());
        Integer count = update(update, param);

        return count;
    }
}
