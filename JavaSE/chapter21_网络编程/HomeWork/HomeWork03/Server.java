package chapter21_网络编程.HomeWork.HomeWork03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author : Ly
 * @Date : 2022/4/9
 * @Description :
 * 1、编写客户端程序和服务器端程序
 * 2、客户端可以输入一个音乐文件名，比如高山流水 ，服务器收到音乐名后，可以给客户端返回这个音乐文件，如果服务器没有这个文件，返回默认音乐即可
 * 3、客户端收到文件后，保存到本地d://
 * 4、该程序可以使用StreamUtils.java
 */
public class Server {
    public static void main(String[] args) throws Exception {
        //服务器
        String defaultMp3 = "D:\\JavaWork\\JavaLearning\\src\\chapter21_网络编程\\HomeWork\\HomeWork03\\server\\无名.mp3";
        String filePath = "D:\\JavaWork\\JavaLearning\\src\\chapter21_网络编程\\HomeWork\\HomeWork03\\server\\高山流水.mp3";
        String filename;

        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("等待客户端连接....");
        Socket socket = serverSocket.accept();
        System.out.println("客户端连接成功，准备获取用户检索内容！");

        //获取Socket输入流 读取信息
        filename = StreamUtils.streamToString(socket.getInputStream());

        System.out.println("用户检索内容：" + filename);
//        filePath = filePath + File.separator + filename;
        System.out.println(filePath);
//        if (!new File(filePath).exists()) {
        if (!"高山流水".equals(filename.replace("\r\n",""))) {
            System.out.println("未找到，返回默认音乐！");
            filePath = defaultMp3;
        }

        //读取服务器上文件
        byte[] bytes = StreamUtils.streamToByteArray(new FileInputStream(filePath));

        //获取Socket输出流  写入数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(bytes);
        outputStream.flush();//可写可不写
        socket.shutdownOutput();//关闭输出流

        outputStream.close();
        socket.close();
        serverSocket.close();


    }
}
