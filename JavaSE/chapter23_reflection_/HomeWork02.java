package chapter23_reflection_;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author : Ly
 * @Date : 2022/4/15
 * @Description :
 * 1、利用Class类的佛入Name方法得到File类的Class对象
 * 2、在控制台打印File类的所有构造器
 * 3、通过newInstance的方法创建File对象，并创建D:\myNew.txt
 */
public class HomeWork02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> fileCls = Class.forName("java.io.File");
        Constructor<?>[] constructors = fileCls.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        //Object o = fileCls.newInstance();//这是无参数构造器不行，需要参数指定构造器
        Constructor<?> constructor = fileCls.getConstructor(String.class);
        Object o = constructor.newInstance("D:\\myNew.txt");//创建了file对象了，其运行类型就是File了
        //得到方法
        Method createNewFile = fileCls.getMethod("createNewFile");
        createNewFile.invoke(o);

    }
}
