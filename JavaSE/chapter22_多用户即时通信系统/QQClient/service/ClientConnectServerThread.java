package chapter22_多用户即时通信系统.QQClient.service;

import chapter22_多用户即时通信系统.QQClient.utils.Utility;
import chapter22_多用户即时通信系统.QQServer.QQCommon.Message;
import chapter22_多用户即时通信系统.QQServer.QQCommon.MessageType;
import chapter22_多用户即时通信系统.QQServer.service.ManageServerConnectClientThread;
import chapter22_多用户即时通信系统.QQServer.service.ServerConnectClientThread;

import java.io.*;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

/**
 * @Author : Ly
 * @Date : 2022/4/11
 * @Description :
 */
public class ClientConnectServerThread extends Thread{
    //该线程需要持有一个Socket
    private Socket socket;
    private boolean loop = true;

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //因为线程需要在后台一直保持和服务器通信，因此需要一直循环
        while (loop) {
            System.out.println("客户端线程" + Thread.currentThread().getName() + "等待读取从服务端发来的消息！");
            try {
                //如果输入流没有消息，会阻塞在这里
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message msg = (Message) ois.readObject();

                //判断获得消息类型
                switch (msg.getMesType()) {
                    case MessageType.MESSAGE_ONLINE_USER:
                        userList(msg);
                        break;
                    case MessageType.MESSAGE_CLIENT_EXIT:
                        //退出while循环
                        loop = false;
                        ////将停止的线程从线程集合中取出
                        ManageClientConnectServerThread.removeRunClient(msg.getReceiver());
                        ois.close();
                        socket.close();
                        break;
                    case MessageType.ERROR_NOT_ONLINE:
                        System.out.println("[!!只能和在线好友私聊]");
                        break;
                    case MessageType.ERROR_CHAT_WITH_YOURSELF:
                        System.out.println("[!!不能和自己私聊]");
                        break;
                    case MessageType.MESSAGE_COMM_MES:
                        //读取聊天内容
                        readPrivacy(msg);
                        break;
                    case MessageType.MESSAGE_COMM_MES_ALL:
                        //读取聊天内容
                        readPublic(msg);
                        break;
                    case MessageType.MESSAGE_FILE_MES:
                        //下载文件
                        fileDownload(msg);
                        break;
                    default:
                        System.out.println("server" + "非正确请求！ msg.getMesType() = " + msg.getMesType());
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            //要一直读取
        }

        System.out.println("客户端线程" + Thread.currentThread().getName() + "退出");
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    /**
     * 显示在线用户id
     * @param msg 消息对象
     */
    public void userList(Message msg) {
        Set<String> entries = (Set<String>)msg.getContent();
        if (entries == null || entries.isEmpty()) {
            System.out.println("***无在线用户");
        }

        assert entries != null;
        for (String s:entries) {
//            if ()
//                continue;
            System.out.println("***在线用户:" + s);
        }
    }

    //读取其他好友发来的私聊信息
    public void readPrivacy(Message msg) {
        String receiver = msg.getReceiver();
        String sender = msg.getSender();
        Object content = msg.getContent();

        System.out.println(sender + " 对 " + receiver + " 说：" + content.toString());
    }

    //读取其他好友发来的公共信息
    public void readPublic(Message msg) {
        String sender = msg.getSender();
        Object content = msg.getContent();

        System.out.println(sender + " 对 所有人说：" + content.toString());
    }

    //下载文件
    public void fileDownload(Message msg) {
        String choice = null;
        //下载私聊文件
        String receiver = msg.getReceiver();
        //String fileName = msg.getFileName();
        String sender = msg.getSender();
        //读取文件数组
        byte[] content = (byte[])msg.getContent();

        //输入按键冲突了，发生了越界异常
        /*
        while (true) {
            System.out.println("是否接受？ yes/no");
            try {
                choice = Utility.readString(3);
            } catch (IndexOutOfBoundsException e) {
                choice = Utility.readString(3);
            }
            if ("YES".equals(choice.toUpperCase()) || "Y".equals(choice.toUpperCase())) {
                break;
            }
        }
        System.out.println("请输入要保存的目录(形式 d:\\xxx\\xx)：");
        String directory = Utility.readString(100);

        //如果目录不存在，创建
        File file = new File(directory);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filePath = directory + File.separator + fileName;
        System.out.println("********************" + filePath);
        */
        String filePath = "d://a.txt";
        try {
            BufferedOutputStream bufferedOutputStream =
                    new BufferedOutputStream(new FileOutputStream(filePath));
            bufferedOutputStream.write(content);
            bufferedOutputStream.flush();

            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sender + " 给 " + receiver + " 发送文件已存放在" + filePath);

    }
}
