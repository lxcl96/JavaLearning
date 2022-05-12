package chapter21_网络编程.TCP网络编程;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author : Ly
 * @Date : 2022/4/8
 * @Description :       [字符流]
 *                      1、编写一个服务端和一个客户端
 *  *  *                2、服务器端在9999端口监听
 *  *  *                3、客户端连接到服务器端，发送”hello,server“，并接受服务器端发送的"hello，client"输出再退出
 *  *  *                4、服务器端接受到客户端发送的信息，输出，并发送hello，client"再退出
 */
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        String s = null;
        ServerSocket server = new ServerSocket(9998);
        System.out.println(server);
        Socket accept = server.accept();
        System.out.println("服务端" + accept);

        //用转换流来处理字节流,然后在包装成BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream(), "utf8"));

        //设置结束标记 bw.newLine();需要服务器使用readLine()来读取，才能成功读取到结束标记
//        while ((s = br.readLine()) != null) {
//            System.out.println(s);
//            System.out.println("hahah");
//        }
        s = br.readLine(); //使用换行符为结束 则只能读取一行，while循环还是要用shutdownOutput
        System.out.println(s);
        //断开输出流
        //accept.shutdownOutput();
        //获取输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream(), "utf8"));
        bw.write("你好，客户端！");
        //设置结束标记
        bw.newLine();
        bw.flush();


        //关闭所有连接
        bw.close();
        br.close();
        accept.close();
        server.close();


    }
}
