package chapter08_intermediate.HomeWork;

public class Account {

    public String name;
    private double balance;
    public String passwd;

    public Account() {
    }

    public Account(String name, double balance, String passwd) {
        setName(name);
        setBalance(balance);
        setPasswd(passwd);
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <=4)
            this.name = name;
        else {
            System.out.println("name长度不在2-4之间，默认Unknown");
            this.name = "Unknown";
        }
    }

    public void setBalance(double balance) {
        if (balance > 20)
            this.balance = balance;
        else {
            System.out.println("balance必须大于20，默认2000");
            this.balance = 2000;
        }
    }

    public void setPasswd(String passwd) {
        if (passwd.length() == 6)
            this.passwd = passwd;
        else {
            System.out.println("passwd必须为6位，默认000000");
            this.passwd = "000000";
        }
    }

    public void ino() {
        System.out.println("此人信息位：");
        System.out.println("name=" + name + " balance=" + balance + " passwd= " + passwd);
    }
}
