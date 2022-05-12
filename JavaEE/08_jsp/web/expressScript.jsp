<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/27
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--表达式脚本--%>
    12 <br/>
    <%= 12 %><br/>
    <%= "12" %><br/>
    <%= 12.0 %><br/>
<%--    不能加分号;--%>
    <%=
        request.getParameter("name")
    %>

</body>
</html>
