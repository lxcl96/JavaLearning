<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/8
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="http://localhost:8080/10_Cookie_Sesion/">
<html>
<head>
    <title>用户登陆</title>
</head>
<body>
    <form action="cookieServlet" method="post">
        <input type="hidden" name="action" value="login">
        用户名：<input type="text" name="username" value="${cookie.username.value}"/> <br/>
        密码：<input type="password" name="password" /> <br/>
        <input type="submit" value="登陆"/>
    </form>
</body>
</html>
