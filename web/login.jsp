<%--
  Created by IntelliJ IDEA.
  User: xujing
  Date: 1/8/22
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login_xj</title>
    <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
    <link rel="stylesheet" href="css/bootstrap.css" />
    <link rel="stylesheet" href="css/bootstrap-theme.css" />
    <link rel="stylesheet" href="css/form.css" />
</head>
<%
    String username = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null){
        for (Cookie c : cookies) {
            if ("username".equals(c.getName())) {
                username = c.getValue();
            }
        }
    }
    pageContext.setAttribute("username", username);
%>
<body>
    <div class="center-form">
        <form action="login" method="post" role="form" class="form-horizontal" id="loginForm">
            <div class="form-group">
                <label for="username" class="col-sm-5 control-label">用户名</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" name="username" id="username" placeholder="请输入用户名" value="${pageContext.getAttribute('username')}" />
                </div>
                <label class="col-sm-3 control-label" style="color: red; text-align: left;" id="usernameError"></label>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-5 control-label">密码</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" name="password" id="password" placeholder="请输入密码" />
                </div>
                <label class="col-sm-3 control-label" style="color: red; text-align: left;" id="passwordError"></label>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-5 col-sm-4">
                    <button class="btn btn-success pull-right" style="margin: auto" type="submit">登陆</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
