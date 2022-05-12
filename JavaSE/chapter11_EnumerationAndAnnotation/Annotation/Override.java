package chapter11_EnumerationAndAnnotation.Annotation;

public class Override {

}
class Father {
    public void eat() {}
}

class Son extends Father {

    /*
        【@interface就是注解类的意思】
        【@Target是修饰注解的注解也叫作元注解】

        追进去发现 @Override的定义是：

        //【目标（元素类型是方法的）】
        @Target(ElementType.METHOD) //【它的意思就是此@Override适用目标就是 METHOD方法，，不能用于类】
        @Retention(RetentionPolicy.SOURCE)
        public @interface Override {
        }

        其中@interface  不是interface接口，就是注解类 jdk1.5加入的
     */

    @java.lang.Override
    public void eat() {
        super.eat();
    }
}