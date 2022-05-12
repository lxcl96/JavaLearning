package chapter05_LogicDecision.Break;

public class BreakExercise01 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        for (; i <= 100;i++) {
            sum += i;
            if (sum > 20)
                break;
        }
        System.out.println(i);
    }
}
