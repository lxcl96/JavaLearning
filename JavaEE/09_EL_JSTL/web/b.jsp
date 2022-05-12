<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/28
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //pageContext.setAttribute("key","pageContext");
        //request.setAttribute("key","request");
        //session.setAttribute("key","session");
        application.setAttribute("key","application");

    %>

<%--    pageContext 当前jsp文本域  可以
        如果有重复的key 优先输出 pageContext当前jsp页面对象  即 依次从小到大取值，pageContext没有，找request，没有， 找session，没有找application
--%>
    ${key}
</body>
</html>
