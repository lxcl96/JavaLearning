<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/27
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%--    声明脚本 ：    --%>
        <%--1、声明类属性--%>
        <%!
            private Integer id;
            private String name;
            private static Map<String,Object> map;
        %>

        <%--        2、声明静态代码块--%>
        <%!
            static {
                map = new HashMap<String,Object>();
                map.put("k1","v1");
                map.put("k2","v2");
                map.put("k3","v3");
                map.put("k4","v4");
            }
        %>

        <%--3、声明类方法--%>
        <%!
            public void h1(){
                System.out.println("hello");
            }
        %>
        <%--4、声明静态内部类--%>
        <%!
            public static class A{
                private Integer id =12;
            }
        %>

</body>
</html>
