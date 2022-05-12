package chapter10_OOPPlus;

public class HomeWork02 {

}


class TestFrock {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());

        Frock frock1 = new Frock();
        System.out.println(frock1.getSeriaNumber());
        Frock frock2 = new Frock();
        System.out.println(frock2.getSeriaNumber());
        Frock frock3 = new Frock();
        System.out.println(frock3.getSeriaNumber());

    }
}

class Frock {
    private static int currentNum = 100000;
    private int seriaNumber;

    public static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }

    public int getSeriaNumber() {
        return seriaNumber;
    }

    public Frock() {
        seriaNumber = getNextNum();
    }
}