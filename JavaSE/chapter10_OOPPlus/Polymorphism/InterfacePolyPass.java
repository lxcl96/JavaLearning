package chapter10_OOPPlus.Polymorphism;

public class InterfacePolyPass {
    public static void main(String[] args) {
        IG ig = new Teacher();
//        IH ih = new Teacher();//不能这样用，因为teacher类没有实现/使用 接口IH

        //但是如果 IG 是继承自 IH teacher使用了IG则必然也使用了IH 所以ih可以指向Teacher，这就是对象传递
        IH ih = new Teacher();
    }
}
interface IH{}
interface IG extends IH {}

class Teacher implements IG{}