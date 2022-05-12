package chapter08_intermediate.HomeWork;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();
        account.setName("李明");
        account.setBalance(30);
        account.setPasswd("123456");
//        account.ino();


        Account account1 = new Account("tom GG", 10, "123456");
        account1.ino();

    }


}
