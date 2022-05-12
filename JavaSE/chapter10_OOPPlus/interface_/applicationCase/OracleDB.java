package chapter10_OOPPlus.interface_.applicationCase;

public class OracleDB implements DBInterface{
    @Override
    public void connect() {
        System.out.println("oracle connect");
    }

    @Override
    public void close() {
        System.out.println("Oracle close");
    }
}
