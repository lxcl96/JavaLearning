package chapter05_LogicDecision.For;

public class MulForExercise03 {
    public static void main(String[] args) {
        for (int i = 1;i <=9; i++) {
            for (int j = 1;j <=i; j++) {
                int ji = i * j;
                System.out.print(j + "*" + i + "=" + ji);
                System.out.print("    ");
            }
            System.out.println(' ');
        }
    }
}
