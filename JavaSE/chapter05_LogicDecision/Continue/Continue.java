package chapter05_LogicDecision.Continue;

public class Continue {
    public static void main(String[] args) {
        lable1:
        for (int j = 0; j < 4; j++) {
            lable2:
            for (int i = 0; i < 10; i++) {
                if (i ==2)
//                    continue;//不指定标签，默认退出最近的 lable2
                    continue lable1;
                System.out.println("i = " + i);
            }

        }
    }
}
