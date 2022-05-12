***jsp***

+ jsp全称是Java Server pages，即Java服务器页面

+ jsp的主要作用就是代替servlet程序回传给html页面数据【servlet回传数据比较困难】

------

***jsp页面的本质***

*jsp页面本质上就是一个servlet程序！*

当我们第一次访问jsp页面时，tomcat服务器会帮我们把jsp页面翻译成为一个Java源文件。并且对它进行编译成.class文件。当我们打开Java源文件时，不难发现里面就是servlet程序代码！

------

***JSP头部的page指令***

jsp的page指令可以修改jsp页面中一些重要的属性或行为。

```java
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
```

1. language属性		表示jsp翻译后是什么语言文件。暂时只支持Java

2. contentType属性    表示jsp中返回的数据类型是什么，也就是源码中的response.setContentType("contentType","text/html")

3. pageEncoding属性    表示当前jsp页面的字符集编码

4. import属性          用于导入包导入类

5. autoFlush属性    【给out输出流使用】，设置当out输出缓冲流满了之后，是否自动刷新。默认值为true

6. buffer属性           【给out输出流使用】 设置缓冲区的大小，默认是8kb

7. errorPage属性     设置当jsp页面运行出错自动跳转到指定页面  

   ```java
   // 注：路径一般都是以 / 开头 表示http://localhost:8080/工程路径    也就是代码web目录
   ```

​	8. isErrorPage属性    设置当前jsp页面是不是错误页面，默认是false。【如果设置true，可以获取异常信息】

​	9. session属性     设置访问当前页面会不会创建HttpSession对象，默认是true

 	10. extends属性    设置jsp翻译出来的java类默认继承谁

------

***jsp中的常用脚本***

- **声明脚本**

  ```java
  //格式 ：<%! 声明java代码 %>
  //作用：可以给jsp翻译出来的Java类定义属性和方法，甚至是静态代码块，内部类等。
  ```

- **表达式脚本**

  ```java
  //格式 ：<%= 表达式 %>
  //作用：在jsp页面上输出数据
  //特点：① 所有的表达式脚本都会被翻译到_jspService方法中
  //	    ② 所有的表达式都会被翻译成out.print()输出到页面上
  //      ③ 由于表达式脚本都在_jspService()方法中，所以_jspService()方法中所有对象都可以直接使用
  //	    ④ 里面不能添加分号 ;
  ```

- ***代码脚本***

  ```java
  //格式 ：<% Java语句 %>
  //作用：可以在jsp页面中编写我们自己需要的功能（java语句，如果是方法需要用声明脚本）
  //特点：① 所有的代码脚本都会被翻译到_jspService方法中
  //	    ② 由于代码脚本都在_jspService()方法中，所以_jspService()方法中所有对象都可以直接使用
  //      ③ 代码脚本 可以由多个代码脚本块组合成完成的Java语句【即：所有的代码脚本是一个整体，变量通用】
  //	    ④ 可以添加分号 ;
  //		⑤ 可以和表达式脚本 组合使用，因为都是在_jspService()同一个方法内
  ```

------

***jsp的三种注释***

```jsp
<!-- html的注释-->
	特点：html注释会被翻译到Java源代码中，输出到html页面。
<% 
	//单行Java注释
	/*多行Java注释*/
%>
	特点：会被翻译到Java源代码中，不会输出到html页面。
<%-- 这是jsp注释--%>
	特点：可以注释掉一切，不会翻译到Java源代码
```

------

***jsp中的九大内置对象***

**jsp内置对象**：是指tomcat在翻译jsp页面成为Servlet源代码后，内部提供的九大对象，叫内置对象！

