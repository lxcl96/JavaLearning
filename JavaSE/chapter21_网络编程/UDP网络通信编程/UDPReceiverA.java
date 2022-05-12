package chapter21_网络编程.UDP网络通信编程;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Author : Ly
 * @Date : 2022/4/9
 * @Description :
 *     1、编写一个接收端A和一个发送端B
 *     2、接收端A在9999端口等待接受数据receive
 *     3、发送端B向接收端A发送数据 ”hello，明天吃火锅~“
 *     4、接收端A收到B的消息 回复”好的，明天见~“再退出
 *     5、 发送端接受回复的数据，再退出
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //UDP包最大为64KB 即不能超过
        byte[] buf = new byte[1024];
        //1、创建一个DatagramSocket 准备接受数据
        DatagramSocket ds = new DatagramSocket(9999);

        //2、构建一个DatagramPacket对象用于接收数据
        DatagramPacket dp = new DatagramPacket(buf,buf.length);//数组，大小

        //3、准备接受数据包 接收到这里 [在9999端口等待接受，如果有就接受；如果没有，就阻塞]
        System.out.println("等待接收数据...");
        ds.receive(dp);

        //4、为了看到数据 需要拆包 //定义了1024个数组，实际长度可能不到
        int length = dp.getLength();
        byte[] data = dp.getData();//接受到的数据
        String s = new String(data, 0, length);
        //System.out.println(data.toString());
        System.out.println(s);

        if ("hello，明天吃火锅~".equals(s)) {
            //System.out.println("收到信息，准备回复。。。");
            byte[] bytes = "好的，明天见".getBytes();
            ds.send(new DatagramPacket(bytes,bytes.length, InetAddress.getByName("192.168.31.169"),8888));
            //System.out.println("发送信息成功！");
        } else {
            System.out.println("收到信息，但内容不对" + s);

        }
        //5关闭socket资源
        ds.close();

    }
}
