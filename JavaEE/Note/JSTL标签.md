***JSTL标签库***

JSTL标签库即jsp Standard Tag Library 也就是jsp标准标准标签库。

`EL表达式是为了替换 jsp表达式脚本`

`JSTL是为了替换 jsp代码脚本`

***JST五个不同的标签库***

| 功能范围         | url                                    | 前缀 |
| ---------------- | -------------------------------------- | ---- |
| 核心标签库--重点 | http://java.sun.com/jsp/jstl/core      | c    |
| 格式化           | http://java.sun.com/jsp/jstl/fmt       | fmt  |
| 函数             | http://java.sun.com/jsp/jstl/functions | fn   |
| 数据库(不使用)   | http://java.sun.com/jsp/jstl/sql       | sql  |
| XML(不使用)      | http://java.sun.com/jsp/jstl/xml       | x    |

JSTL标签库的使用步骤：

+ 要使用的标签库jar包导入到项目中

+ 使用 taglib 指令导入标签库

  ```jsp
  <!--在jsp中使用jstl 需要先引入标签库-->
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
  ```

***JSTL之core 核心库***

1. `<c:set scope="request" var="abc" value="你好" /> 作用：set标签可以往彧中保存数据`

   scope属性：表示数据存放在哪个域  request，默认是page

   var属性：表示存放数据的key

   value属性：表示存放数据的value值

2. `<c:if test="${12==12}"></c:if>` 作用：用作if判断

   test属性做判断，然后使用el表达式输出

3. 