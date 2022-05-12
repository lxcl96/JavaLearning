package chapter07_Class;

import java.util.Scanner;


public class HomeWork14 {

    public static void main(String[] args) {
        //Math.random()大于等于0 且小于1
        //Math.random() * 3 大于等于0 且小于3
        Scanner myScanner = new Scanner(System.in);
        Person p = new Person();
        int ret = 0;
        for (int i = 0; i <= 2; i++) {
            System.out.println("请出拳：0：石头 1：剪刀 2：布");
            int first = myScanner.nextInt();
            ret = p.guessFirst(first, ret);
            System.out.println("Tom目前赢了 " + ret + " 次!\n========================================");
        }


    }
}

/*
    有个人Tom 设计他的成员变量 成员方法 可以和电脑猜拳 电脑每次生成 0 1 2
    0：石头
    1：剪刀
    2：布
    并且可以显示Tom的输赢次数
 */
class Person {
    int fist;
    String[] arr = {"石头", "剪刀", "布"};

    public Person(int fist) {
        this.fist = fist;
    }

    public Person() {
    }

    public int guessFirst(int first, int ret) {
        //获取系统拳
        int sysFirst = (int) (Math.random() * 3);
        if (first - sysFirst == -1 || first - sysFirst == 2) {
            System.out.println("您出 " + arr[first] + " ，电脑出 " + arr[sysFirst] + " ，您赢了！");
            ret++;
        } else if (sysFirst == first) {
            System.out.println("您出 " + arr[first] + " ，电脑出 " + arr[sysFirst] + " ，平手！");
        } else {
            System.out.println("您出 " + arr[first] + " ，电脑出 " + arr[sysFirst] + " ，您输了！");
        }
        return ret;
    }
}