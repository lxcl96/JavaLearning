package chapter08_intermediate.Extends.Super;

public class Super01 {
    public static void main(String[] args) {

    }
}
/*
    1、super可以访问父类的属性【super.属性名】，但是不能访问父类的私有属性
    2、super可以访问父类的方法【super.方法名（参数列表）】，但是不能访问父类的私有方法
    3、子类构造器访问父类构造器只能放在子类构造器的第一行，super(参数列表)

    对于父类和子类有相同的方法和属性
    情况1：父类有方法，子类没有如cal()
        cal() 类似于就近原则，如果本类有就调用本类的，如果没有就找父类的一直找到Object 但是父类中此方法是private是不可访问就会报错（本类中肯定可以访问啊）
        this.cal() 同上
        super.cal() 不在本类中找，直接调用父类一直找到Object 但是父类中此方法是private是不可访问就会报错
    情况2：父类有 子类没有
        super.cal()
     *** 需注意：方法和属性【cal()和this.cal()】如果爷爷 爸爸 儿子都有
            先找儿子，儿子有就返回儿子；
            儿子没有，爸爸有返回爸爸；
            儿子爸爸都没有爷爷有返回儿子
            儿子爸爸爷爷都没有 报错
      *** 需注意：方法和属性【super.cal()】如果爷爷 爸爸 儿子都有
            跳过儿子
            直接找爸爸，爸爸有就返回爸爸
            爸爸没有，爷爷有就返回爷爷
            爸爸爷爷没有 儿子有 报错
 */
class A {
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public void test100() {}
    protected void test200() {}
    void test300() {}
    private void test400() {}
}

class B extends A {

    public B() {
        // 3、子类构造器访问父类构造器只能放在子类构造器的第一行，super(参数列表)
        super();
    }
    public void hi() {
        //1、super可以访问父类的属性【super.属性名】，但是不能访问父类的私有属性
        System.out.println("super.n1" + super.n1);
        System.out.println("super.n2" + super.n2);
        System.out.println("super.n3" + super.n3);
        System.out.println("super.n4是私有属性访问不到");

        //2、super可以访问父类的方法【super.方法名（参数列表）】，但是不能访问父类的私有方法
        super.test100();
        super.test200();
        super.test300();
        //super.test400() private私有属性 访问不到
    }
}