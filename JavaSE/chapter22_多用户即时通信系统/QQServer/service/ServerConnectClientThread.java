package chapter22_多用户即时通信系统.QQServer.service;

import chapter22_多用户即时通信系统.QQServer.QQCommon.Message;
import chapter22_多用户即时通信系统.QQServer.QQCommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Set;

/**
 * @Author : Ly
 * @Date : 2022/4/11
 * @Description : 该类对应的对象和某个客户端保持连接
 */
public class ServerConnectClientThread extends Thread{
    private Socket socket;
    private String uid;//指定和哪个客户端进行通信
    private boolean loop = true;

    public ServerConnectClientThread(String uid, Socket socket) {
        this.uid = uid;
        this.socket = socket;
    }

    /**
     * //获取所以在线用户列表 返回给和客户端
     */
    public void userList() {
        //获取所以在线用户
        Set<String> entries = ManageServerConnectClientThread.uidList();
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_ONLINE_USER);
        message.setContent(entries);
        //获取输出流
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //关闭服务器上对应的客户端Socket线程
    public void removeServerThread() {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setReceiver(uid);
        //先尝试直接关闭
        loop = false;
        // 获取输出流
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 服务器转发私聊消息/私聊文件
     * @param sender 发送者
     * @param receiver 接受者
     * @param content 内容
     * @param messageType 私聊消息类型
     * @param fileName 文件名
     */
    public void chatTransform(String sender, String receiver, Object content,String messageType,String fileName) {
        Boolean isOther = true;//判断是否当前为别人【receiver】的Socket进程，默认 是
        Socket s1 = null;
        Message message = new Message();
        message.setMesType(messageType);
        message.setReceiver(receiver);
        message.setSender(sender);
        message.setContent(content);

        if (MessageType.MESSAGE_FILE_MES.equals(messageType)) {
            message.setFileName(fileName);
        }

        //判断接受者是否是在线用户
        Set<String> entries = ManageServerConnectClientThread.uidList();
        if (!entries.contains(receiver)) {//接受者如果不在线，更新消息类型
            message.setMesType(MessageType.ERROR_NOT_ONLINE);
            message.setReceiver(sender);
            message.setSender("server");
            message.setContent("");
            isOther = false;
        }
        //不能给自己发
        if (receiver.equals(sender)) {
            message.setMesType(MessageType.ERROR_CHAT_WITH_YOURSELF);
            message.setReceiver(sender);
            message.setSender("server");
            message.setContent("");
            isOther = false;
        }

        //判断Socket的对象是否为receiver
        if (isOther) {
            s1 = ManageServerConnectClientThread.getServerToClientThread(receiver).getSocket();
        } else {
            s1 = ManageServerConnectClientThread.getServerToClientThread(sender).getSocket();
        }

        //开始发送消息
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s1.getOutputStream());
            oos.writeObject(message);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //群发消息
    public void chatPublic(String sender, Object content) {
        Socket s1 = null;
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES_ALL);
        message.setSender(sender);
        message.setReceiver("all");
        message.setContent(content);
        //获取所有在线用户
        Set<String> entries = ManageServerConnectClientThread.uidList();
        for (String entry:entries) {
            if (entry.equals(sender)) {
                continue;
            }
            //获取每个用户对应的socket
            s1 = ManageServerConnectClientThread.getServerToClientThread(entry).getSocket();

            //开始发送消息
            try {
                ObjectOutputStream oos = new ObjectOutputStream(s1.getOutputStream());
                oos.writeObject(message);
                oos.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void run() {
        //因为线程需要在后台一直保持和客户端通信，因此需要一直循环
        while (loop) {
            System.out.println(String.format("服务端线程" + Thread.currentThread().getName() +"等待读取从客户端/用户：%s 发来的消息！",uid));
            try {
                //如果输入流没有消息，会阻塞在这里
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message msg = (Message) ois.readObject();

                //判断获得消息类型
                switch (msg.getMesType()) {
                    case MessageType.MESSAGE_ONLINE_USER:
                        userList();
                        break;
                    case MessageType.MESSAGE_CLIENT_EXIT:
                        //发送关闭信息到客户端
                        removeServerThread();
                        //关闭服务器上对应的客户端Socket线程
                        ManageServerConnectClientThread.removeRunClient(uid);
                        ois.close();
                        socket.close();
                        break;
                    case MessageType.MESSAGE_COMM_MES:
                    case MessageType.MESSAGE_FILE_MES:
                        //拆分消息，并对应回复
                        chatTransform(msg.getSender(),msg.getReceiver(),msg.getContent(),msg.getMesType(),msg.getFileName());
                        break;
                    case MessageType.MESSAGE_COMM_MES_ALL:
                        //群发消息
                        chatPublic(msg.getSender(), msg.getContent());
                        break;
                    default:
                        System.out.println("用户线程" + uid + "非正确请求！");
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
}
