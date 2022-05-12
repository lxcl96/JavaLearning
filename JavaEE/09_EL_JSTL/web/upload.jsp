<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/29
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="http://localhost:8080/09_EL_JSTL/">
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="upload" method="post" enctype="multipart/form-data">
        用户名：<input type="text" placeholder="请输入用户名" name="username"/> <br/>
        头像：<input type="file" name="photo"/> <br/>
        <input type="submit" value="上传"/>
    </form>
</body>
</html>
