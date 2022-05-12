package chapter21_网络编程.TCP网络编程;

import com.sun.xml.internal.ws.util.StreamUtils;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author : Ly
 * @Date : 2022/4/7
 * @Description :    1、编写一个服务端和一个客户端
 *  *                2、服务器端在9999端口监听
 *  *                3、客户端连接到服务器端，发送”hello,server“，并接受服务器端发送的"hello，client"输出再退出
 *  *                4、服务器端接受到客户端发送的信息，输出，并发送hello，client"再退出
 */
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        //客户端
        byte[] bytes = new byte[1024];
        int len = 0 ;
        //连接到服务端
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //获取输出流，写入消息
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        outputStream.write("hello,server".getBytes());

        //Socket不知道啥时候写入结束，所以会卡住
            //因此需要设置一个结束写入标记，进行下一步
            //客户端必须要关闭写入  原因未知？？？？？
       // socket.shutdownOutput();

        //获取套接字的 输入流，读取信息
        System.out.println("客户端开始接受");
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.print(new String(bytes, 0, len));
        }

        inputStream.close();
        outputStream.close();
        socket.close();

    }
}
