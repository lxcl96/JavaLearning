## ***ThreadLocal类***

是jdk中提供用于解决多线程数据安全的工具类。

ThreadLocal它可以给当前线程关联一个数据（可以是普通变量，对象或数组，集合），这样就可以避免其他线程访问到这个数据。

***ThreadLocal的特点***：

+ `ThreadLocal可以为当前线程关联一个数据。（它可以像Map一样存取数据，key为当前线程）`
+ `每个ThreadLocal对象，只能为当前线程关联一个数据，如果要为当前线程关联多个数据，就需要使用多个`ThreadLocal对象实例。
+ `每个ThreadLocal对象实例定义的时候，一般都是static 类型`
+ `ThreadLocal中保存的数据，在线程被销毁后，由jvm虚拟机自动释放`

------

