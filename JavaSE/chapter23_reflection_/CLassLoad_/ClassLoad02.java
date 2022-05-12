package chapter23_reflection_.CLassLoad_;

/**
 * @Author : Ly
 * @Date : 2022/4/15
 * @Description : 演示类加载 连接阶段-准备
 */
public class ClassLoad02 {
}

class A {
    //属性-成员变量-字段
    //分析类加载的 连接阶段-准备 属性是如何处理的
    //n1不是静态属性【实例属性】，连接阶段-准备不会分配内存，是在初始化阶段
    //n2会分配内存，值默认初始化为0,；但是在加载初始化阶段会变成20
    //n3是final的常量，所以n3在连接阶段-准备直接分配内存，且指定值为30
    public int n1 = 10;
    public static int n2 = 20;
    public static final int n3 = 30;
}