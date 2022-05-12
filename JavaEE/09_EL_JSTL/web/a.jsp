<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/28
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("key1","value1");
    %>


    <%--jsp表达式取值--%>
    jsp表达式输出：<%=request.getAttribute("key1")%> <br/>
    jsp表达式输出：<%=request.getAttribute("key")%> <br/>
    <%--  EL表达式输出 ${}  --%>
    EL表达式输出：${key1} <br/>
    EL表达式输出：${key} <br/>
</body>
</html>
