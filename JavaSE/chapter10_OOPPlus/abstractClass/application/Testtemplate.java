package chapter10_OOPPlus.abstractClass.application;

public class Testtemplate {
    public static void main(String[] args) {
        new A().calculate();
        new B().calculate();
    }
}
abstract class JobClass {
    //模板类
    public void calculate() {
        //计算时间的话 每个job都要写开始,结束比较麻烦
        //利用抽象方法复用
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println(" calculate " + (end - start));
    }
    public abstract void job();
}

class A extends JobClass {
    @Override
    public void job() {
        long sum = 0;
        for (int i = 0; i < 800000; i++) {
            sum += i;
        }
        System.out.println("A");
    }
}

class B extends JobClass {
    @Override
    public void job() {
        long sum = 0;
        for (int i = 0; i < 800000; i++) {
            sum *= i;
        }
        System.out.println("B");
    }
}