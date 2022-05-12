package chapter10_OOPPlus.classVariable;

public class StaticMethodDetail {
    public static void main(String[] args) {

    }
}
/*  【静态方法只能访问静态属性和静态方法，而且不能用this】
    【普通方法即可以访问静态属性和静态方法，也可以访问非静态方法和属性。能用this】
    1、类方法和普通方法都是随着类的加载而加载，将结构信息存储在方法区：
    类方法中无this参数,也无super
    普通方法中隐含this参数
    2、类方法可以通过类名来调用，也可以通过对象名调用
    3、普通方法必须通过对象名（实例化）来调用

 */
class test {
    private String name1 = "小猪";
    public static String name2 = "小狗";
    public void f4(){}
    public static void f3(){}
    //普通方法 可以用this （即可以访问普通变量，也可以访问类变量）
    public void f2() {
        System.out.println("name2 = " + this.name2);//普通方法可以访问静态属性
        System.out.println("name1 = " + this.name1);//普通方法可以访问非静态属性
        System.out.println("name2 = " + name2);
        System.out.println("name1 = " + name1);
        f1();//普通方法可以访问静态方法
        f4();////普通方法可以访问普通方法
    }
    //静态方法只能访问静态属性，不能访问普通变量
    public static void f1() {
        System.out.println("name2 = " + name2);//静态方法只能访问静态属性
//        System.out.println("name1 = " + name1);//静态方法不能访问普通变量
//        f2();//静态方法不能用非静态方法
        f3();//静态方法可以用静态方法
    }
}