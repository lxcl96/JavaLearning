package chapter15_Generics_;

public class Generics03 {
    public static void main(String[] args) {
        Person person = new Person("", 1);
        System.out.println(person.getS1());
    }
}

//<E>、<T>、<Q>。。。随便，都表示泛型一般就是E和T
//该数据类型 是在实例化时传入的 如果要在运行时输出E的实际类型，就用getClass
class Person <E>{
    String s;//类型为String
    E s1;//类型是泛型不定，如果传入String就是String；如果传入Integer就是Integer。。。

    //E就代表一种数据类型了
    public Person(String s, E s1) {
        this.s = s;
        this.s1 = s1;
    }

    //用在方法的返回值上
    public E getS1() {
        return s1;
    }
}