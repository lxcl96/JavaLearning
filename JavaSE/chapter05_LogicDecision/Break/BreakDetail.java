package chapter05_LogicDecision.Break;

public class BreakDetail {
    public static void main(String[] args) {
        //lable 标签用法 break来指定 退出哪一层标签 不指定默认退出最近的
        lable1:
            for (int j = 0; j <4; j++) {
            lable2:
                for (int i = 0; i < 10; i++) {
                    if (i == 2)
                        break lable1;
//                        break; //退出lable2
                    System.out.println("i = " + i);
                }
            }
    }
}
