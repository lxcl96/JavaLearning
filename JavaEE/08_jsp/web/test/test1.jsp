<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/28
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--要求输出九九乘法口诀表--%>
<table style="width: 650px;align-content: center">
<%
    for (int i = 1; i <= 9; i++) {
        %>
    <tr>
        <%
            for (int j = 1; j <= i; j++) {
        %>
        <td>
            <%
                out.print(j + "x" + i + "=" + (i * j) + "  "); }//可以用html表格对齐
            %>
        </td>
    </tr>
        <%

        out.print("<br/>"); }
%>
</table>
</body>
</html>
