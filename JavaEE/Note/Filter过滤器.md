***Filter过滤器***

`filter过滤器是Javaweb的三大组件（servlet程序，listener监听器，filter过滤器）之一`

`filter过滤器是JavaEE规范，即一个接口`

*`作用：拦截请求，过滤响应`*

***拦截请求常见的应用场景：***

1. 权限检查
2. 日记操作
3. 事务管理
4. ...........

***Filter使用:*****

+ `编写一个类实现Filter接口`
+ `实现过滤方法doFilter()`
+ 在web.xml中配置拦截路径

***Filter生命周期：***

filter过滤器生命周期包含几个方法（先后顺序）：

1. 构造器方法 `项目启动时执行`
2. init初始化方法 `项目启动时执行`
3. doFilter过滤方法 `访问过滤路径是时执行`
4. destory销毁方法  `web工程销毁时执行`

*注意：和servlet生命周期一样*

------

***FilterConfig类***

是filter配置类，tomcat每次创建Filter时都会创建一个FilterConfig类

------

***FilterConfig类的作用是获取Filter过滤器的配置内容：***

+ 获取Filter的别名/filter名称，也就是web.xml中配置的 <filter-name>adminFilter</filter-name>

  ```java
  public String getFilterName()
  ```

+ 获取在Filter中配置初始化参数，也就是web.xml中配置的 <init-param>xxxx</init-param>

  ```java
  public String getInitParameter(String name) //获取单个参数
  public java.util.Enumeration<E> getInitParameterNames()//获取所有参数
  ```

+ 获取ServletContext对象

  ```java
  public ServletContext getServletContext()
  ```

注意：和ServletConfig类似

------

***FilterChain过滤器链：***

[^FilterChain]: FilterChain 是 servlet 容器为开发人员提供的对象，它提供了对某一资源的已过滤请求调用链的视图。过滤器使用 FilterChain  调用链中的下一个过滤器，如果调用的过滤器是链中的最后一个过滤器，则调用链末尾的资源。

**目的：**为了连续调用多个过滤器（如果有过滤器），或者调用资源（没有过滤器）

------

#### 如果web.xml中配置了多个相同访问路径的Filter过滤器，tomcat服务器会在访问时按照先后顺序，顺序执行

------

***多个Filter程序执行特点：***

1. 所有Filter过滤器和目标资源默认都是在同一个线程中
2. 多个Filter程序共同执行时都使用同一个request对象 ，原因是FilterChain中传递请求和响应参数的。

------

***FIlter过滤器拦截路径三种方法：***

1. 精确匹配

   ```xml
   <url-pattern>/admin/admin.html</url-pattern>
   ```

2. 目录匹配

   ```xml
   <url-pattern>/admin/*</url-pattern>
   ```

3. 后缀名匹配

   ```xml
   <url-pattern>/admin/*.html</url-pattern>
   ```

------

