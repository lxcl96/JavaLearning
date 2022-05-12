package chapter21_网络编程.HomeWork;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author : Ly
 * @Date : 2022/4/9
 * @Description :
 * 1、使用字符流的方式，编写一个客户端程序和服务器端程序
 * 2、客户端发送”name“，服务器端接收后返回 ”我是nova“
 * 3、客户端发送”hobby“，服务器端返回”编写Java程序“
 * 4、不是这两个问题的，回复”你说啥呢?“
 */
public class HomeWork01Client {
    public static void main(String[] args) throws IOException {
        //客户端

        String s;
        //1、建立Socket连接
        Socket socket = new Socket(InetAddress.getByName("192.168.31.169"), 8888);
        //2、获取Socket输出流
        OutputStream outputStream = socket.getOutputStream();
        //发送数据
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        //bw.write("hobby");
        //bw.write("hobby");
        bw.write("hello");
        //保存输出流数据
        bw.flush();
        //3、关闭输出流
        socket.shutdownOutput();

        //=====================================reply==========================
        //3、获取输入流
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        //4、读取数据
        s = br.readLine();
        System.out.println("收到来自服务端的新消息：" + s);
        //关闭Socket连接
        br.close();
        bw.close();
        socket.close();

    }
}
