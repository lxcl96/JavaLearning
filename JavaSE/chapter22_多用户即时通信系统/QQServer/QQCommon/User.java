package chapter22_多用户即时通信系统.QQServer.QQCommon;

import java.io.Serializable;

/**
 * @Author : Ly
 * @Date : 2022/4/11
 * @Description : 表示一个用户信息
 */
public class User implements Serializable {//为了保存下来
    //为了提高兼容性，规定序列化版本
    private static final long serialVersionUID = 1l;
    private String name;//用户id,用户名
    private String passwd;//用户密码
    public User() {}
    public User(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
