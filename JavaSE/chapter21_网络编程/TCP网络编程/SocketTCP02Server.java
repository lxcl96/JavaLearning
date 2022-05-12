package chapter21_网络编程.TCP网络编程;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author : Ly
 * @Date : 2022/4/7
 * @Description : 1、编写一个服务端和一个客户端
 *                2、服务器端在9999端口监听
 *                3、客户端连接到服务器端，发送”hello,server“，并接受服务器端发送的"hello，client"输出再退出
 *                4、服务器端接受到客户端发送的信息，输出，并发送hello，client"再退出
 */
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[1024];
        int len = 0 ;
        //服务器端
        //开启Socket，监听9999端口
        ServerSocket server = new ServerSocket(9999);

        //监听9999端口 有没有连接
        Socket accept = server.accept();

        //获取套接字的 输入流，读取信息
        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();

        System.out.println((char) inputStream.read());
//        while ((len = inputStream.read(bytes)) != -1) {
//            System.out.print(new String(bytes, 0, len));
//        }

        //Socket不知道啥时候读取结束，所以会卡住
            //因此需要设置一个结束读取标记，进行下一步

        //获取输出流，写入消息
        System.out.println("服务端开始发送");
        outputStream.write("hello,client".getBytes());


        outputStream.close();
        inputStream.close();
        accept.close();
        server.close();

    }
}
