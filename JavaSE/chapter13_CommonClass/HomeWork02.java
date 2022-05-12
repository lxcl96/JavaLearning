package chapter13_CommonClass;

import java.util.Scanner;

public class HomeWork02 {

    private static String nameInCheck(){
        String name;
        System.out.print("请输入用户名:");
        name = new Scanner(System.in).next();
        try {
            if (name.length() < 2 || name.length() > 4 ) {
                System.out.println("用户名长度介于2-4");
                System.exit(-1);
            }
        } catch (NullPointerException e) {
            System.out.println("禁止输入空值");
            System.exit(-1);
        }
        return name;
    }
    //int不行 因为输入0000，0001等只认为是一个 所以还是需要String类型
    private static String passInCheck() {
        String password;
        System.out.print("请输入密码:");
        password = new Scanner(System.in).next();
        try {
            if (password.length() != 6 ) {
                System.out.println("密码长度必须为6");
                System.exit(-1);
            }
            char[] ch = password.toCharArray();
            for (int i = 0; i < ch.length; i++) {
               if (!Character.isDigit(ch[i])) {
                   System.out.println("密码必须为纯数字：");
                   System.exit(-1);
               }
            }
        } catch (NullPointerException e) {
            System.out.println("禁止输入空值");
            System.exit(-1);
        }
        return password;
    }

    private static String mailInCheck() {
        String email;
        System.out.print("请输入电子邮箱:");
        email = new Scanner(System.in).next();
        if (email == null) {
            System.out.println("禁止输入空值");
            System.exit(-1);
        }
        if (!(email.contains("@") && email.contains("."))) {
            System.out.println("电子邮箱必须同时包含@和.");
            System.exit(-1);
        }
        //下面还要统计@和.出现的次数 只能是一次
        //还要比较@ 和.的位置 就不写了
        return email;
    }

    public static void main(String[] args) {
        String name;
        String password;
        String email;
        System.out.println("信息注册界面：");
        name = nameInCheck();
        password = passInCheck();
        email = mailInCheck();
        if (name != null && password != null && email != null) {
            System.out.println("恭喜，您已注册成功！");
//            System.out.println("个人信息如下：" + "\n姓名：" + name + "\n密码：" + password + "\n邮箱：" + email);
            System.out.println(String.format("个人信息如下：\n姓名：%s\n密码：%s\n邮箱：%s", name, password, email));
        }
        System.out.println("程序正常结束。");


    }
}
