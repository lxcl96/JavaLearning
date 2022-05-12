package chapter07_Class.Method;

public class MethodExercise01 {
    public static void main(String[] args) {
        AA aa = new AA();
        int number = 111;
        if (aa.numberDecid(number))
            System.out.println(number + "是偶数");
        else
            System.out.println(number + "不是偶数");
    }
}
class AA {

    public boolean numberDecid(int n) {
        if (n % 2 == 0)
            return true;
        return false;
    }
}