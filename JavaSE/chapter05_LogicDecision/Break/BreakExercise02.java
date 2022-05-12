package chapter05_LogicDecision.Break;
import java.util.Scanner;


public class BreakExercise02 {
    public static void main(String[] args) {
        int accNum = 3;
        String accName = "丁真";
        String accPass = "666";
        Scanner myScanner = new Scanner(System.in);
        for (int i = 1; i <= accNum; i++) {
            System.out.println("请输入登陆用户名：");
            String name = myScanner.next();
            System.out.println("请输入登陆密码：");
            String pass = myScanner.next();
            System.out.println(pass);
            // java的 string 比较不能用 ==
            // 因为 对于string ==使用的是内存地址比较 而不是实际内容
            //可以用string的函数 str.equals
            if (name.equals(accName) && pass.equals(accPass)) {
                System.out.println("登陆成功");
                break;
            }
            System.out.println("用户名或密码输入错误，您还有" + (accNum - i) + "次机会！");
        }
    }
}
