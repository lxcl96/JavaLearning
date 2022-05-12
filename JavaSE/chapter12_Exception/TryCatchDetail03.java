package chapter12_Exception;

/*
    不捕获异常的话，只会执行finally然后结束，后面的代码都不会执行了
 */
public class TryCatchDetail03 {
    public static void main(String[] args) {
        try {
            int n1 = 10/0;
        } finally {
            System.out.println("无论如何都会执行");
        }

        System.out.println("程序继续。。。");
    }
}
/*

 */