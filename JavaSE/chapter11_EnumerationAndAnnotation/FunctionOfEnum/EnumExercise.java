package chapter11_EnumerationAndAnnotation.FunctionOfEnum;

public class EnumExercise {
    public static void main(String[] args) {
        Week[] values = Week.values();
        System.out.println("===所有星期的信息如下===");
        for (Week value : values) {
            System.out.println(value);
        }
    }
}
/*
    1、声明Week枚举类，其中包含星期一到星期日的定义：
        MONDAY，TUESDAY,Wednesday，Thursday，Friday，Saturday，Sunday
    2、使用values()返回所有的枚举数组，并遍历输出
 */
enum Week {
    MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"), THURSDAY("星期四"),
    FRIFAY("星期五"),SATURDAY("星期六"),SUNDAY("星期日");
    private String desc;
    //切记 构造器私有
    private Week(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}