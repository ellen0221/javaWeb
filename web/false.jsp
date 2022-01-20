<%--
  Created by IntelliJ IDEA.
  User: xujing
  Date: 1/9/22
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>登陆失败</title>
    <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
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
<body style="display: flex; flex-direction: column; height: 100%; width: 100%; align-items: center; justify-content: center;">
    <h3>登陆失败！</h3>
    <h3>用户名：<span id="username" style="font-weight: bold; color: darkred">${pageContext.getAttribute("username")}</span>，密码错误！</h3>

    <button class="btn btn-default" id="back">返回</button>
</body>
<script>
    $("#back").click(function () {
        window.location.href = "login.jsp";
    })
</script>
</html>
