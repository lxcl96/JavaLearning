<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/29
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--	一般项目中，base标签只写到工程路径-->
<!--	此方法为静态ip地址固定住了，如果别人访问的话肯定会访问不到的。-->
<%--动态获取ip地址--%>
<%
                    //得到http协议                  ip地址                            服务端口                    工程路径
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/" ;
%>

<base href="<%= basePath%>">

<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>