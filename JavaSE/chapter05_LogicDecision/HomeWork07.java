package chapter05_LogicDecision;

public class HomeWork07 {
    public static void main(String[] args) {
        for (char a = 'a';a <= 'z'; a++) {
            System.out.print(a + " " + Character.toUpperCase(a) + " " + (char)(a - 32));
            System.out.println();
        }
    }
}
