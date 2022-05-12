package chapter15_Generics_.DIYGenerics.Function_;

public class CustomMethodGenerics {
    public static void main(String[] args) {
        new B<String , Double>().h2(1);

        new A().h2(1);
        new A().h2("1");
    }
}

//普通类
class A {
    //普通方法
    public void h1(){}

    //泛型方法
    public <T> void h2(T t){
        System.out.println(t.getClass());
    } //一般都会用，不然也就没有意义了
}


//泛型类
class B<T,E> {
    //普通方法
    public void h1(){}

    //泛型方法 一般是和类的泛型符号不一样  表示区分
    //如果一样，就近原则 反正是和类的泛型类型不是同一个【除非指定类型一样】
    public <T> void h2(T t){
        System.out.println(t.getClass());
    } //一般都会用，不然也就没有意义了
}