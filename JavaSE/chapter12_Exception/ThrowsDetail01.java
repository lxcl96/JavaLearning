package chapter12_Exception;

import java.io.FileNotFoundException;

public class ThrowsDetail01 {

}

class AA {
    public void f1() throws Exception {}

    //默认throws 但是异常类型是什么呢？ 运行异常
    public void f2() throws FileNotFoundException{ f3(); } //调用函数有编译异常 必须要处理

    public void f3() throws FileNotFoundException {}//编译异常

    public void f4() { f5();}//调用函数有运行异常，可以不处理，因为有默认处理方式

    public void f5() throws NullPointerException{} //运行异常
}

class BB extends AA{
    @Override
    //子类重写方法抛出的异常 必须和父类方法抛出异常一样，或者是父类的子类型
    public void f1() throws NullPointerException, Exception{}

//    @Override
//    public void f2() throws NullPointerException {
//        super.f2();
//    }
}