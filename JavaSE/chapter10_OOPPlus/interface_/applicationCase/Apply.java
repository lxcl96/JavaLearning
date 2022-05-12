package chapter10_OOPPlus.interface_.applicationCase;

public class Apply {

    //使用接口调用数据库连接
    public void connect(DBInterface dbInterface) {
        dbInterface.connect();
    }

    public void close(DBInterface dbInterface) {
        dbInterface.close();
    }


}
