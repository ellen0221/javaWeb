<%--
  Created by IntelliJ IDEA.
  User: xujing
  Date: 1/10/22
  Time: 10:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
    <div class="container">
        <table style="border: 1px solid rgba(169, 169, 169, 0.5); width: 600px; text-align: center;">
            <tr>
                <td>uid</td>
                <td>username</td>
                <td>password</td>
            </tr>
            <c:forEach items="${requestScope.userList}" var="user" >
                <tr>
                    <td>${user.uid}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
