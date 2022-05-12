package chapter15_Generics_.DIYGenerics;

public class tipsOfFunction {
}
/*
   本质:型方法和普通方法是一样的。只是放进去的参数没有了限制，想放啥就放啥！
    自定义泛型方法：【CustomMethodGenerics.java】
      修饰符 <T,R...> 返回类型 方法名(参数列表){}

      细节：
       1、泛型方法可以定义在普通类中，也可以定义在泛型类中
       2、当调用泛型方法时，泛型类型会确定【默认Object】
       3、public void eat(E e){} 修饰符后面没有<T,R...> eat方法是使用了泛型，而不是泛型方法【就是使用了类的泛型，只会在泛型类中出现】

       使用泛型：public void eat(E e, String s){}
       泛型方法：public <E e> void eat(E e, String s){}
 */