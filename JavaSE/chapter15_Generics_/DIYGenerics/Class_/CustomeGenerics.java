package chapter15_Generics_.DIYGenerics.Class_;

public class CustomeGenerics {
    public static void main(String[] args) {

    }
}

//三个泛型参数  不指定为Object,将Tiger叫做自定义泛型类
class Tiger<T, R, M> {
    String name;
    //1、普通成员可以使用泛型（如：属性，方法）
    T t;
    //3、静态方法/属性中，不能使用类的泛型【原因同2，因为静态变量是在类加载时进行的(此时还没有创建对象)，而泛型是在创建对象时指定 的】
    //static R rr;
    R r;
    M m;
    //2、使用泛型的数组不能初始化 【很好理解，因为没传入参数，编译器不知道是什么类型的怎么创建？】
    //T[] t = new T[8];

    public Tiger(String name) {
        this.name = name;
    }

    public Tiger(T t, R r, M m) {
        this.t = t;
        this.r = r;
        this.m = m;
    }

    public Tiger(String name, T t, R r, M m) {
        this.name = name;
        this.t = t;
        this.r = r;
        this.m = m;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //1、普通成员可以使用泛型（如：属性，方法）
    public T getT() {
        return t;
    }
    //3、静态方法/属性中，不能使用类的泛型【原因同2，因为静态变量是在类加载时进行的(此时还没有创建对象)，而泛型是在创建对象时指定 的】
    //public static void he(M m){}
    public void setT(T t) {
        this.t = t;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", t=" + t +
                ", r=" + r +
                ", m=" + m +
                '}';
    }
}