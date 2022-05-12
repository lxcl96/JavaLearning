package chapter21_网络编程.test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : Ly
 * @Date : 2022/4/12
 * @Description : 测试客户端和输入端同时获取输入输出流
 */
public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("等待客户端连接：" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        Socket socket = serverSocket.accept();

        System.out.println("服务器端开始读");
        //读取Socket输入流 获取ObjectInputStream
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        System.out.println(ois.readUTF());


        System.out.println("服务器端开始写");
        oos.writeUTF("server to client massage");
        oos.flush();


        oos.close();
        ois.close();
        socket.close();
        serverSocket.close();
    }
}
