package chapter10_OOPPlus.final_;

public class tips {
    public static void main(String[] args) {

    }
}
/*
    final关建字：
    final可以修饰类、属性、方法和局部变量  --
    什么使用使用final呢？
        1、当不希望类被继承时，可以用final修饰
        2、当父类的某个方法不希望被子类 重写/覆盖（overwrite）时，可以用final修饰
            访问修饰符 [static] final  返回类型 方法名(形参){}
        3、当不希望类的某个属性被修改，用final
        4、当不希望某个局部变量被修改时，用final

     final注意事项：
        1、final修饰的属性又叫常量，一般用大写字母XX_XXX_XX表示
        2、final修饰的属性在定义时，必须赋初始值，并且以后不可以更改，赋值可以在下面位置之一 --finalDetail01.java
            a）在定义时， public [static] final int n1 = 100；
            b）在构造器中
            c）在代码块中
        3、如果final修饰的属性是静态的[static]，则初始化位置只能是  --finalDetail02.java
            a）在定义时
            b）在静态代码块中，【构造器中不可以】
        4、final类不可以继承，但是可以实例化 【A2类】 --final01.java
        5、如果类不是fina类，但是其中方法是final方法，  --finalDetail03.java
            则该类可以被继承【即final方法可以被继承】，但是类中的final方法不能被重写
        6、final不能修饰构造器
        7、final和static搭配更好，不会导致类被加载  ---finalDetail04.java
        8、final类应用如：String类，Integer类，Double类，Float类Boolean类等都是final
 */