package chapter05_LogicDecision.While;

public class DoWhileExercise01 {
    public static void main(String[] args) {
        // 1-200之间能被5整除但不能被3整除的个数
        int start = 1;
        int end = 200;
        int devCan = 5;
        int devNotCan = 3;
        int i = start;//
        int count=0;//记数器
        do {
            if (i % devCan == 0 && i % devNotCan != 0) {
                count++;
//                System.out.println("是：" + i);
            }
            i++;
        } while (i <= end);
        System.out.println("共：" + count);
    }
}
