package chapter05_LogicDecision;

public class HomeWork05 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 5 != 0) {
                System.out.print(i + "  ");
                count++;
                //在里面判断就不会 出现 count = 5 输出两次
                if (count % 5 == 0 ) {
//                count = 0;
                    System.out.println();
                }
            }
            //需要排除到0 因为 0 % 5 = 0


        }
    }
}
