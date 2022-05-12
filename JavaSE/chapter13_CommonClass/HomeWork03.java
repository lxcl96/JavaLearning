package chapter13_CommonClass;
import java.util.Scanner;
/*
    输入  Han Shun Ping               输出      Ping,Han .S
         Willian Jefferson Cliton             Cliton,Willian .J
 */
public class HomeWork03 {
    public static void main(String[] args) {
        System.out.println("请输入名称：");
        Scanner scanner = new Scanner(System.in);
        //指定分隔符  默认遇到空格和回车就结束
        scanner.useDelimiter("\n");
        String name = scanner.next();

        String[] str = name.split(" ");
        if (!(str.length == 3 ) || str[0].isEmpty() || str[1].isEmpty() || str[2].isEmpty()) {
            System.out.println("格式不正确");
            System.exit(-1);
        }
        System.out.println(str[2] + "," + str[0] + " ." + str[1].charAt(0));//String.format("%s %s %s") 或者使用这个格式

    }

}
