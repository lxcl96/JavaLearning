package chapter22_多用户即时通信系统.QQServer.service;

import chapter22_多用户即时通信系统.QQClient.utils.Utility;
import chapter22_多用户即时通信系统.QQServer.QQCommon.Message;
import chapter22_多用户即时通信系统.QQServer.QQCommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Set;

/**
 * @Author : Ly
 * @Date : 2022/4/14
 * @Description : 服务器启动时，开始此线程。给所有在线用户推送新闻
 */
public class pushNews extends Thread{


    @Override
    public void run() {
        System.out.println("*******启动守护线程 pushNews");
        while (true) {
            System.out.println("请输入你要推送的消息（输入exit退出新闻推送服务）：");
            String news = Utility.readString(500);
            if ("exit".equals(news))
                break;
            chatPublic("服务器",news);
            System.out.println("服务器 推送消息给 所有人 说：" + news);
        }
        System.out.println("*******退出守护线程 pushNews");
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
}
