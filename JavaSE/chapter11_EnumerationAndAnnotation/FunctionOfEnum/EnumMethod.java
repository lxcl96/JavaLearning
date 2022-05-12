package chapter11_EnumerationAndAnnotation.FunctionOfEnum;

/*
    以枚举类Season2为例，讲解父类Enum成员方法
 */


public class EnumMethod {
    public static void main(String[] args) {
        Season autumn = Season.AUTUMN;
        Season spring = Season.SPRING;
        Season winter = Season.WINTER;
        //name()函数  输出枚举对象名称AUTUMN
        System.out.println(autumn.name());

        System.out.println("----------------------------------------------");
        //ordinal()函数 返回枚举值在枚举中的位置【下标从0开始】 2
        System.out.println(autumn.ordinal());

        System.out.println("----------------------------------------------");
        //valueOf()  匹配枚举对象，找到了成功未找到报错 【找到的还是一个对象 并且对象的地址是唯一的因为是static】
        Season autumn1 = autumn.valueOf("AUTUMN");
        System.out.println(autumn1);
        System.out.println("autumn的地址等于autumn1的地址：" + (autumn == autumn1) + " 因为是static");

        System.out.println("----------------------------------------------");
        //compareTo() 两个枚举对象进行位置比较  必须要是同一个枚举类型不然会报错
        //例如：autumn.compareTo(autumn1)
        //如果autumn的对象比 autumn1的对象靠前，返回负数
        //如果autumn的对象比和 autumn1的对象 位置一样，返回负数
        //如果autumn的对象比 autumn1的对象靠后，返回正整数
        System.out.println("为两个枚举对象地址的插值： 前一个对象的地址-后一个对象的地址");
        System.out.println("都是autumn，应该为0，=" + autumn.compareTo(autumn1));
        System.out.println("autumn【2】比spring【0】后，应该为正整数【2】，=" + autumn.compareTo(spring));
        System.out.println("autumn【2】比winter【3】前，应该为负数【-1】，=" + autumn.compareTo(winter));
        System.out.println("spring【0】比winter【3】前，应该为负数【-3】，=" + spring.compareTo(winter));

        //从反编译可以看到有一个values()方法  返回Season[] 即枚举类名数组
        // 里面是所有枚举值 即枚举对象 同autumn 【枚举对象数组】
        System.out.println(autumn.values()[0]);//Season2{name='春天', desc='温暖'} toString()
        System.out.println("----------------------------------------------");
        //遍历
        Season[] values = autumn.values();
        for (Season value : values) {
            System.out.println(value);
        }



    }
}
