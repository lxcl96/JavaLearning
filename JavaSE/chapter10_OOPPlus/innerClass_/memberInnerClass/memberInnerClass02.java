package chapter10_OOPPlus.innerClass_.memberInnerClass;

public class memberInnerClass02 {
    public static void main(String[] args) {
        //外部其他类---访问---成员内部类
        //方法1；先创建外部类对象, 外部类对象再创建 成员内部类对象
        //解读：正常应该是new Inner01()但是它不是在外面的 ，可以理解为outer的类成员新建方式 outer01.new
        Outer01 outer01 = new Outer01();
        Outer01.Inner01 inner01 = outer01.new Inner01();
        inner01.say();

        System.out.println("---------------------------------------------------");
        //方法2：在外部类中创建一个方法，然后返回成员内部类的对象
        //outer01.t2()会返回一个Inner01对象，直接调用即可
//        Outer01.Inner01 inner011 = outer01.t2();//使用引用
        outer01.t2().say();//直接调用


        System.out.println("---------------------------------------------------");
        //方法3：new 外部类.new 成员内部类.var
        Outer01.Inner01 inner011 = new Outer01().new Inner01();


    }
}