​		【就是_jspService()方法中可以使用的对象！】

 + *request，请求对象*

 + *response，响应对象*

 + *pageContext，jsp的上下文对象*

 + *session，会话对象*

 + *application，ServletContext对象 也就是servlet上下文对象*

 + *config，servletConfig对象 也就是servlet 配置对象*

 + *out，jsp的输出流对象*

 + *page，指向当前jjsp的对象*

 + *exception，jsp异常对象 【仅在头部的page指令中开启 errorPage=true 才有】*

   ------

   [**四个域对象**：](../08_jsp/web/scope.jsp)

   ​	pageContext	==>	PageContextImpl 类	==>		***当前jsp页面范围内有效***

   ​	request	==>	HttpServletRequest 类	==>	***一次请求内有效***

   ​	session	==>	HttpSession 类	==>	***一个会话范围内有效（不关闭浏览器，不清除session）***

   ​	application	==>	ServletContext 类	==>	***整个web工程范围内有效（重启/重新部署才会失效）***

   ~~域对象：是可以像Map一样存取数据，这四个域对象功能一样，只是作用范围不一样！~~

   ***从小到大的使用顺序***：pageContext	-->	request	 -->	session	-->	application	【仅当最小的不满足再去用最大的】

   ------

   [***jsp中的out输出和response.getWriter输出的区别***](../08_jsp/web/output.jsp)

![](D:\JavaWork\JavaWeb\Note\jsp中的out输出和response.getWriter输出的区别.jpg)

​	原因：当jsp页面中所有代码执行完成后会执行下面两个操作。

​				1、执行out.flush()操作，会把out缓冲区中的数据追加到写入的response缓冲区末尾

​				2、会执行response的刷新操作，把全部数据写给客户端

推荐使用：out.write() 【因为jsp页面中底层用的就是这个】

------

***out的print方法和write的方法区别***

```java
out.print()  //jsp中print方法，无论你传递什么参数，都会被转成String类型直接输出来
out.write()	 //仅输出字符串没问题，因为你输入的别的如整型，会被转成该数字对应的ASCII码然后追加到out的缓冲区内，你需要flush一下才能显示出现
```

总结：out.print()适合输出所有类型，out.write()只能正确输出字符串

------

[***jsp的常用标签***](../08_jsp/web/include)

+ *jsp静态包含*

  特点：

  ​	1、静态包含 会将被的jsp文件不会被翻译成对应java文件且被编译

  ​	2、静态包含其实就是把被包含的jsp文件的html页面代码 拷贝到主页面上

  ```java
  <%@ include file="路径"%> //路径一般以 / 开头 代表 http://localhost:8080/工程路径
  ```

+ *jsp动态包含*

  ​	特点：

  ​		1、动态包含 会将被包含的jsp文件翻译成java文件且被编译

  ​		2、动态包含底层不是直接将被包含的html页面直接放到主页面上，而是使用 代码调用：org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/include/header.jsp", out, false); 显示在主页面上的。

  ​		3、动态包含还可以传递参数

  ```java
  <jsp:include page="路径"></jsp:include>  //路径一般以 / 开头 代表 http://localhost:8080/工程路径
  ```

  ![](D:\JavaWork\JavaWeb\Note\动态包含原理.jpg)

+ *jsp标签转发*

  说明：就是servlet程序中的请求转发

  ```java
  <jsp:forward page="路径">请求转发</jsp:forward> //路径一般以 / 开头代表 http://localhost:8080/工程路径
  ```

  ------

  ***jsp中Listener监听器***

  ​	1、Listener监听器是JavaWeb三大组件之一。

  ​			`三大组件：Servlet程序、Filter过滤器、Listener监听器`

  ​	2、Listener监听器他是JavaEE的规范，就是接口

  ​	3、监听器的作用是，监听某种事务的变化。然后通过回调函数，反馈给客户（程序）做一些相应的处理。

  ​    目前常用的就是：***ServletContextListener监听器***

  ***ServletContextListener监听器***

  - ServletContextListener监听器可以监听ServletContext对象的创建和销毁 【ServletContext对象在web工程启动时创建，在web工程停止时销毁】	

  - 监听到ServletContext对象在创建和销毁之后分别调用ServletContextListener监听器的方法去反馈。

    ```java
    //监听器的两个方法
    //在ServletContext对象创建后马上调用，做初始化
    public void contextInitialized(ServletContextEvent sce);
    
    //在ServletContext对象销毁之后调用
    public void contextDestroyed(ServletContextEvent sce);`
    ```

    [**使用ServletContextListener监听器步骤:**](../08_jsp/src/com/ly/listener/)

    1. 编写一个类去实现ServletContextListener接口

    2. 实现他两个回调方法

    3. 在web.xml中配置监听器

       ```xml
       <!--web.xml -->
       <listener>
               <listener-class>com.ly.listener.MyServletContextListenerImpl</listener-class>
           </listener>
       ```

       

    