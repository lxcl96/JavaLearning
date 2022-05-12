package chapter15_Generics_.DIYGenerics.interface_;

public class CustomInterfaceGenerics {
    public static void main(String[] args) {

    }
}

//4、泛型类的类型【自己传的】，是在继承接口或者使用接口时确定的【就是继承接口或者使用接口时自己传的】
interface IC extends IUsb<String, Integer>{}  //子接口继承接口  实现

//【U，R自己定但是子接口要和extends的参数符号一样】
interface IA<U, R> extends IUsb<U, R>{}//创建时可以不指定，但是子接口必须也要有相应的泛型
interface IB<U1, R1> extends IUsb<U1, R1>{}//创建时可以不指定，但是子接口必须也要有相应的泛型


//自定义泛型接口  接口中成员都是public 和static的
interface IUsb<U,R> {
    //静态属性/方法不行
    //U m;

    //普通方法 使用泛型
    R get(U u);
    void hi(R r);
    void run(R r1, R r2, U u1, U u2);

    //默认方法，使用泛型
    default R method(U u) {
        return null;
    }
}

