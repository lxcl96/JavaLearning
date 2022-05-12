package chapter08_intermediate.Project_;

import java.util.Random;
import java.util.Scanner;

/*
    零钱通面向对象（OOP）编程
    用到对象  工具类
 */
public class SmallChangeSysOOP{
    //1、先要显示界面，并可以选择菜单，给出相应提示
    private boolean loop = true;//外部循环
    private int choice;//选择1-4
    private char confirm = 'n';//退出确认
    private double balance = 0;//余额默认为0
    Random ran = new Random();
    private double add = 0;//收益
    private String details = "";//拼接收益和支出

    private String withdraw = "";//支出店名
    private double mius = 0;//支出金额

    //        Date date = new Date();//获取当前时间
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // 以参数格式 格式化时间
//        System.out.println(sdf.format(date));//格式化后时间格式
    Scanner myScanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("-----------------零钱通菜单-----------------");
        System.out.println("              1 零钱通明细");
        System.out.println("              2 收益入账");
        System.out.println("              3 消费");
        System.out.println("              4 退     出");
        System.out.println("请选择(1-4)：");
    }

    public void Detail() {

    }

}
