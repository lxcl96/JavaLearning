package chapter07_Class.Constructor;
/*
默认类中有一个无参构造器，但是如果声明了 就不用默认的  javap 反编译
可以用overload 重载来使用多

 */
public class ConstructorDetail {
    public static void main(String[] args) {
        Dog d1 = new Dog("cat", 11);
    }
}

class Dog{
    int age = 4;
    String name;
    //默认 构造期
    //Dog(){}//这个就是默认构造器
    Dog(String aname, int aage){
        name = aname;
        age = aage;
    } //重载
    //想再次使用无参的 就需要重载了
    Dog(){}
}


/*

流程分析：
1、方法区中加载类信息，只会加载一次
2、在堆中开辟空间 地址0x1122 此时初始值为系统默认 此时age=0,name=null
3、加载类中显性信息 如：int age = 4;String name;此时age=4,name=null
4、加载构造器信息(隐式初始化) 此时age=11,name=cat
5、实例化d1 存放地址0x1122 指向堆 即对象在堆中地址返回给d1
 */