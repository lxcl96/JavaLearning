<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/28
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    动态包含：  <jsp:include page="路径"></jsp:include>

        路径一般使用 / 开头 代表 http://localhost:8080/工程路径
            --%>
    <jsp:include page="/include/header.jsp">
        <jsp:param name="username" value="root" />
        <jsp:param name="password" value="123456" />
    </jsp:include>
    主题内容 <br/>

<%--    静态包含 ： <%@ include file="路径"%>

        路径一般使用 / 开头 代表 http://localhost:8080/工程路径
        --%>
    <%@ include file="/include/footer.jsp"%>
</body>
</html>
