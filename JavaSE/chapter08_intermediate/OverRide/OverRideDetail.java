package chapter08_intermediate.OverRide;

public class OverRideDetail {

}
/*
    细节：
        1、子类的方法的 参数和方法名称 必须要和父类的 完全一样【返回类型比较特殊，下面说】
        2、子类方法的返回类型要和父类方法的返回类型一样，或者是【父类返回类型的子类】
            如：父类方法的返回类型是Object，子类方法返回类型可以为String 即【父类的返回类型要 包含 子类的返回类型】
        3、子类方法不能缩小父类方法的访问权限  权限由高到低：public > protected > 默认 > private
            如：父类 public
                子类 默认
           但是可以扩大
            如：父类 默认
                子类 public




        重载overload和重写override的比较
        名称          发生范围            方法名         形参列表                        返回类型                    修饰符
        重载overload  本类               必须一样       类型、个数或顺序至少有一个一样      无要求                        无要求
        重写override  父子类             必须一样       完全一样                         子类返回类型要和父类完全一样，    子类方法不能缩小父类的访问范围
                                                                                      或是父类返回类型的子类          当然可以扩大
 */