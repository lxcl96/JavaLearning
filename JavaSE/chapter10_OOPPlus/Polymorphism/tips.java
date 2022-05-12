package chapter10_OOPPlus.Polymorphism;

public class tips {

}
/*
    接口的多态特性：
    1、多态参数（前面案例） 【即接口可以指向实现接口的所有类的实例】再举例：InterfacePolyParameter.java
        在前面的Usb接口案例，USb usb即可以接收手机对象，也可以接受相机对象 就体现了接口的多态（接口引用可以指向实现接口类的对象）
    2、多态数组 InterfacePolyArr.java
        演示一个案例：给Usb数组中，存放Phone和 Camera对象，Phone类还有一个特有的方法call(),请遍历Usb数组，如果是Phone对象，
        除了调用Usb接口定义的方法外还需要调用Phone特有方法call

    3、接口存在【多态传递】现象 InterfacePolyPass.java
 */
