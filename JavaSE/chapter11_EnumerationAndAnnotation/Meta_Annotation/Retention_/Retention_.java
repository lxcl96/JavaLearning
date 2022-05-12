package chapter11_EnumerationAndAnnotation.Meta_Annotation.Retention_;

/*
    @Rentention
      只能用于修饰一个Annotation定义，用于指定该Annotation可以保留多长时间。
      @Retention包含一个RetentionPolicy类型的成员变量，使用@Retention时必须为该value成员变量指定值。

      value的值可为： 【一般默认为RetentionPolicy.CLASS】
      RetentionPolicy.SOURCE:编译器使用后，直接丢弃这种策略的注解【仅在编译时生效】
      RetentionPolicy.CLASS:编译器将注释记录在class文件中，当运行Java程序时，JVM不会保留注解。【】
      RetentionPolicy.RUNTIME:编译器将把注释记录在class文件中，当运行java程序时，JVM会保留注释。程序可以通过反射获取该注解
 */
@Deprecated
public class Retention_ {
    @java.lang.Override
    public String toString() {
        return super.toString();
    }
}

/**
 * 如上面的@Override:
 *  Override的作用域在SOURCE，当编译器编译时生效，不会写入.class文件，也不会在 runtime时生效
 */
