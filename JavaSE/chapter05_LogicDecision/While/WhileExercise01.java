package chapter05_LogicDecision.While;

public class WhileExercise01 {
    public static void main(String[] args) {
        int start = 1;
        int end = 100;
        int i = start;
        while (i <= end) {
            if (i % 3 ==0) {
                System.out.println(i);
            }
            i++;
        }
    }
}
