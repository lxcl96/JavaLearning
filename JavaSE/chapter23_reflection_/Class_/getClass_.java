package chapter23_reflection_.Class_;

import chapter23_reflection_.introduce.Car;

/**
 * @Author : Ly
 * @Date : 2022/4/15
 * @Description : 演示得到某类的Class对象的各种方式
 */
public class getClass_ {
    public static void main(String[] args) throws ClassNotFoundException {
        //1、编译阶段获取： Class.forName(全类名)获取
        Class<?> cls1 = Class.forName("chapter23_reflection_.introduce.Car");
        System.out.println(cls1);


        //2、加载阶段：类名.class获取
        Class<Car> cls2 = Car.class;
        System.out.println(cls2);

        //3、运行阶段：对象实例.getClass()获取
        Car car = new Car();
        Class<? extends Car> cls3 = car.getClass();
        System.out.println(cls3);

        //4、加载阶段：类加载器(ClassLoader有4种加载)获取
        //（1）通过对象实例，得到类加载器
        ClassLoader classLoader = car.getClass().getClassLoader();
        //（2）通过类加载器得到Class对象
        Class<?> cls4 = classLoader.loadClass("chapter23_reflection_.introduce.Car");
        System.out.println(cls4);

        //cls1 cls2 cls3 cls4 其实是同一个Class对象
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        //5、基本数据类型(int,char,boolean,float,double,byte,long,short)按如下方式得到Class对象
        Class<Integer> cls5 = int.class;
        System.out.println(cls5);

        //6、基本类型的包装类（Integer，Character，Boolean，Float，Double，Long，Short）通过.type得到CLass类对象
        Class<Integer> cls6 = Integer.TYPE;
        System.out.println(cls6);

        //思考cls5和cls6是否相同 相同都是int
        System.out.println(cls5.hashCode());
        System.out.println(cls6.hashCode());

    }
}
