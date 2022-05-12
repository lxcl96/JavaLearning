package chapter_19_IO_.HomeWork;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

/**
 * @Author : Ly
 * @Date : 2022/4/3
 * @Description : (1)编写一个dog.properties
 *                      name=tom
 *                      age=5
 *                      color=red
 *                (2)编写Dog类(name,age,color)创建一个dog对象，读取 dog.properties用相应的内容完成属性初始化，并输出。
 *                (3)将创建的Dog对象序列化到dog.dat文件中
 */
public class HomeWork03 {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\HomeWork\\dog.properties";
        Properties pp = new Properties();
        pp.load(new FileReader(filePath));

        String name = pp.getProperty("name");
        String age = pp.getProperty("age");
        String color = pp.getProperty("color");
        Dog dog = new Dog(name, Integer.parseInt(age), color);

        System.out.println(dog);

        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\HomeWork\\dog.dat"));

        oos.writeObject(dog);

        oos.close();

    }

    @Test
    public void reverseSerial() throws IOException, ClassNotFoundException {
        //反序列化 读取数据
        ObjectInputStream ois =
                new ObjectInputStream(
                        new FileInputStream("D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\HomeWork\\dog.dat"));


        System.out.println(ois.readObject());//怎么放就怎么取出来，放什么类型就用什么类型取
        ois.close();
    }

}


class Dog implements Serializable{//必须要序列化才能保存到文件中
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}