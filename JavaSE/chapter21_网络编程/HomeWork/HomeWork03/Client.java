package chapter21_网络编程.HomeWork.HomeWork03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author : Ly
 * @Date : 2022/4/9
 * @Description :
 * 1、编写客户端程序和服务器端程序
 * 2、客户端可以输入一个音乐文件名，比如高山流水 ，服务器收到音乐名后，可以给客户端返回这个音乐文件，如果服务器没有这个文件，返回默认音乐即可
 * 3、客户端收到文件后，保存到本地d://
 * 4、该程序可以使用StreamUtils.java
 */
public class Client {
    public static void main(String[] args) throws Exception {
        //客户端

        String filePath = "D:\\高山流水.mp3";
        Socket socket = new Socket(InetAddress.getByName("192.168.31.169"), 9999);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("高山流水");
        bw.flush();
        socket.shutdownOutput();


        byte[] bytes = StreamUtils.streamToByteArray(socket.getInputStream());
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        fileOutputStream.write(bytes);
        fileOutputStream.flush();

        fileOutputStream.close();
        bw.close();
        socket.close();


    }
}

