package chapter10_OOPPlus.abstractClass;

public class abstractExercise {
    public static void main(String[] args) {
        CommonEmployee lh = new CommonEmployee("李华", 10001, 30000);
        Manager wm = new Manager("王名", 000001, 50000, 350000);

        lh.work();
        wm.work();
    }
}
