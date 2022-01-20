<%--
  Created by IntelliJ IDEA.
  User: xujing
  Date: 1/9/22
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>登陆成功</title>
    <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <link rel="stylesheet" href="css/bootstrap.css" />
    <link rel="stylesheet" href="css/bootstrap-theme.css" />
</head>
<body style="display: flex; flex-direction: column; height: 100%; width: 100%; align-items: center; justify-content: center;">
    <h3>${sessionScope.username}，欢迎您！</h3>
    <br/>
    <div class="btn-group" style="display: flex">
        <button type="button" class="btn btn-default" id="info">个人信息</button>
        <c:if test="${sessionScope.username == 'xujing'}">
            <br>
            <button type="button" class="btn btn-default" id="getAll">用户列表</button>
            <br>
        </c:if>
        <button type="button" class="btn btn-default" id="logout">退出</button>
    </div>
    <div class="container" style="margin-top: 50px;">
        <form role="form" class="form-horizontal" action="upload" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label class="col-sm-5 control-label">头像</label>
                <div class="col-sm-7">
                    <div>
                        <img src="uploads/default.jpeg" id="img" style="width: 50px; height: 50px;"/>
                        <button type="button" class="btn btn-default" id="downImg">下载</button>
                    </div>
                    <br>
                    <div style="display: flex; align-items: center;">
                        <input type="text" name="username" id="username" value="${sessionScope.username}" hidden />
                        <input type="file" name="imgName"></input>
                        <button type="sumbit" class="btn btn-default">上传</button>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-5 control-label">用户名</label>
                <div class="col-sm-7">
                    <p class="form-control-static">${sessionScope.username}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-5 control-label">性别</label>
                <div class="col-sm-7">
                    <p class="form-control-static" id="sex"></p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-5 control-label">年龄</label>
                <div class="col-sm-7">
                    <p class="form-control-static" id="age"></p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-5 control-label">简介</label>
                <div class="col-sm-7">
                    <p class="form-control-static" id="intro"></p>
                </div>
            </div>
        </form>
    </div>
</body>
<script>
    // 查看个人信息
    $("#info").click(function () {
        $.get("getUserInfo", "username="+"${sessionScope.username}",
            function (res) {
                res = eval("(" + res + ")");
                if (res != null) {
                    console.log(res);
                    $("#img").attr("src",res.imgurl);
                    $("#username").text(res.username);
                    $("#sex").text(res.sex == 0 ? '女' : '男');
                    $("#age").text(res.age);
                    $("#intro").text(res.intro);
                } else {
                    console.log("null");
                }
            }
        )
    });
    // 查看所有用户
    $("#getAll").click(function () {
        window.location.href = "userList";
    });
    // 退出
    $("#logout").click(function () {
        window.location.href = "logout";
    })
    // 下载头像
    $("#downImg").click(function () {
        var imgName = $("#img").attr("src");
        imgName = imgName.slice(8);
        window.location.href = "download?imgName=" + imgName
    });
</script>
</html>
