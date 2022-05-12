package chapter10_OOPPlus.innerClass_.localInnerClass_;

public class tips {

}
/*
    1、局部内部类：
    说明：局部内部类是定义在外部类的局部位置，比如方法中，并且有类名
       I:可以直接访问外部类的所有成员，包含私有的
       II:类不能添加访问修饰符，因为它本质上就是一个局部变量，局部变量不能使用修饰符的
           但是可以使用final修饰，因为局部变量也可以使用final
       III:作用域：仅仅在定义它的方法或代码块中
       IV:局部内部类---访问---外部类的成员  【直接访问所有成员】
       V：外部类---访问---局部内部类的成员【创建局部内部类对象，再访问（必须要在作用域内）】
       VI：外部其他类----不能访问---局部内部类（出了方法都访问不到，更别说别的类了）
       VII：如果外部类和局部内部类的成员重名时，默认遵循就近原则。 【是Outer类 不是Other类】
            如果想访问外部类的成员，则可以使用（外部类名.this.成员）去访问
            sout（“外部类的n2=” + 外部类名.this.n2）

 */