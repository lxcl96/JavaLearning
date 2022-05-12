package chapter08_intermediate.HomeWork08;

public class HomwWork08 {
    public static void main(String[] args) {
//        BankAccount bankAccount = new BankAccount(2000);
//        System.out.println("余额：" + bankAccount.getBalance());
//        bankAccount.deposit(300);
//        System.out.println("余额：" + bankAccount.getBalance());
//        bankAccount.withdraw(299);
//        System.out.println("余额：" + bankAccount.getBalance());
//
//        CheckingAccount ck = new CheckingAccount(2000);
//        System.out.println("余额：" + ck.getBalance());
//        ck.deposit(300);
//        System.out.println("余额：" + ck.getBalance());
//        ck.withdraw(299);
//        System.out.println("余额：" + ck.getBalance());
        SavingAccount sa = new SavingAccount(2000);
        System.out.println("余额：" + sa.getBalance());
        sa.deposit(300);
        System.out.println("余额：" + sa.getBalance());
        sa.deposit(300);
        System.out.println("余额：" + sa.getBalance());
        sa.withdraw(300);
        System.out.println("余额：" + sa.getBalance());
        sa.withdraw(300);
        System.out.println("余额：" + sa.getBalance());
        sa.earnMonthlyInterest();
        System.out.println("余额：" + sa.getBalance());
    }
}
