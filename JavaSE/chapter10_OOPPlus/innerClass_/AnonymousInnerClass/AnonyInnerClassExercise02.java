package chapter10_OOPPlus.innerClass_.AnonymousInnerClass;

public class AnonyInnerClassExercise02 {
    public static void main(String[] args) {
        //new 类（）.函数（匿名内部类）
        new CellPhone().alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });

        //过程
        //1、先创建匿名内部类 其实就是  【编译类型是Bell 但是运行类型实际是AnonyInnerClassExercise02$2】
        // Bell bell = new Bell() {
        //            @Override
        //            public void ring() {
        //                System.out.println("小伙伴上课了");
        //            }
        //        }
        //2、无参构造器创建了CellPhone 的匿名对象
        //3、传递参数，调用alarmclock的函数
        //4、根据动态绑定机制，先找运行类型的函数，所有找到匿名内部类的ring()方法
        new CellPhone().alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println(getClass());
                System.out.println("小伙伴上课了");
            }
        });
    }


}
/*
    1、有一个铃声接口Bell 里面有个ring方法
    2、有个手机类CellPhone，具有闹钟功能 alarmclock，参数是Bell类型
    3、测试手机的闹钟功能，通过匿名内部类（对象）作为参数，打印：“懒猪起床了”
    4、再传入另一个匿名内部类（对象），打印：小伙伴上课了


 */

interface Bell {
    void ring();
}

class CellPhone {
    public void alarmclock(Bell bell) {
        bell.ring();
    }
}