package chapterFormer;// java输入和输出
import java.util.Scanner;


public class Input {
    public static void main(String[] args) {
        /*
        步骤：1、导入需要的包（类）
             2、创建Scanner 对象
             3、接收用户的输入,使用相关的方法
         */
        Scanner myScanner= new Scanner(System.in); //new 创建一个新对象 （类）
        System.out.println("请输入名字：");
        String name = myScanner.next();//接收用户的输入
        System.out.println("请输入年龄：");
        int age = myScanner.nextInt();//接收用户的输入
        System.out.println("请输入薪水：");
        double salary = myScanner.nextDouble();//接收用户的输入

        System.out.println("人的信息如下：");
        System.out.println("name=" + name + " age= " + age + " salary " + salary);
    }
}
