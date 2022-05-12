package chapter10_OOPPlus.interface_.applicationCase;

public class DB2 implements DBInterface{
    @Override
    public void connect() {
        System.out.println("DB2 connnect");
    }

    @Override
    public void close() {
        System.out.println("DB2 close");
    }
}
