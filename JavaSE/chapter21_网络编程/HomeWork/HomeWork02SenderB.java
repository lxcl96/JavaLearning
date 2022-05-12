package chapter21_网络编程.HomeWork;

import java.io.IOException;
import java.net.*;

/**
 * @Author : Ly
 * @Date : 2022/4/9
 * @Description :
 * 1、编写一个接收端A和一个发送端B 使用UDP协议
 * 2、接收端在8888端口等待接受数据
 * 3、发送端向接收端发送数据 ”四大名著是哪些？“
 * 4、接收端接受后 返回 ”四大名著是《红楼梦》...“ 否则返回what?
 * 5、接收端和发送端程序退出
 */
public class HomeWork02SenderB {
    public static void main(String[] args) throws IOException {
        //接收端  数据包缓冲使用
        byte[] buf = new byte[1024];
        byte[] bytes = "四大名著是哪些？1".getBytes();
        //1、建立DatagramSocket
        DatagramSocket dgs = new DatagramSocket(7777);
        //2、打包要发送数据
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.31.169"), 8888);
        //3、发送数据包
        dgs.send(datagramPacket);

        //===================================receive==================
        datagramPacket = new DatagramPacket(buf, buf.length);
        dgs.receive(datagramPacket);
        byte[] data = datagramPacket.getData();
        int length = datagramPacket.getLength();
        System.out.println(new String(data,0,length));


        //关闭UDP套接字
        dgs.close();


    }
}
