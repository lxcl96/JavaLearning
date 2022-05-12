package chapter23_reflection_.Class_;

import chapter23_reflection_.introduce.Car;

import java.lang.reflect.Field;

/**
 * @Author : Ly
 * @Date : 2022/4/15
 * @Description : Class类的常用方法
 */
public class class02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        String classAllPath = "chapter23_reflection_.introduce.Car";
        //获取到Car类对于的Class对象 <?>表示不确定的数据类型【即不知道是Dog类，还是Car类等等，不写也可以 】
        Class<?> cls = Class.forName(classAllPath);
        //输出cls  显示对应类的Class对象
        System.out.println(cls);
        System.out.println(cls.getClassLoader());
        System.out.println(cls.getClass());//输出运行类型 java.lang.Class
        //得到包名
        System.out.println(cls.getPackage().getName());
        //得到全类名
        System.out.println(cls.getName());

        //通过cls创建对象实例 此时就可以强转 (Car)
        Car car = (Car)cls.newInstance();
        System.out.println(car);

        //通过反射获取属性
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));//新实例.属性
        //通过反射给属性赋值
        brand.set(car,"奥迪");
        System.out.println(brand.get(car));//新实例.属性

        //遍历得到所有的属性
        Field[] fields = cls.getFields();
        for (Field f:fields) {
            System.out.println(f + "      " +f.getName());
        }


    }
}
