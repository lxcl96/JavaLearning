package chapter21_网络编程.UDP网络通信编程;

import java.io.IOException;
import java.net.*;

/**
 * @Author : Ly
 * @Date : 2022/4/9
 * @Description :
 *     1、编写一个接收端A 9999 和一个发送端B 8888
 *     2、接收端A在9999端口等待接受数据receive
 *     3、发送端B向接收端A发送数据 ”hello，明天吃火锅~“
 *     4、接收端A收到B的消息 回复”好的，明天见~“再退出
 *     5、 发送端接受回复的数据，再退出
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //UDP包最大为64KB 即不能超过
        byte[] buf = new byte[1024];
        byte[] bytes = "hello，明天吃火锅~".getBytes();
        //1、创建一个DatagramSocket 准备接受数据
        DatagramSocket ds = new DatagramSocket(8888);
        //2、构建一个DatagramPacket对象用于发送数据  InetAddress.getLocalHost()
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.31.169"), 9999);
        //3、发送数据包
        ds.send(dp);


        System.out.println("发送消息成功，准备接受信息！");
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        ds.receive(datagramPacket);
        //拆数据包
        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        String s = new String(data, 0, length);
        System.out.println(s);


        //关闭发送端
        ds.close();


    }
}
/*

 */