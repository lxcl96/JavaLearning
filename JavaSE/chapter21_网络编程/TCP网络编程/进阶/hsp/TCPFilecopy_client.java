package chapter21_网络编程.TCP网络编程.进阶.hsp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author : Ly
 * @Date : 2022/4/8
 * @Description :
 * 1、编写一个TCP服务端和一个客户端
 * 2、服务器端在8888端口监听
 * 3、客户端连接到服务端，发送一张照片，
 * 4、服务端收到照片，保存到服务端同路径下，保存成功后发送“收到图片”，然后退出
 * 5、客户端接受到服务端发送的“收到图片”，再退出
 * 6、程序要求使用StreamUtils.java
 *
 * 说明使用BufferedInputStream和BufferedOutputSream字节流
 */
public class TCPFilecopy_client {
    public static void main(String[] args) throws Exception {
        String s = null;
        String filePath = "C:\\Users\\Administrator\\Pictures\\wlq.png";
        //建立Socket连接
        System.out.println("加入socket中...");
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("socket加入成功！");

        //读取本地图片 写入到socket输出流
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(filePath));

        byte[] bytes = StreamUtils.streamToByteArray(bin);

        //获取到连接的输出流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        //写入Socket输出流
        bos.write(bytes);
        //文件写完了 关闭Socket输出流
        socket.shutdownOutput();
        //关闭本地文件输入流
        bin.close();

        //获取Socket的输入流 等待服务器发送消息
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf8"));
        s = br.readLine();
        System.out.println(s);
        //判断返回消息
        if ("收到图片".equals(s)) {
            System.out.println("成功！！");
        } else {
            System.out.println("失败！！");
        }

        br.close();
        bos.close();
        socket.close();

    }
}
