<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/27
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第二个jsp页面</title>
</head>
<body>

        pageContext 域是否有值？  <%= pageContext.getAttribute("key")%> <br/>
        request 域是否有值？  <%= request.getAttribute("key")%><br/>
        session 域是否有值？  <%= session.getAttribute("key")%><br/>
        application 域是否有值？  <%= application.getAttribute("key")%><br/>
</body>
</html>
