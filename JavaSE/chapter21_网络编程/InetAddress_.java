package chapter21_网络编程;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author : Ly
 * @Date : 2022/4/7
 * @Description : 学习InetAddress类的相关方法
 *                1、获取本机InetAddress对象，getLocalHost
 *                2、根据指定主机名、域名获取ip地址对象，getByName
 *                3、获取 InetAddress对象的主机名，getHostName
 *                4、获取InetAddress对象的地址 getHostAddress
 */
public class InetAddress_ {
    public static void main(String[] args) throws UnknownHostException {
        //1、获取本机InetAddress对象，getLocalHost
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        // 2、根据指定主机名、域名获取ip地址对象，getByName
        InetAddress lxcl96 = InetAddress.getByName("lxcl96");
        System.out.println(lxcl96);
        InetAddress bd = InetAddress.getByName("www.baidu.com");
        System.out.println(bd + bd.getHostName());

        //3、获取 InetAddress对象的主机名，getHostName
        System.out.println(lxcl96.getHostName());

        //获取InetAddress对象的地址 getHostAddress
        System.out.println(lxcl96.getHostAddress());
    }
}
