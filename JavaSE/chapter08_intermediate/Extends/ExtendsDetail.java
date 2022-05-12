package chapter08_intermediate.Extends;

public class ExtendsDetail {
    public static void main(String[] args) {
        Sub sub = new Sub();
//        sub.sayOk();
        System.out.println("========第二个对象=======");
        //证明 子类默认使用 父类的无参构造器
        Sub sub2 = new Sub("hello");


    }
}


/*
    ctrl + h 查看类的层级结构
    Object是所有类的基类，所有类都继承自Object

    如下Sub类构造器调用是从：Object构造期-->Base构造器-->Sub构造器 一层层调用（祖先类构造器也会调用）

 */
//基类 父类
class Base {
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public Base() {
        System.out.println("父类base()构造器被调用...");
    }
    //仅有有 有参构造器
    public Base(String name, int age) {
        System.out.println("父类base(String name, int age)构造器被调用...");
    }

    //构建公共方法 访问私有属性核方法
    public int getN4() {
        return n4;
    }
    public void getTest400() {
        test400();
    }
    public void test100() {
        System.out.println("test100");
    }
    protected void test200() {
        System.out.println("test200");
    }
    void test300() {
        System.out.println("test300");
    }
    private void test400() {
        System.out.println("test400");
    }
}

//子类继承了父类所有的属性和方法，非私有的属性和方法可以直接访问，但是私有属性和方法不能在子类中直接方法，要通过父类提供的公共方法
class Sub extends Base {

    /*
        子类必须先调用父类的构造器完成父类的初始化
        如果父类没有提供无参构造器，则必须使用super 进行继承
        父类是无参数构造器时 所有子类构造器 默认有super() 所以可写可不写
        但父类是无 无参数构造器时 所有子类构造器 必须要有super()去指定使用 哪一个有参构造器

        即：子类默认使用父类无参数构造器，如果父类没有无参数构造器就必须要有super()去指定使用 哪一个有参构造器
     */
    public Sub() {
        //super();//父类是无参数构造器时 默认有super() 所以可写可不写

        //super()和this()使用都必须放在第一行，因此这俩没办法在同一构造器共存
        //父类无 无参构造器 此时必须用super指定 父类用的哪一个构造期
        super();
        System.out.println("子类Sub()构造器被调用...");
    }
    public Sub(String name) {

        //super()和this()使用都必须放在第一行，因此这俩没办法在同一构造器共存  （ps：this()为在一个构造器中调用另一个构造器）
        //父类无 无参构造器 此时必须用super指定 父类用的哪一个构造期
        super("jack", 20);
        System.out.println("子类Sub(String name)构造器被调用...");
    }

    public void sayOk() {
        //非私有的属性和方法可以直接访问
        System.out.println("n1=" + n1 + " n2=" + n2 + " n3=" + n3 + " n4=" + getN4());

        test100();
        test200();
        test300();
        //通过父类提供的公共方法访问私有属性和方法
        getTest400();
    }
}
