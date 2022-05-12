<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/27
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>out的print方法和write的方法区别.jsp</title>
</head>
<body>
        <%
            //out的print方法和write的方法区别

            //1、输出字符串没问题
            out.write("你好");
            out.print("你好");

            //2、输出别的类型 如整型 write会出现问题
            // 原因是：输入的别的如整型，会被转成ASCII然后追加到out的缓冲区内
            out.write(12);
            // print方法，无论你传递什么参数，都会被转成String类型直接输出来
            out.print(12);
        %>
</body>
</html>
