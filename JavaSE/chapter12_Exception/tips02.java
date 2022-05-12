package chapter12_Exception;

public class tips02 {

}
/*
    try-catch-finally:
    1、如果异常发生了，则异常后面的代码块就不会执行了，直接进入catch模块
    2、如果没有发生异常，则try代码会全部执行，而catch代码则不会执行
    3、如果希望不管是否发生异常，都执行某段代码（比如关闭连接，释放资源等）则放在finally代码块中
 */