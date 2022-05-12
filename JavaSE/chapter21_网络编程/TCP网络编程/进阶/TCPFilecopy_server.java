package chapter21_网络编程.TCP网络编程.进阶;

import com.sun.xml.internal.ws.util.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
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

public class TCPFilecopy_server {
    public static void main(String[] args) throws IOException, InterruptedException {
        byte[] bytes = new byte[1024];
        int readLen = 0;
        String s = null;
        //String filePath = "D:\\JavaWork\\JavaLearning\\src\\chapter21_网络编程\\TCP网络编程\\进阶\\wlq.png";
        String filePath = "D:\\JavaWork\\JavaLearning\\src\\chapter21_网络编程\\TCP网络编程\\进阶\\iauto-4.5.2.all.42992.20200511.zip";

        //创建server服务器
        ServerSocket server = new ServerSocket(8888);
        System.out.println("等待socket加入...");
        //监听Socket连接 ，会在此堵塞
        Socket accept = server.accept();
        System.out.println("等待socket加入成功！" + accept);
        Thread.sleep(1000);
        //获取Socket的输入流
        BufferedInputStream bin = new BufferedInputStream(accept.getInputStream());
        //获取本地保存路径的输出流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));

        //判断Socket输入流还有没有数据
        while ((readLen = bin.read(bytes)) != -1) { //读取的数据bytes[] 0-readLen
            //写入Socket输出流
            bos.write(bytes,0,readLen);
        }
        bos.close();

        //文件保存成功，开始发送消息
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream(), "utf8"));
        bw.write("收到图片");
        bw.flush(); //保存数据
        accept.shutdownOutput();

        System.out.println("回复完成");
        bw.close();
        bin.close();
        accept.close();
        server.close();

    }

}
