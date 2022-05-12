package chapter22_多用户即时通信系统.QQServer.QQCommon;

import java.io.Serializable;

/**
 * @Author : Ly
 * @Date : 2022/4/11
 * @Description : 表示客户端和服务端通信时的消息对象
 */
public class Message implements Serializable {
    //为了提高兼容性，规定序列化版本
    private static final long serialVersionUID = 1l;
    private String sender;//表示发送者
    private String receiver;//表示接受者
    private Object content;//发送内容
    private String sendTime;//发送时间
    private String fileName;//文件名
    private String mesType;//表示消息类型【可以在接口中定义已知的类型】

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
