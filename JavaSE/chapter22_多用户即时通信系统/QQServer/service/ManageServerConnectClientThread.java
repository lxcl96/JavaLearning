package chapter22_多用户即时通信系统.QQServer.service;



import java.util.*;

/**
 * @Author : Ly
 * @Date : 2022/4/11
 * @Description : 管理服务器到客户端通信的socket线程类
 */
public class ManageServerConnectClientThread {
    //把多个线程放到一个HashMap集合中，其中key为用户ID，value为客户端到服务端socket通信的线程
    private static HashMap<String, ServerConnectClientThread> hashMap = new HashMap<>();

    public static void addServerToClientThread(String uid, ServerConnectClientThread s) {
        hashMap.put(uid, s);
    }

    //通过用户id获取该用户下的线程
    public static ServerConnectClientThread getServerToClientThread(String uid) {
        return hashMap.get(uid);
    }

    //遍历server线程集合，获得uid
    public static Set<String> uidList() {
        //hashMap.keySet()没有被序列化不能直接传输
        return new HashSet<>(hashMap.keySet());
    }

    //去掉要关闭的线程
    public static void removeRunClient(String uid) {
        System.out.println("----------------" + hashMap +"--------------删除" + uid + "前");
        hashMap.remove(uid);
        System.out.println("----------------" + hashMap +"---------------删除" + uid + "后");
    }
}
