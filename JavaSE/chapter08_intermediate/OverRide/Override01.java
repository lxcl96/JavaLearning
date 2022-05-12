package chapter08_intermediate.OverRide;

public class Override01 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.cry();

    }
}
class Animal {
    public void cry() {
        System.out.println("动物叫唤。。。");
    }

    //2、子类方法的返回类型要和父类方法的返回类型一样，或者是【父类返回类型的子类】
    public Object m1() {return null;}

    // 3、子类方法不能缩小父类方法的访问权限  权限由高到低：public > protected > 默认 > private
    public void m2() {}
    //3的反面 扩大
    void m3() {}
}

class Dog extends Animal {
    //dog是animal的子类
    //dog的cry()方法 和 animal的cry()方法完全一样  【函数名称、返回类型、参数列表】完全一样
    //就说 子类cry()方法 override/重写了父类的 cry()方法
    public void cry() {
        System.out.println("小狗叫唤。。。");
    }


    public String m1() { return null; }

    //void m2() {} //会报错，子类默认权限是小于 父类public的

    //扩大了 访问权限 正确的
    public void m3() {}
}