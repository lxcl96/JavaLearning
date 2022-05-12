package chapter12_Exception;

public class tips03 {

}
/*
    throws: Throws01.java
    1、如果一个方法中的语句执行时可能会生成某种异常，但是不确定如何处理这种异常，则此方法应显示的的声明抛出异常，表示该方法b不对这些异常进行
    处理，而由该方法的调用者负责处理

    2、在方法声明中用throws语句可以声明抛出异常的列表【多个异常】，
        throws后面的异常类型可以是方法中产生的异常类型【FileNotFoundException】，也可以是它的父类【Exception】

    注意：

 */