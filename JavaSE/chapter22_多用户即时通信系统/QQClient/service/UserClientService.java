package chapter22_多用户即时通信系统.QQClient.service;

import chapter22_多用户即时通信系统.QQClient.utils.StreamUtils;
import chapter22_多用户即时通信系统.QQServer.QQCommon.Message;
import chapter22_多用户即时通信系统.QQServer.QQCommon.MessageType;
import chapter22_多用户即时通信系统.QQServer.QQCommon.User;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author : Ly
 * @Date : 2022/4/11
 * @Description : 进行用户登陆和用户注册功能
 */
public class UserClientService {
    //把User做成一个属性，因为我们在其他地方可能会用到User信息
    private User u = new User();
    //因为Socket在其他地方可能也会用到，所以做成属性
    Socket socket;
    /**
     *
     * @param userId 用户名
     * @param pwd 密码
     * @return 用户名和密码去服务器端判断是否存在该用户
     */
    public boolean checkUser(String userId, String pwd) {
        boolean res = false;
        //创建一个User对象
        u.setName(userId);
        u.setPasswd(pwd);
        //发送User对象到服务器端
        try {
            socket = new Socket(InetAddress.getByName("192.168.31.169"),9999);
            //得到ObjectOutputStream 对象，进行传输
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);
            oos.flush();
            //关闭输出流 不能用oos.close()会导致socket关闭
            //socket.shutdownOutput();


            //读取从服务端返回的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message)ois.readObject();
            //关闭不用的输入输出流 不能用ois.close()会导致socket关闭
             //socket.shutdownInput();
            //关闭不用的输入输出流
//            ois.close();
//            oos.close();
            if (MessageType.MESSAGE_LOGIN_SUCCEED.equals(ms.getMesType())) {
                //需要启动一个线程，保持客户端和服务端一直保持通信 因此需要创建一个线程类==>ClientConnectServerThread
                ClientConnectServerThread cClientConnectServerThread = new ClientConnectServerThread(socket);
                cClientConnectServerThread.start();
                //多用户建议把线程放在集合中
                ManageClientConnectServerThread.addClientToServerThread(userId, cClientConnectServerThread);
                res =  true;//更安全
            } else {
                //如果失败了，线程就不会启动，因此需要将启动的socket关闭，节约资源
                //因为不是总是会关闭的，所以不用写finally
                socket.close();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

    //向服务器端请求在线用户列表
    public void userList() {
        try {
            //创建对象
            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_ONLINE_USER);
            message.setSender(u.getName());
            message.setReceiver("server");
            //得到ObjectOutputStream 对象，进行传输
            //hsp的socket这样取得
                //new ObjectOutputStream(ManageClientConnectServerThread.getServerToClientThread(u.getName()).getSocket().getOutputStream())
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());//
            oos.writeObject(message);
            oos.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //关闭用户线程，同时发送消息给服务器让服务器也关闭对应Socket线程
    public void SysExit() {
        try {
            //创建对象
            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
            message.setSender(u.getName());

            //得到ObjectOutputStream 对象，进行传输
            //hsp的socket这样取得 【一个客户端多个线程,退出指定用户的线程方法的方法】
            //new ObjectOutputStream(ManageClientConnectServerThread.getServerToClientThread(u.getName()).getSocket().getOutputStream())
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());//
            oos.writeObject(message);
            oos.flush();
            //关闭输出流 不能用oos.close()会导致socket关闭
            socket.shutdownOutput();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     * @param friendId 要私聊的用户id
     * @param chatContent 私聊内容
     */
    public void chatPrivacy(String friendId, String chatContent) {
        //私聊在线好友
        try {
            //创建对象
            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_COMM_MES);
            message.setSender(u.getName());
            message.setReceiver(friendId);
            message.setContent(chatContent);

            //得到ObjectOutputStream 对象，进行传输
            //hsp的socket这样取得 【一个客户端多个线程,退出指定用户的线程方法的方法】
            //new ObjectOutputStream(ManageClientConnectServerThread.getServerToClientThread(u.getName()).getSocket().getOutputStream())
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());//
            oos.writeObject(message);
            oos.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     * @param sender 发送者
     * @param chatContent 私聊内容
     */
    public void chatPublic(String sender, String chatContent) {
        //群发在线好友
        try {
            //创建对象
            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_COMM_MES_ALL);
            message.setSender(u.getName());
            message.setContent(chatContent);

            //得到ObjectOutputStream 对象，进行传输
            //hsp的socket这样取得 【一个客户端多个线程,退出指定用户的线程方法的方法】
            //new ObjectOutputStream(ManageClientConnectServerThread.getServerToClientThread(u.getName()).getSocket().getOutputStream())
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());//
            oos.writeObject(message);
            oos.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向指定用户发送文件
     * @param sender 发送者
     * @param receiver 接受者
     * @param filePath 文件路径
     */
    public void fileTransfer(String sender, String receiver, String filePath) {
        byte[] file = null;
        //文件不存在 直接退出
        if (!new File(filePath).exists()) {
            System.out.println("文件不存在，请检查文件路径！ "  + filePath);
            return;
        }
        //如果文件存在
        try {
            file = StreamUtils.streamToByteArray(new BufferedInputStream(new FileInputStream(filePath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //群发在线好友
        try {
            //创建对象
            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_FILE_MES);
            message.setSender(sender);
            message.setReceiver(receiver);
            String[] split = filePath.replace("\\","#").split("#");
            System.out.println("********************" + split[split.length - 1]);
            message.setFileName(split[split.length - 1]);
            message.setContent(file);

            //得到ObjectOutputStream 对象，进行传输
            //hsp的socket这样取得 【一个客户端多个线程,退出指定用户的线程方法的方法】
            //new ObjectOutputStream(ManageClientConnectServerThread.getServerToClientThread(u.getName()).getSocket().getOutputStream())
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());//
            oos.writeObject(message);
            oos.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sender + " 给 " + receiver + "发送了一个文件!");
    }
}
