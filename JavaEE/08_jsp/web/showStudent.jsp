<%@ page import="com.ly.pojo.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/28
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示学生信息</title>
    <style>
        td{
            border: 1px red solid;
            width: 100px;
        }
    </style>
</head>
<body>
<table align="center" style=" border-collapse: collapse;" >
    <%
        ArrayList<Student> students = (ArrayList<Student>)request.getAttribute("stuList");
        %>
    <tr style="border: 1px red solid">
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>电话</td>
        <td>操作</td>
    </tr>
        <% for (int j = 0; j < students.size(); j++) { %>
    <tr style="border: 1px red solid">
        <td><%= students.get(j).getId()%></td>
        <td><%= students.get(j).getAge()%></td>
        <td><%= students.get(j).getName()%></td>
        <td><%= students.get(j).getPhone()%></td>
        <td><%= "删除、修改"%></td>
        </td>
    </tr>
        <%  }%>
</body>
</html>
