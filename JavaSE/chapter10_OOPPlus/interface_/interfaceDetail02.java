package chapter10_OOPPlus.interface_;

public class interfaceDetail02 {

}
class AA{}
abstract class BB{}
interface IA3 {}
interface IA4 {}
//一个接口可以继承 多个别的接口
interface IA5 extends IA3, IA4{}

//一个接口不能继承别的类  包括抽象类
//interface IA6 extends BB{}