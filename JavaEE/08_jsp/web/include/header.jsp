<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/28
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
头部信息 <br/>
从main页面传递来的参数为： <br/>
name=<%=request.getParameter("username")%> <br/>
password=<%=request.getParameter("password")%> <br/>
</body>
</html>
