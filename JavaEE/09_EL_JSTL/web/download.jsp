<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/29
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="http://localhost:8080/09_EL_JSTL/">
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="download" method="get">
    用户名：<input type="text" placeholder="请输入用户名" name="username" /> <br>
    文件名：<input type="text" placeholder="请输入要下载的文件名" name="filename" /> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
