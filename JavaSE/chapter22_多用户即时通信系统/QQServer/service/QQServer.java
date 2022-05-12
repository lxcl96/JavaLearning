package chapter22_多用户即时通信系统.QQServer.service;

import chapter22_多用户即时通信系统.QQServer.QQCommon.Message;
import chapter22_多用户即时通信系统.QQServer.QQCommon.MessageType;
import chapter22_多用户即时通信系统.QQServer.QQCommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author : Ly
 * @Date : 2022/4/11
 * @Description : 这是服务器，在监听9999端口 ，并保持通信
 */
public class QQServer {
    //socket服务器，只一个Socket
    private ServerSocket serverSocket;
    //用户集合，用hashmap代替数据库   也可以换成 ConcurrentHashMap 可以处理线程并发问题[线程安全的]
    //HashMap没有处理线程安全的
    private static ConcurrentHashMap<String,User> vaildUser = new ConcurrentHashMap<>();
    //用户库
    static {
        vaildUser.put("100",new User("100","123456"));
        vaildUser.put("200",new User("200","123456"));
        vaildUser.put("300",new User("300","123456"));
        vaildUser.put("至尊宝",new User("至尊宝","123456"));
        vaildUser.put("紫霞仙子",new User("紫霞仙子","123456"));
        vaildUser.put("菩提老祖",new User("菩提老祖","123456"));
    }

    private boolean checkUser(User user) {
        if (!(vaildUser.containsKey(user.getName()) && (vaildUser.get(user.getName())).getPasswd().equals(user.getPasswd()))) {
            return false;
        }
        //单点登陆
        if (ManageServerConnectClientThread.getServerToClientThread(user.getName()) != null) {
            System.out.println("用户　" + user.getName() + "　已经登录了");
            return false;
        }
        return true;
    }
    public QQServer() {
        System.out.println("服务端在9999端口监听");
        try {
            serverSocket = new ServerSocket(9999);
            //循环监听，毕竟会有很多客户端连接到服务器的

            //启动新闻推送线程
            pushNews pushNews = new pushNews();
            pushNews.setDaemon(true);//设置为守护线程
            pushNews.start();
            while (true) {
                System.out.println("等待客户端连接：");
                Socket socket = serverSocket.accept();

                //读取Socket输入流 获取ObjectInputStream
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                try {
                    User user = (User) ois.readObject();//第一次发的是User对象

                    //关闭不用的火速入流·输入流  不能用ois.close()  不能加
                    //socket.shutdownInput();
                    //发送回去一个Message对象
                    Message message = new Message();
                    //数据验证
                    //if ("100".equals(user.getName()) && "123456".equals(user.getPasswd())) {
                    if (checkUser(user)) {
                        System.out.println("user=" + user.getName() + "  pwd=" + user.getPasswd() + "服务器端登陆成功 ！");
                        message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                        oos.writeObject(message);
                        oos.flush();
                        //关闭不用的输入输出流 不能用oos.close()
                        //socket.shutdownOutput();

                        //创建一个线程和客户端保持通信,该线程持有socket对象
                        ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(user.getName(), socket);
                        serverConnectClientThread.start();
                        //加入到线程管理
                        ManageServerConnectClientThread.addServerToClientThread(user.getName(), serverConnectClientThread);
                    } else {//登录失败
                        System.out.println("user=" + user.getName() + "  pwd=" + user.getPasswd() + "服务器端登陆失败 ！" );

                        message.setMesType(MessageType.MESSAGE_LOGIN_FAILED);
                        oos.writeObject(message);
                        oos.flush();
                        socket.shutdownOutput();

                        //关闭Socket
                        socket.close();
                    }


                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //如果服务器关闭了while循环 就需要关闭serverSocket服务器
            //执行到这就表示while循环已经执行完了
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
