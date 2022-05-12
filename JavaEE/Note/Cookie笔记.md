***Cookie 饼干***

1. *什么是cookie*

   答：`Cookie是服务器通知客户端保存键值对的一种技术，客户端有了Cookie后每次请求都会发送给服务器。每个Cookie的大小不能超过4KB。`

2. *如何创建Cookie*

   ```java
   //1、创建Cookie对象
   Cookie cookie = new Cookie("k1","v1");
   //通知服务器报错cookie
   response.addCookie(cookie);
   ```

3. cookie值的修改

   ```java
   //方法1、创建一个要修改的同名的Cookie对象
   Cookie cookie = new Cookie("k1","v2");//利用的就是map的key值唯一
   response.addCookie(cookie);
   //方法2、使用cookie的setValue()方案
   cookie.setValue("v2");
   response.addCookie(cookie);//必须加上不然改的只是服务器端 
   ```

4. Cookie的生命控制

   ```java
   //如果参数值为正数：表示cookie经过多少秒后过期
   //如果参数值为0：表示cookie立马被删除【默认为-1】
   //如果参数值为负数：表示cookie在浏览器关闭后过期
   cookie.setMaxAge(值);
   ```

5. Cookie有效路径Path设置 

   `cookie的path属性可以有效的过滤哪些cookie可以发送给服务器【同时也仅在满足路径是出现在f12中】，哪些不发送。`

   `path属性是通过请求的地址来进行有效的过滤`

   ```java
   /*
   例子
       CookieA path=/工程路径
       CookieB path=/工程路径/abc
       请求地址为:http://ip:port/工程路径/a.html 【此时CookieA会被发送给服务器，B不发送】
       请求地址为:http://ip:port/工程路径/abc/a.html 【此时CookieA会被发送给服务器，B也发送】
   */
   
   ```

***Session 会话***

1. *什么是session？*

   答：`session是一个接口(HTTPSession)。`

   `		他是用来维护客户端和服务器之间关联的一种技术。`		

   `每个客户端都有自己对应的一个session，保存在服务器端。`

   `Session会话中，我们经常用来保存用户登录之后的信息`

   注意：session是浏览器和服务器的会话，唯一！！！

   > *cookie是保存在客户端，Session是保存在客户端的。*

2. *如何创建Session会话和获取(id号，是否为新)*

   ```java
   //第一次调用是创建session会话，后面调用就是获取前面创建好的session对象
   Session session = request.getSession();
   //判断是否为新的session会话（刚创建的）true表示就是刚创建的，false表示之前创建的。
   session.isNew();
   //获取每个Session的id 唯一
   session.getId();
   ```

3. *Session生命周期控制*

   ```java
   //设置session的超时时间，单位为秒s ，如果为负数(-1)就表示此会话永远不过期
   //【默认为1800s，即30分钟。】 因为在tomcat的conf目录下的web.xml中配置的 就是30分钟
   //			<session-timeout>30</session-timeout>
   session.setMaxInactiveInterval(int val);//超时是指规定时间内不动，如果动了，时间重新计算
   
   //1.如果想要修改整个tomcat下所有工程的session超时时间，就修改tomcat/conf/web.xml中session时间
   //2.如果想要修改整个某一个工程的session超时时间，就修改该工程下WEB_INF/web.xml中session时间，配置和tomcat的一样
   //3.如果只想修改某一个session的超时时间，就使用//3.如果只想修改某一个session的超时时间，就使用 
   
   //使session立马失效，超时 不是上面方法设置为0而是新的方法
   session.invalidate();
   ```

***浏览器，服务器和Session的关联***

1、Session为服务器创建，返回给浏览器的（通过响应标头）。

2、每次删除掉Session，服务器都会创建一个新的会话对象。【如果旧的session对象不释放就会导致服务器内存溢出，可以自己试试，明显发现服务器内存在增长！】



