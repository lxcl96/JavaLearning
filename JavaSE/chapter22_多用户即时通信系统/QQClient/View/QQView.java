package chapter22_多用户即时通信系统.QQClient.View;

import chapter22_多用户即时通信系统.QQClient.service.UserClientService;
import chapter22_多用户即时通信系统.QQClient.utils.Utility;

/**
 * @Author : Ly
 * @Date : 2022/4/11
 * @Description : 客户端登陆界面
 */
public class QQView {
    private boolean loop = true;//显示菜单
    private String key = null;//接受用户键盘输入
    //用户登录服务器或注册用户
    private UserClientService userClientService = new UserClientService();

    //显示主菜单
    public void mainMenu() {
        while (loop) {
            System.out.println("========欢迎登陆网络通信系统========");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.println("请输入你的选择：");
            key = Utility.readString(1);

            //根据用户的输入处理不同的逻辑
            switch (key) {
                case "1":
                    System.out.println("登录系统中：");
                    System.out.print("请输入用户号：");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密码：");
                    String pwd = Utility.readString(50);
                    //需要到服务端进行用户校验 UserClientService
                    if (userClientService.checkUser(userId,pwd)) {
                        System.out.println("欢迎 " + userId + ", 登陆成功！");
                        //进入到二级菜单
                        while (loop) {
                            System.out.println(String.format("========网络通信系统二级菜单（用户 %s）========",userId));
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.println("请输入你的选择：");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    System.out.println("显示在线用户列表：");
                                    userClientService.userList();
                                    break;
                                case "2":
                                    System.out.println("群发消息");
                                    System.out.print("请输入想要说的话：");
                                    String msgPublic = Utility.readString(500);
                                    userClientService.chatPublic(userId,msgPublic);
                                    System.out.println(userId + " 对 所有人说：" + msgPublic);
                                    break;
                                case "3":
                                    System.out.println("私聊消息");
                                    System.out.print("请输入想要聊天的对象用户号(在线)：");
                                    String friendsId = Utility.readString(50);
                                    System.out.print("请输入想要说的话：");
                                    String chatContent = Utility.readString(500);
                                    userClientService.chatPrivacy(friendsId,chatContent);
                                    System.out.println("-" + userId + " 对 " + friendsId + "说：" + chatContent);
                                    break;
                                case "4":
                                    System.out.println("发送文件");
                                    System.out.print("请输入想要想要发送文件的用户号(在线)：");
                                    String friendId = Utility.readString(50);
                                    System.out.print("请输入发送文件的完整路径(形式 d:\\xxx.jpg)：");
                                    String filePath = Utility.readString(500);
                                    userClientService.fileTransfer(userId, friendId, filePath);
                                    break;
                                case "9":
                                    System.out.println("退出系统");
                                    loop = false;
                                    //向服务器发送关闭客户端线程命令
                                    userClientService.SysExit();
                            }
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        System.out.println("登陆服务器失败");
                    }
                    break;
                case "9":
                    System.out.println("退出系统");
                    break;
            }
        }
    }
}
