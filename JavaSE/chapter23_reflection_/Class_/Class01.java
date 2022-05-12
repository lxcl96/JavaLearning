package chapter23_reflection_.Class_;

import chapter23_reflection_.introduce.Cat;

/**
 * @Author : Ly
 * @Date : 2022/4/14
 * @Description :
 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //2、Class类对象是系统创建出来的，而不是new出来的
        //  普通方式 会进行类加载 可以debug查看
        /*
        public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        Cat cat = new Cat();



        //  反射方式
        //  【细节：上面已经加载了Cat.class因此下面debug不到加载Cat类，需要把上面的注销掉 ；因为类Class对象的加载只有一次】
        /*
            ClassLoader类，仍然是通过ClassLoader类加载Cat类的 Class对象
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }

         */
        Class<?> aClass = Class.forName("chapter23_reflection_.introduce.Cat");
        //Class<?> aClass1 = Class.forName("chapter23_reflection_.introduce.Cat");


        //3、对于某个类的Class类对象，在内存中只有一份，因此类只加载一次
        //    【同一个类的Class对象hashcode一致，cat和dog的Class对象不是同一个类因此hashcode不会一样】
        System.out.println(aClass.hashCode());
        //System.out.println(aClass1.hashCode());

        //4、每个类的实例都会记得自己是由哪个Class实例【Cat的唯一Class对象意思，还是唯一一个Class】生成的

    }
}
