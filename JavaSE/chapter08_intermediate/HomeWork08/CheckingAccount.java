package chapter08_intermediate.HomeWork08;

public class CheckingAccount extends BankAccount{
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    public void deposit(double amount) {
//        super.deposit(amount);
//        super.setBalance(super.getBalance() - 1);
        super.deposit(amount - 1);//更好 哈哈 好傻
    }

    public void withdraw(double amount) {
        super.withdraw(amount);
        super.setBalance(super.getBalance() - 1);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
