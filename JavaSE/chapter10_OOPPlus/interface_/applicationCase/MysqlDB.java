package chapter10_OOPPlus.interface_.applicationCase;

public class MysqlDB implements DBInterface {
    @Override
    public void connect() {
        System.out.println("MySql数据库连接");
    }

    @Override
    public void close() {
        System.out.println("MySql 数据库关闭");
    }
}
