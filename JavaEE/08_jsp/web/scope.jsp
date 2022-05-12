<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/27
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp四大内置域对象</title>
</head>
<body>
    <%----%>
    <h1>jsp四大内置域对象</h1>
    <%
         pageContext.setAttribute("key","pageContext");//需要导包，tomcat下
        request.setAttribute("key","request");
        session.setAttribute("key","session");
        application.setAttribute("key","servletContext");
    %>

    pageContext 域是否有值？  <%= pageContext.getAttribute("key")%> <br/>
    request 域是否有值？  <%= request.getAttribute("key")%><br/>
    session 域是否有值？  <%= session.getAttribute("key")%><br/>
    application 域是否有值？  <%= application.getAttribute("key")%><br/>

    <%
        request.getRequestDispatcher("/scope2.jsp").forward(request,response);
    %>


</body>
</html>
