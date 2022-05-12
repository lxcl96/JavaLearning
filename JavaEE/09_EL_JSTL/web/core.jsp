<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    请求域：${ requestScope.adc } <br>
    <c:set scope="request" var="abc" value="12345" /> <br>
    请求域：${ requestScope.abc } <br>

    <hr>

    <c:if test="${12 == 12}">
        <h1>12等于12</h1>
    </c:if>
</body>
</html>
