package chapter21_网络编程.test;

import chapter22_多用户即时通信系统.QQServer.QQCommon.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author : Ly
 * @Date : 2022/4/12
 * @Description : 测试客户端和输入端同时获取输入输出流
 */
public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("192.168.31.169"),9999);
        //得到ObjectOutputStream 对象，进行传输
        System.out.println("客户端开始写");
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeUTF("client to server message！");
        oos.flush();



        System.out.println("客户端开始读");
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        System.out.println(ois.readUTF());

        ois.close();
        oos.close();
        socket.close();
    }
}
