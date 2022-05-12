package chapter10_OOPPlus.main_;

public class tips {
    public static void main(String[] args) {

    }
}
/*
    深入理解main方法：
    解释main方法的形式：public static void main(String[] args) {}
    1、main方法是被java虚拟机（jvm）调用
    2、jvm需要调用类的main方法因此，该方法的访问权限必须是public
    3、jvm在执行main()方法时不必创建对象，所以该方法必须是static
    4、该方法接收String类型的数组参数，该数组中保存执行java命令时传递给所运行的类的参数
    5、命令行格式：java 执行的程序 参数1 参数2 参数3 见hello.java

    //因为main是静态方法，所以只能使用静态方法和静态属性
    //如果非要访问非静态的属性和方法就必须 先实例化一个对象再使用 new A()

 */