package chapter21_网络编程.HomeWork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author : Ly
 * @Date : 2022/4/9
 * @Description :
 * 1、使用字符流的方式，编写一个客户端程序和服务器端程序
 * 2、客户端发送”name“，服务器端接收后返回 ”我是nova“
 * 3、客户端发送”hobby“，服务器端返回”编写Java程序“
 * 4、不是这两个问题的，回复”你说啥呢?“
 */
public class HomeWork01Server {
    public static void main(String[] args) throws IOException {
        //服务器端

        String s;
        String rep;
        //1、创建serverSocket
        ServerSocket serverSocket = new ServerSocket(8888);
        //2、等待Socket连接
        Socket accept = serverSocket.accept();
        System.out.println("有客户端接入Socket！");

        //3、获取输入流
        InputStream inputStream = accept.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        //4、读取数据
        s = br.readLine();
        System.out.println("收到来自客户端的新消息：" + s);
        if ("name".equals(s)) {
            rep = "我是nova";
        } else if ("hobby".equals(s)) {
            rep = "编写Java程序";
        } else {
            rep = "你说啥呢?";
        }

        //=====================================reply==========================
        OutputStream outputStream = accept.getOutputStream();
        //发送数据
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(rep);
        //保存输出流数据
        bw.flush();
        //关闭输出流
        accept.shutdownOutput();


        //关闭所有资源
        bw.close();
        br.close();
        accept.close();
        serverSocket.close();
    }
}

