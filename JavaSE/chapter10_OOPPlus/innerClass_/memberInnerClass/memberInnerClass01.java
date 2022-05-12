package chapter10_OOPPlus.innerClass_.memberInnerClass;

public class memberInnerClass01 {
    public static void main(String[] args) {
        new Outer01().t1();
    }
}
class Outer01 {
    private int n1 = 10;
    public String name = "张三";

    class Inner01 {
        public void say() {
            System.out.println("Outer01的n1=" + n1 + "        Outer01的name=" + name);

            //调用需要创建 内部类对象
        }

        //调用需要创建 内部类对象  类Inner01 成员位置不可以直接new
    }

    //调用需要创建 内部类对象 类Outer01 成员位置不可以直接new 只能在方法或代码块中调用

    public void t1() {
        Inner01 inner01 = new Inner01();
        inner01.say();
    }

    public Inner01 t2() {
        return new Inner01();
    }

}