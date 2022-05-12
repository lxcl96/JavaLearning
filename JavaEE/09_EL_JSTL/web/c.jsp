<%@ page import="com.ly.pojo.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/28
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Person person = new Person();
        person.setName("张无忌");
        person.setPhones(new String[]{"110","120","119","12306"});


        ArrayList<String> cities = new ArrayList<>();
        cities.add("北京");
        cities.add("上海");
        cities.add("深圳");
        person.setCities(cities);

        HashMap<String, Object> map = new HashMap<>();
        map.put("k1","v1");
        map.put("k2","v2");
        map.put("k3","v3");
        map.put("k4","v4");

        person.setMap(map);

        //将Person对象放在4个域中
        pageContext.setAttribute("person",person);
    %>

    输出Person：${person} <br/>
    输出Person 的name：${person.name} <br/>
    输出Person的phones：${person.phones[0]} <br/>
    输出Person的cites：${person.cities.get(0)} <br/>
    输出Person的map：${person.map.get("k2")} <br/>
    输出Person的age：${person.age} <br/> <!--必须要有对应的get方法，才能获取到其属性-->
</body>
</html>
