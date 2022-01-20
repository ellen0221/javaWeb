package com.javaweb.bean;

/**
 * @ClassName User
 * @Description
 * @Author JingXu
 * @Date 1/1/22 10:10 AM
 */
public class User {

    // 用户id
    private Integer uid;

    // 用户名
    private String username;

    // 密码
    private String password;

    // 性别
    private Integer sex;

    // 年龄
    private Integer age;

    // 个人介绍
    private String intro;

    // 头像
    private String imgurl;

    public User() {
    }

    public User(Integer uid, String username, String password) {
        this.uid = uid;
        this.username = username;
        this.password = password;
    }

    public User(Integer uid, String username, String password, Integer sex, Integer age, String intro, String imgurl) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.intro = intro;
        this.imgurl = imgurl;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
