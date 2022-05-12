package chapter23_reflection_;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author : Ly
 * @Date : 2022/4/15
 * @Description :
 */
public class ReflectAccessMethods {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1、获取到User的Class对象
        Class<?> userCls = Class.forName("chapter23_reflection_.User");
        Object o = userCls.newInstance();

        //获取公有方法
        Method hi = userCls.getMethod("hi");
        hi.invoke(o);

        //获取非public方法
        Method haha = userCls.getDeclaredMethod("haha", String.class);//需要参数量一致 这里放（函数名字，参数类型Class数组）
        haha.setAccessible(true);//暴力破解隐私权限
        //运行类型是 int/Integer 返回类型是Object
        Object invoke = haha.invoke(o, "哈哈");//如果是静态方法，o可以换成null 这里放（实例对象，实参）
        System.out.println(invoke + "运行类型是" + invoke.getClass()) ;
    }
}
