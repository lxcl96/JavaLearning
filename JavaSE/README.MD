***Java学习记录

注意：

1、编译后每一个类都会生成一个class文件，即一个源文件最多只能有一个public类，其他类个数不限

2、如果源文件包含一个public类，则文件名必须按该类名命名。（文件名和类名一样）

3、一个源文件中最多只能有一个public类，其他类个数不限。*也可将main方法写在非public类中，然后指定运行非public类，这样入口方法就是非public的main方法（详见helloworld中java Dog和java hello）

4、System.out.println("北京全聚德\r天津"); 输出的是天津全聚德，\r（回车，光标回到行首）表示从头开始替换

5、文档注释 javadoc -d 文件夹名 -xx -yy Demo3.java 写在类中，可被javadoc解析生成一套网页文件