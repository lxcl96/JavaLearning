package chapter_19_IO_.对象流.字节对象流;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @Author : Ly
 * @Date : 2022/4/2
 * @Description : 使用 ObjectOutPutStream 序列化 基本数据类型和一个Dog对象（name，age），并保存到data.dat文件中
 */
public class ObjectOutPutStream_ {
    public static void main(String[] args) throws IOException {
        //保存的地方【序列化后的数据保存不是纯文本，而是以其特有的方式存储】
        String filePath = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\对象流\\字节对象流\\data.dat";
        //要序列化保存的数据
        int num = 100;
        Dog d1 = new Dog("小黄", 3,"yellow","china", new Cat());

        //创建可序列化的数据流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeObject(d1);//Dog类实现了Serializable接口
        oos.writeInt(num);//会自动装箱int -> Integer r，而Integer的父类Number实现了Serializable接口
        oos.writeBoolean(true);//boolean -> Boolean
        oos.writeChar('a');//char -> Character
        oos.writeDouble(9.5);//double -> Double
        oos.writeUTF("哈哈哈");//以UTF-8格式存储字符串


        oos.close();

    }
}


//要写入的类/对象必须要是可序列化的
class Dog implements Serializable {
    public String name;
    public int age;
    //    3、序列化对象时，默认将里面的所有属性都进行序列化，除了static或transient修饰的成员
    private static String color;
    private static transient String nation;

    //5、序列化对象时，要求里面的属性的类型也需要实现序列化接口
    private Cat cat;//没有序列化，序列化时会报错


    //serialVersionUID 是序列化的版本号，可以提高兼容性 【就是意思如果此类中，新加入元素就认为是同一个类，只是版本号不一样而已】
    //此时照样可以读取
    private static final long serialVersionUID = 1L;

    public Dog(String name, int age, String color, String nation, Cat cat) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.nation = nation;
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static String getColor() {
        return color;
    }

    public static String getNation() {
        return nation;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Cat getCat() {
        return cat;
    }
}

//么有被序列化
class Cat {}