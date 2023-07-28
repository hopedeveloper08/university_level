package model;

public class TrustAccount extends SavingsAccount {
    static int maxWithdrawals = 3;
    static double bonusThreshold = 5000.0;
    static double bonusAmount = 50.0;
    int withdrawals;

    public TrustAccount(String name, double balance, double intRate) {
        super(name, balance, intRate);
        withdrawals = 0;
    }

    public boolean deposit(double amount) {
        if (amount >= bonusThreshold) {
            amount += bonusAmount;
        }
        return super.deposit(amount);
    }

    public boolean withdraw(double amount) {
        if (withdrawals < maxWithdrawals && super.withdraw(amount)) {
            withdrawals += 1;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "\nAccount Type : " + "Trust Account" + "\nAccount Name : " + this.name + "\nBalance : " + this.balance + "\nRate : " + this.intRate;
    }
}
