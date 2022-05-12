package chapter21_网络编程.TCP网络编程;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author : Ly
 * @Date : 2022/4/8
 * @Description :       【字符流】
 *                      1、编写一个服务端和一个客户端
 *  *  *                2、服务器端在9999端口监听
 *  *  *                3、客户端连接到服务器端，发送”hello,server“，并接受服务器端发送的"hello，client"输出再退出
 *  *  *                4、服务器端接受到客户端发送的信息，输出，并发送hello，client"再退出
 */
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        String s= null;
        Socket socket = new Socket(InetAddress.getLocalHost(), 9998);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf8"));
        bw.write("你好，服务端！");
        //设置结束标记 bw.newLine();需要服务器使用readLine()来读取，才能成功读取到结束标记
            //使用换行符为结束 则只能读取一行，while循环还是要用shutdownOutput
        bw.newLine();
        //***使用字符流需要手动刷新  否则保存不进去
        bw.flush();


        //断开输出流  需要客户端主动断开
        //socket.shutdownOutput();
        System.out.println("客户端" + socket);
        //等待服务端断开 输出流后进行下面代码
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf8"));
//        while ((s = br.readLine()) != null) {
//            System.out.println(s);
//        }
        s = br.readLine();//使用换行符为结束 则只能读取一行，while循环还是要用shutdownOutput
        System.out.println(s);


        //关闭所有连接
        br.close();
        bw.close();
        socket.close();
    }
}
