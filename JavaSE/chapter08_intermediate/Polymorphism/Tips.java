package chapter08_intermediate.Polymorphism;

public class Tips {
}
//   访问属性看编译类型 访问对象看运行类型
/*
    多态：多种状态
        方法或对象具有多种形态。是面向对象的第三大特征，多态是建立在封装和继承的基础之上的。

    多态的具体体现：
        1、方法的多态 PolyMethod.java
            重写和重载就体现多态 （重载和重写也是多态的体现）
        2、对象的多态【核心】 PolyObject.java
            编译类型 = 运行类型
            记住：
            (1)一个对象的编译类型和运行类型可以不一致【父类引用可以指向子类对象    即 父类 = 子类】
                Animal animal = new Dog() 【animal的编译类型是Animal，但是运行类型是Dog】 Dog是Animal子类 （类似于double和int）
                animal = new Cat()  【animal的编译类型仍是Animal，但是运行类型变成了Cat】  Cat是Animal子类 （类似于double和int）
            (2)编译类型在定义对象时就确定了，不能改变
            (3)运行类型是可以改变的
                animal = new Cat()  【animal的编译类型仍是Animal，但是运行类型变成了Cat】  Cat是Animal子类 （类似于double和int）
            (4)编译类型看 = 的左边，运行类型看 = 的右边

     多态的细节：detail_中
        √多态的前提：两个对象（类）存在继承关系
        √多态的向上转型 PolyDetail.java
            向上转型
            1）本质：父类的引用 指向 子类的对象
            2）语法：父类类型 引用名 = new 子类类型()  【编译类型 引用名 = new 运行类型()】
            3）特点：编译类型看左边，运行类型看右边。
                    不可以调用父类的所成员【属性和方法】，遵循访问权限
                    不能调用子类的特有成员【子类有父类没有的 方法属性】
                    最终运行效果看子类 具体函数的体现
        √多态的向下转型
            向下转型 PolyDetail.java
            1）子类类型 (子类类型)引用名 = （子类类型）父类引用 //就是强制转换
                    Cat newCat; 需要一个子类类型 来接收
                    newCat = (Cat)cat
                    或者Cat newCat = (newCat) cat
            2）只能强制转换父类的引用， 不能强制转换父类的对象
            3）可以调用子类类型中所有成员(遵循访问权限)【属性和方法】
            4）要求父类的引用 必须要指向 当前目标类型的对象
                就是刚开始是 Animal cat = new Cat() 编译类型是Animal 运行类型是Cat
                你只可以向下转换变成相同类型的，或向上转成父亲类型
                可以： Cat newCat = (Cat) Cat
                不可以： Dog newDog = (Dog) Cat 因为运行类型已经确定了是Cat 只能是Cat【向下转换到自身】，【不能强制转换父类的对象】就是不能改变运行类型

 */