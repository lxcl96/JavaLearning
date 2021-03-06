package chapter15_Generics_.DIYGenerics;

public class tipsOfInterface {
}
/*
    自定义泛型接口：  CustomInterfaceGenerics.java
     含义：我们自己写的一个类或者接口后面跟上<E>，那么这个类或接口就叫做自定义泛型

     基本语法：
       interface 接口名<E,T,R...>{
         成员
       }

     注意细节：
      x1、普通成员可以使用泛型（如：属性，方法）【接口中没有非static的】
      2、使用泛型的数组不能初始化 E[] e = new E[8]
            【很好理解，因为没传入参数，编译器不知道是什么类型的怎么创建？】
      3、静态方法/属性中，不能使用类的泛型
            【原因同2，因为静态变量是在类加载时进行的(此时还没有创建对象)，而泛型是在创建对象时指定 的】
      4、泛型类的类型【自己传的】，是在继承接口或者使用接口时确定的【就是继承接口或者使用接口时自己传的】
      5、如果在创建对象时。没有指定泛型，默认为Object
 */