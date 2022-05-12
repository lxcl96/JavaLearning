package chapter10_OOPPlus.Polymorphism;

import chapter10_OOPPlus.interface_.Introduce.Camera;
import chapter10_OOPPlus.interface_.Introduce.UsbInterface;
import chapter10_OOPPlus.interface_.Introduce.phone;

public class InterfacePolyArr {
    public static void main(String[] args) {
        UsbInterface [] usb = new UsbInterface[2];
        usb[0] = new Camera();
        usb[1] = new phone();

        for (int i = 0; i < usb.length; i++) {
            //运行类型判断 instanceof
            if (usb[i] instanceof phone) {
                ((phone) usb[i]).call();
            }
            usb[i].start();
            usb[i].stop();
            System.out.println("=================第" + ( i + 1 ) + "个=================");
        }
    }
}
