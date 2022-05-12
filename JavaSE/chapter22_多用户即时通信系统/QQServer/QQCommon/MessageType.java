package chapter22_多用户即时通信系统.QQServer.QQCommon;

/**
 * @Author : Ly
 * @Date : 2022/4/11
 * @Description : 消息类型
 */
public interface MessageType {
    String MESSAGE_LOGIN_SUCCEED = "1";//登陆成功
    String MESSAGE_LOGIN_FAILED = "2";//登陆失败
    String MESSAGE_ONLINE_USER = "ONLINE_USER";//所有在线用户
    String MESSAGE_COMM_MES = "3";//普通消息

    String ERROR_NOT_ONLINE = "4";//错误消息，接受者不在线
    String ERROR_CHAT_WITH_YOURSELF = "5";//错误消息，和自己聊天

    String MESSAGE_COMM_MES_ALL = "6";//群聊普通消息

    String MESSAGE_FILE_MES = "FILE";//私聊文件

    String MESSAGE_CLIENT_EXIT = "EXIT";//用于实现客户端无异常退出


}
