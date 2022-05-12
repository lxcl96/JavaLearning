package chapter08_intermediate.HomeWork08;

public class SavingAccount extends BankAccount{
    private int freeTimes = 3;
    private double rate = Math.random();

    public SavingAccount(double initialBalance) {
        super(initialBalance);
    }

    public SavingAccount(double initialBalance, int freeTimes, double rate) {
        super(initialBalance);
        this.freeTimes = freeTimes;
        this.rate = rate;
    }

    public void earnMonthlyInterest() {
        super.setBalance(super.getBalance() * (1 + rate));
    }

    @Override
    public void deposit(double amount) {
        if (freeTimes > 0 ) {
            super.deposit(amount);
            freeTimes--;
        } else
            super.deposit(amount - 1);
    }

    @Override
    public void withdraw(double amount) {
        if (freeTimes > 0) {
            super.withdraw(amount);
            freeTimes--;
        } else {
            super.withdraw(amount);
            super.setBalance(super.getBalance() - 1);
        }
    }

    public int getFreeTimes() {
        return freeTimes;
    }

    public void setFreeTimes(int freeTimes) {
        this.freeTimes = freeTimes;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
