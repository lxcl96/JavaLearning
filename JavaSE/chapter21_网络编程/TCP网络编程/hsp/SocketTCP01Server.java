package chapter21_网络编程.TCP网络编程.hsp;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author : Ly
 * @Date : 2022/4/7
 * @Description : 1、编写一个服务器端，和一个客户端
 *  *                2、服务器端口在9999端口监听
 *  *                3、客户端连接到服务器端，发送“hello,server”,然后退出
 *  *                4、服务器端接受到客户端发的信息，输出并退出。
 *  *
 *  *
 *  *              思路：
 *  *                服务器端
 *  *                1、服务器端的监听9999端口，等待链接 new ServerSocket()
 *  *                2、当没有客户端连接服务器端的9999端口时，程序会阻塞等待连接
 *  *                3、通过Socket.getInputStream()读取客户端写入到数据通道的数据
 *  *
 *  *                客户端
 *  *                1、知道ip和端口
 *  *                2、连接上会生出一个Socket，通过Socket.getOutputStream()
 *  *                3、通过输出流，写入数据到数据通道
 *  */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        int chr = 0;
        //服务端
        //创建Socket对象 代表监听本机的9999端口
        ServerSocket serverSocket = new ServerSocket(9999);//ServerSocket可以使用accept方法，返回多个Socket，这样可以多个计算机连接到同一个服务器上
        //System.out.println("serverSocket信息： " + serverSocket);
        //开始监听9999端口 如果没有连接会一直堵塞，如果有就输出
        Socket socket = serverSocket.accept();

        //输出接受到的信息 //监听9999端口，收到消息后读取输出到控制台
        BufferedInputStream bi = new BufferedInputStream(socket.getInputStream());
        while ((chr = bi.read()) != -1) {
            System.out.print((char)chr);
        }



        //关闭Socket
        bi.close();
        socket.close();
        serverSocket.close();

    }
}
