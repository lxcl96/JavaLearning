package chapter05_LogicDecision.While;

public class WhileExercise02 {
    public static void main(String[] args) {
        int start = 40;
        int end = 200;
        int i = start;
        while (i <= end) {
            if (i % 2 ==0) {
                System.out.println(i);
            }
            i++;
        }
    }
}
