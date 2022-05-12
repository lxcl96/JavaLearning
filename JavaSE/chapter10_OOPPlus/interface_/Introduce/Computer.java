package chapter10_OOPPlus.interface_.Introduce;

public class Computer {
    /*
    电脑包含(提供)接口
     */
    //解读：
    //1、UsbInterface usbInterface 形参是接口类型 UsbInterface
    //2、可以看到 接受了 实现接口UsbInterface类的对象实例
    public void work(UsbInterface usbInterface) {
        usbInterface.start();
        usbInterface.stop();
    }
}
