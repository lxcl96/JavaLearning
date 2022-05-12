package chapter22_多用户即时通信系统.QQClient.service;

import java.util.HashMap;

/**
 * @Author : Ly
 * @Date : 2022/4/11
 * @Description : 管理客户端到服务器通信的socket线程类
 */
public class ManageClientConnectServerThread {
    //把多个线程放到一个HashMap集合中，其中key为用户ID，value为客户端到服务端socket通信的线程
    private static HashMap<String,ClientConnectServerThread> hashMap = new HashMap<>();

    public static void addClientToServerThread(String uid, ClientConnectServerThread c) {
        hashMap.put(uid, c);
    }

    //通过用户id获取该用户下的线程
    public static ClientConnectServerThread getServerToClientThread(String uid) {
        return hashMap.get(uid);
    }

    //去掉指定的键值对
    public static void removeRunClient(String uid) {
        hashMap.remove(uid);
    }
}
