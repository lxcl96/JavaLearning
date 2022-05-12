package chapter_19_IO_.对象流.字节对象流;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @Author : Ly
 * @Date : 2022/4/2
 * @Description : 使用 ObjectInputStream 反序列化 存储的数据，并输出显示
 */
public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //保存的地方【序列化后的数据保存不是纯文本，而是以其特有的方式存储】
        String filePath = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\对象流\\字节对象流\\data.dat";

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
        //1、反序列化（即读取）的顺序，必须要和保存（序列化的）顺序一样
        //Object读取存储Dog类的年龄和名字
        Object o = objectInputStream.readObject();//类可能不存在，
        //为了使用特有方法，需要向下转型 Dog类必须要和ObjectInputStream在同一个包下【或可以引用，类为public】，
        //          在读取时才可以调用方法或属性
        //因为在存储对象Dog类时，存储了包的路径，所以反序列化（读取）时，或者在同一个包下【或者把Dog做成public类，重新写入文件中，再读取】
        Dog dog = (Dog)o;
        System.out.println(o.getClass());
        //ObjectOutPutStream写入Dog类，必须要和  Dog类必须要和ObjectInputStream在同一个包下，在读取时才可以调用方法或属性
        System.out.println(dog.getName());
        System.out.println(dog.getAge());
        System.out.println(dog.getColor());//static类型 无法序列化，读取不到，输出null
        System.out.println(dog.getNation());//transient类型 无法序列化，读取不到，输出null

        //其他基本数据
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readBoolean());
        System.out.println(objectInputStream.readChar());
        System.out.println(objectInputStream.readDouble());
        System.out.println(objectInputStream.readUTF());

        objectInputStream.close();
    }
}
