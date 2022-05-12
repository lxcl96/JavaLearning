package chapter10_OOPPlus.interface_.applicationCase;

public class Program {
    public static void main(String[] args) {
        //选择使用那个数据库
        MysqlDB mysql = new MysqlDB();
        OracleDB oracle = new OracleDB();
        DB2 db2 = new DB2();

        //使用接口连接
        Apply apply = new Apply();
        apply.connect(mysql);

    }
}
