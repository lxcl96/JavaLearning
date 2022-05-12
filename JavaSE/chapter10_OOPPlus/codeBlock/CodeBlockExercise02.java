package chapter10_OOPPlus.codeBlock;

public class CodeBlockExercise02 {
    /*
        注意看有没有继承关系，别想当然了
        输出：
        1、静态成员sam初始化
        2、static块执行

            Sample默认构造函数被调用  【错的，和Sample无继承关系 这里继承的是Object()】
        3、sam1成员初始化
        4、Test默认构造函数被调用
     */
}

class Sample
{
    Sample(String s)
    {
        System.out.println(s);
    }
    Sample()
    {
        System.out.println("Sample默认构造函数被调用");
    }
}
class Test{
    Sample sam1=new Sample("sam1成员初始化");//3
    static Sample sam=new Sample("静态成员sam初始化 ");//1
    static{
        System.out.println("static块执行");//2
        if(sam==null)System.out.println("sam is null");
    }
    Test()//构造器
    {
        //super（） 和Sample无继承关系 这里继承的是Object()
        //本类普通代码块和普通属性
        System.out.println("Test默认构造函数被调用");//4
    }
    //主方法
    public static void  main(String  str[])
    {
        Test a=new Test();//无参构造器
    }

}


