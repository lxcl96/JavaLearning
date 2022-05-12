package chapter10_OOPPlus.interface_.Introduce;

public class InterfaceIntrouce {


    public static void main(String[] args) {
        //创建手机\相机对象
        phone phone = new phone();
        Camera camera = new Camera();

        //创建计算机
        Computer computer = new Computer();

        //使用接口  手机接入computer
        computer.work(phone);//相当于Phone 继承了 UsbInterface
        computer.work(camera);
    }
}
