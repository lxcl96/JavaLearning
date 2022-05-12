package chapter11_EnumerationAndAnnotation.Annotation;

public class Deprecated_ {
    public static void main(String[] args) {
        A a = new A();//加上@Deprecated就过时了，但是还是可以用的
        a.hi();//方法加上@deprecated 也会有删除线


    }
}
//@Deprecated表示某个类或方法过时了

@Deprecated
class A{
    public int n1 = 1;
    @Deprecated
    public void hi(){
        System.out.println("haha");
    }
}

/*
    @Deprecated的源码

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    //目标范围就是构造器，字段，本地变量，方法，包，参数和类型（就是类）
    @Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
    public @interface Deprecated {  //@interface所以是一个注解类
}
 */