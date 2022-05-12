package chapter10_OOPPlus.abstractClass.application;

public class Introduce {
    public static void main(String[] args) {
        new AA().job();
        new BB().job();
    }
}
class AA{
    public void job() {
        //计算时间的话 每个job都要写开始,结束比较麻烦
        //利用抽象方法复用
        long sum = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 800000; i++) {
            sum += i;
        }

        long end = System.currentTimeMillis();
        System.out.println(" AA " + (end - start));
    }
}

class BB{
    public void job() {
        //计算时间的话 每个job都要写开始,结束比较麻烦
        //利用抽象方法复用
        long sum = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 800000; i++) {
            sum *= i;
        }

        long end = System.currentTimeMillis();
        System.out.println(" BB " + (end - start));
    }
}