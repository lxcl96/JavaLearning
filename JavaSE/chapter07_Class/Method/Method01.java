package chapter07_Class.Method;
import java.util.Scanner;

public class Method01 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        PersonDetail p1 = new PersonDetail();
        p1.speak();
        System.out.println("1+...+10000=" + p1.cal01());
        System.out.println("请输入一个值，计算1+...+n的和");
        int number = myScanner.nextInt();
        System.out.println("1+...+" + number + "=" + p1.cal02(number));

    }
}

class PersonDetail{
    int age;
    String name;
    //方法 即成员方法
    //访问修饰符 方法返回类型 方法名
    public void speak() {
        System.out.println("我是一个好人!");
    }
    public int cal01() {
        int sum = 0;
        for (int i = 1; i <= 10000; i++) {
            sum += i;
        }
        return sum;
    }
    public int cal02(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }
        return sum;
    }
}