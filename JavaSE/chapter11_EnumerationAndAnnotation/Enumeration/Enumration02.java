package chapter11_EnumerationAndAnnotation.Enumeration;

public class Enumration02 {
    public static void main(String[] args) {
        //直接取到枚举值
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
    }
}

//演示自定义枚举实现
class Season {
    private String name;
    private String desc;

    public final static Season SPRING = new Season("春天", "温暖");
    public final static Season SUMMER = new Season("夏天", "炎热");
    public final static Season AUTUMN = new Season("秋天", "凉爽");
    public final static Season WINTER = new Season("冬天", "寒冷");

    //1、构造期私有化 防止被直接new出来
    //2、去掉SetXXX相关方法 防止属性被修改
    //3、在Season类内部，直接创建固定的对象（有几个就创建几个）
    //4、可以加上final进行优化
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getDesc() {
        return desc;
    }

//    public void setDesc(String desc) {
//        this.desc = desc;
//    }


    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}