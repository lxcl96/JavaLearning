package chapter23_reflection_.CLassLoad_;

/**
 * @Author : Ly
 * @Date : 2022/4/15
 * @Description : 演示类加载 initialization初始化阶段
 */
public class ClassLoad03 {
    public static void main(String[] args) {
        //分析
        //1、加载类，并生成起Class对象
        //2、连接阶段 过后，已经分配了内存空间，静态变量num=0
        //3、初始化阶段  num值从0-300-100
        // 依次自动收集类中所有静态变量的赋值动作和静态代码块中的语句，并合并
        /*
            clinit(){
                按照顺序收集
                 System.out.println("B de 静态代码块被执行");
                 num = 300;
                 num = 100;
            }
         */
        System.out.println(B.num);//直接使用类的静态属性，该类也会被自动加载

        //类在加载时 有同步线程机制控制 所以类的Class属性只有一个，因为类只加载一次【就是因为初始化时线程同步】

        B b = new B();
    }
}

class B {
    static {
        System.out.println("B de 静态代码块被执行");
        num = 300;
    }

    static int num = 100;

    public B() {
        System.out.println("B构造器被执行");
    }
}