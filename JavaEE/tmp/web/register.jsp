<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/9
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>注册</title>
  </head>
  <body>
  <form action="http://localhost:8080/tmp/registerServlet" method="get">
    用户名：<input type="text" name="username" /> <br/>
    验证码：<input type="text" name="verifyCode"/>
    <img src="http://localhost:8080/tmp/kaptcha.jpg" alt="验证码啊哈哈"/> <br/>
    <input type="submit" value="提交" />
  </form>
  </body>
</html>
