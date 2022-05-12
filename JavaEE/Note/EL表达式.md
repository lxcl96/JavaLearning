***EL表达式***

+ EL即Expression Language 表达式语言

+ EL表达式主要是代替jsp页面中的表达式脚本在jsp页面中进行数据的输出。【输出比jsp表达式脚本输出简洁得多】

  ```jsp
  <% request.setAttribute("key1","value1");%>
  <%--jsp表达式取值--%>
  jsp表达式输出：<%=request.getAttribute("key1")%> <br/>
  jsp表达式输出：<%=request.getAttribute("key")%> <br/> <!-- 输出null为null-->
  <%--  EL表达式输出 ${}  --%>
  EL表达式输出：${key1} <br/>
  EL表达式输出：${key} <br/> <!-- 输出null为空串-->
  ```

***EL表达式搜索域对象数据的顺序***

+ EL表达式在jsp页面中主要输出的是 *域数据*

+ 当jsp中四个域存在相同的key值时，依次按照从小到大的范围去找，

  ​		即 `pageContext-->request-->session-->application`

***EL表达式输出Bean，数组，List，Map***

```jsp
<!-- 和java用法一样-->    
输出Person：${person} 	<!-- 输出对象属性-->
输出Person 的name：${person.name} 	<!-- 输出普通属性-->
输出Person的phones：${person.phones[0]} 	<!-- 输出数组属性-->
输出Person的cites：${person.cities.get(0)} 	<!-- 输出List集合属性-->
输出Person的cites：${person.cities[0]} 	<!-- 输出List集合属性-->
输出Person的map的key的值：${person.map.k1} 	<!-- 输出Map集合属性中k1对应的value值-->
输出Person的map：${person.map.get("k2")} 	<!-- 输出Map集合属性-->
```

***EL表达式--运算***

+ 关系运算

  ```java
  等于：== 或 eq 如 ${5 eq 5}
  不等于：!= 或 ne
  小于: < 或 lt
  大于: > 或 gt
  小于等于: <= 或 le
  大于等于：>= 或 ge
  ```

+ 逻辑运算

  ```jsp
  与：&& 或 and
  或：|| 或 or
  非：! 或 not
  ```

+ 算术运算

  ```jsp
  加： +
  减：-
  乘：*
  除：/ 或 div
  取余：mod 或 %
  ```

+ empty运算

  用来判断一个数据是否为空，如果为空则输出true。

  `以下几种情况为空：`

  ​	`1、值为null时为空`

  ​	`2、空串时为空`

  ​	`3、值为Object类型数组时，长度为零的时候为空`

  ​	`4、list集合，元素个数为零时为空`

  ​	`5、map集合，元素个数为零时为空`

  ```jsp
  <!--用法-->
  ${empty 变量}
  ```

+ 三元运算符

  ```jsp
  表达式1?表达式2：表达式3
  ```

+ "."运算 好 中括号 [] 运算符

  ```jsp
  <!-- 点运算，可以输出Bean对象中某个属性的值-->
  对象.属性
  <!-- 中括号运算，可以输出有序集合中某个元素的值-->
  有序集合对象[0]
  <!-- 中括号运算，还可以输出map集合中key里含有特殊字符的key值-->
  map.put("a.a.a","aaavalue")
  resquest.setAttribute("map",map)
  ${map['a.a.a']} ==> aaavalue
  ```

***EL表达式中11个隐含对象***

`是EL表达式中自己定义的，可以直接使用`

+ `pageContext变量，是pageContextimpl类型，可以获取jsp中的9大内置对象`

  pageContext对象作用【大部分在request对象中，原理就是servlet程序对应get方法获取】：

  ```jsp
  1、协议	${pageCOntext.request.scheme}  ==> http
  2、服务器ip ${pageCOntext.request.serverName} 
  3、服务器端口 ${pageCOntext.request.serverPort}  
  4、获取工程路径 ${pageCOntext.request.contextPath}  
  5、获取请求方法 ${pageCOntext.request.method}  
  6、获取客户端ip地址 ${pageCOntext.request.remoteHost}  
  7、获取会话的id编号 ${pageCOntext.request.id}  
  ```

+ `pageScope变量，Map<String,Object>类型，可以获取ConText域中的数据`

+ `requestScope变量，Map<String,Object>类型，可以获取Request彧中数据`

+ `sessionScope变量，Map<String,Object>类型，可以获取session彧中数据`

+ `applicationScope变量，Map<String,Object>类型，可以获取ServletContext彧中数据`

+ `param变量，Map<String,String>类型，可以获取请求参数的值`

+ `paramValues变量，Map<String,String[]>类型，可以获取请求参数的值 【多个参数时使用,如hobby右多个值】`

+ `header变量，Map<String,String>类型，可以获取请求头信息`

+ `headerValues变量，Map<String,String[]>类型，可以获取请求头信息 【获取多个值的情况】`

+ `cookie变量，Map<String,Cookie>类型，可以当前请求的Cookie信息`

  ```jsp
  ${cookie.JSESSIONID.name}  获取cookie的name ，JSESSIONID 
  ${cookie.JSESSIONID.value} 获取cookie的value
  ```

  

+ `initParam变量，Map<String,String>类型，可以获取在web.xml中配置的 <context-param>上下文参数`

*EL获取四个特定域中的属性：*

+ `pageScope ==> pageContext域`
+ `requestScope ==> Request域`
+ `sessionScope ==> session域`
+ `applicationScope ==> ServletContext域`