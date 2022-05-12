package chapter10_OOPPlus.classVariable;

public class tips {
    public static void main(String[] args) {

    }
}
/*  什么是类变量？
      类变量也叫静态变量/静态属性，是该类的所有对象共享的变量，任何一个该类的对象去访问他时，取到的都是相同值，
      同样任何一个该类的对象去修改他时，修改的ye'shi同一个变量

    如何定义类变量？
      语法：
      访问修饰符 static 数据类型 变量名；【推荐】
      static 访问修饰符 数据类型 变量名；

    如何访问类变量？
      类名.类变量名 Child.count1;【推荐】
      或者对象名.类变量名 c1.count1;【静态变量的访问修饰符的访问权限和范围 和 普通属性是一样的】


      类方法同类变量
 */