package chapter21_网络编程.HomeWork;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

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
public class HomeWork02ReceiverA {
    public static void main(String[] args) throws IOException {
        //接收端  数据包缓冲使用
        byte[] buf = new byte[1024];
        byte[] reply;

        //1、建立UDP Socket
        DatagramSocket dgs = new DatagramSocket(8888);
        //2、建立一个DatagramPacket用于接收数据包       参数说明：缓冲数组    长度
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        //3、接收端开开始等待接收
        dgs.receive(datagramPacket);

        //4、准备拆包，读取数据信息
        byte[] data = datagramPacket.getData();
        int length = datagramPacket.getLength();
        String s = new String(data, 0, length);

        System.out.println(s);
        if ("四大名著是哪些？".equals(s)) {
            reply = "四大名著是《红楼梦》...".getBytes();
        } else {
            reply = "What?".getBytes();
        }
        //===================================reply==================
        datagramPacket = new DatagramPacket(reply, reply.length, InetAddress.getByName("192.168.31.169"),7777);
        dgs.send(datagramPacket);

        //程序退出
        dgs.close();

    }
}


