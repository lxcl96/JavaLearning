package chapter21_网络编程.TCP网络编程.hsp;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author : Ly
 * @Date : 2022/4/7
 * @Description : 1、编写一个服务器端，和一个客户端
 *                2、服务器端口在9999端口监听
 *                3、客户端连接到服务器端，发送“hello,server”,然后退出
 *                4、服务器端接受到客户端发的信息，输出并退出。
 *
 *
 *              思路：
 *                服务器端
 *                1、服务器端的监听9999端口，等待链接 new ServerSocket()
 *                2、当没有客户端连接服务器端的9999端口时，程序会阻塞等待连接
 *                3、通过Socket.getInputStream()读取客户端写入到数据通道的数据
 *
 *                客户端
 *                1、知道ip和端口
 *                2、连接上会生出一个Socket，通过Socket.getOutputStream()
 *                3、通过输出流，写入数据到数据通道
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //客户端
        InetAddress surfacePro3 = InetAddress.getByName("lxcl96");//服务器地址或主机名
        Socket socket = new Socket(surfacePro3, 9999); //直接写主机名也可以

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        //Socket会阻塞在这里，知道数据全部发送出去
        bufferedOutputStream.write("hello,server".getBytes());

        bufferedOutputStream.close();
        socket.close();

    }
}
