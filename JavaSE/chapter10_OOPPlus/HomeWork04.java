package chapter10_OOPPlus;

public class HomeWork04 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.testWork(new Calculator() {
            @Override
            public void work() {
                System.out.println("开始计算");
            }
        });
    }
}



interface Calculator {
    void work();
}

class CellPhone {
    //传递参数 是接口的匿名内部类
    public void testWork(Calculator c) {
        c.work();
    }
}