package chapter08_intermediate.Project_;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class SmallChangeSys {
    public static void main(String[] args) {
        //1、先要显示界面，并可以选择菜单，给出相应提示
        boolean loop = true;//外部循环
        int choice;//选择1-4
        char confirm = 'n';//退出确认
        double balance = 0;//余额默认为0
        Random ran = new Random();
        double add = 0;//收益
        String details = "";//拼接收益和支出

        String withdraw = "";//支出店名
        double mius = 0;//支出金额

//        Date date = new Date();//获取当前时间
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // 以参数格式 格式化时间
//        System.out.println(sdf.format(date));//格式化后时间格式
        Scanner myScanner = new Scanner(System.in);
        do {
            System.out.println("-----------------零钱通菜单-----------------");
            System.out.println("              1 零钱通明细");
            System.out.println("              2 收益入账");
            System.out.println("              3 消费");
            System.out.println("              4 退     出");
            System.out.println("请选择(1-4)：");
            choice = myScanner.nextInt();
            if (choice == 1) {
                System.out.println("-----------------零钱通明细-----------------");
                //收益入账和消费放在数组或 拼接
                System.out.println(details);

            } else if (choice == 2) {
                System.out.println("-----------------收益入账-----------------");
                add = ran.nextInt(1000);
                balance += add;
                details +=  "收益入账金额  +" + add + "  "
                        + new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())
                        + "  余额：" + balance + "\n";
                System.out.println("收益入账  +" + add);
            } else if (choice == 3) {
                System.out.println("-----------------消费-----------------");
                System.out.println("请输入消费名称：");
                withdraw = myScanner.next();
                System.out.println("请输入消费金额");
                mius = myScanner.nextDouble();
                if (mius > balance){
                    System.out.println("当前余额：" + balance + "小于要支取的金额：" + mius + "，请核查！");
                    System.out.println("消费失败");
                    continue;
                }
                balance -= mius;
                details +=  withdraw + "      -" + mius + "  "
                        + new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())
                        + "  余额：" + balance + "\n";
                System.out.println("消费成功");
            } else if(choice == 4) {
                System.out.println("-----------------退     出-----------------");


                while (true) {
                    System.out.println("你确定要退出吗？y/n");
                    confirm = myScanner.next().charAt(0);
                    //  如果是 退出循环
                    if (confirm == 'y') {//字符串等于用equals 我是char
                        loop = false;
                        break;
                    }
                }

            } else {
                System.out.println("输入有误，请重新输入！");
            }

        }while (loop);
        System.out.println("程序结束!");
    }
}
