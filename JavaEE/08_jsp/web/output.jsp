<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/27
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp中的out输出和response.getWriter输出的区别</title>
</head>
<body>
       <%
           out.write("out输出1<br/>");
           out.write("out输出2<br/>");
           out.flush(); //先把out缓冲区数据保存到response缓冲区末尾，所以最后上面两个在前
           response.getWriter().write("response输出1<br/>");
           response.getWriter().write("response输出2<br/>");
       %>
</body>
</html>
