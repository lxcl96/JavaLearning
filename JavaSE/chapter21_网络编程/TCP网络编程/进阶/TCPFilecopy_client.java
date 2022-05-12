package chapter21_网络编程.TCP网络编程.进阶;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

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
 *
 * 经验总结：写入数据到流中，写完必须要收到flush()一下防止数据丢失或其他错误
 */
public class TCPFilecopy_client {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[1024];
        int readLen = 0;
        String s = null;
        //String filePath = "C:\\Users\\Administrator\\Pictures\\wlq.png";
        String filePath = "D:\\company\\资源库\\iauto-4.5.2.all.42992.20200511.zip";
        //建立Socket连接
        System.out.println("加入socket中...");
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("socket加入成功！" + socket);

        //读取本地图片 写入到socket输出流
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(filePath));
        //获取到连接的输出流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        while ((readLen = bin.read(bytes)) != -1) { //读取的数据bytes[] 0-readLen
            //写入Socket输出流
            bos.write(bytes,0,readLen);

        }
        //不加会报错 Exception in thread "main" java.net.SocketException: Socket closed
        //每次写完文件重新读都要刷新一下，等同于把写入到流里的数据保存下来
        bos.flush();  //close时会flush，但是cose太晚了所以，最好收到flush刷新
        //文件写完了 关闭Socket输出流
        socket.shutdownOutput();
        //关闭本地文件输入流
        bin.close();
        System.out.println("所有文件均上传完并关闭");
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
            //此处会报错 Exception in thread "main" java.net.SocketException: Socket closed
            //和服务端没关系，关闭的就是就是客户端自己的socket连接
            //报错原因就是 ：循环写入数据到流中，写完必须也要对应写入flush 否则会产生数据丢失 和其他错误【也可以在循环中写入】
            bos.close();
            socket.close();

    }
}
