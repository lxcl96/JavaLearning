package chapter11_EnumerationAndAnnotation.Enumeration;

public class Enumeration03 {
    public static void main(String[] args) {
        System.out.println(Season2.SPRING);
    }
}

//使enum关建字进行枚举
enum Season2 {

    //enum关键字实现枚举
    //1、使用关建字enum 替换class
    //2、定义枚举值：枚举对象1(枚举值)，枚举对象2(枚举值);【注意，多个枚举对象时用逗号，最后再用分号 且必须放在第一排】
    //3、使用关建字enum来实现枚举，必须要把枚举对象即第二步放在最开始的位置上
    //4、使用直接 枚举名.枚举对象
    SPRING("春天", "温暖"),
    SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"),
    WINTER("冬天", "寒冷");

    private String name;
    private String desc;
    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season2{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}