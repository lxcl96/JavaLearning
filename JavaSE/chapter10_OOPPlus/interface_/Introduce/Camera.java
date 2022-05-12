package chapter10_OOPPlus.interface_.Introduce;

public class Camera implements UsbInterface {
    /*
    手机\相机使用接口
     */
    @Override
    public void start() {
        System.out.println("相机开始工作...");
    }

    @Override
    public void stop() {
        System.out.println("相机停止工作...");
    }
}
