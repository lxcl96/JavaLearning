package chapter10_OOPPlus.interface_.Introduce;

//类 implement 接口 (使用接口)
//因为接口是抽象类,抽象方法 所以需要实现抽象方法
public class phone implements UsbInterface{
    /*
   手机\相机使用接口
    */

    @Override
    public void start() {
        System.out.println("手机开始工作...");
    }

    @Override
    public void stop() {
        System.out.println("手机停止工作...");
    }

    public void call() {
        System.out.println("手机正在打电话。。。");
    }
}
