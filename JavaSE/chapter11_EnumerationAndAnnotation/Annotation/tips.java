package chapter11_EnumerationAndAnnotation.Annotation;

public class tips {

}
/*
    1、注解（Annotation）也被称为元数据（MetaData），用于修饰包、类、方法、属性构造器、局部变量等数据信息

    2、和注释一样，注解不影响程序逻辑，但注解可以被编译或运行，相当于嵌入在代码中的补充信息

    3、在JavaSE中注解是用来标记过时的功能，忽略警告等
       在JavaEE中比较重要一般是用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的冗余代码和XML配置

    使用Annotation要在前面加上@符号，并把该Annotation当成一个修饰符使用。用于修饰它支持的程序元素
     **三个基本的Annotation：
     ①、@Override：限定某个方法，是重写父类方法，该注解只能用于方法
     ②、deprecated：表示某个程序元素（类、方法等）已过时
     ③、@SupressWarnings：抑制编译器警告
 */