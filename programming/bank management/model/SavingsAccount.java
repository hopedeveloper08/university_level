package model;

public class SavingsAccount extends Account {
    double intRate;

    public SavingsAccount(String name, double balance, double intRate) {
        super(name, balance);
        this.intRate = intRate;
    }

    public double getIntRate() {
        return intRate;
    }

    public void setIntRate(double intRate) {
        this.intRate = intRate;
    }

    public boolean deposit(double amount) {
        amount += amount * (intRate / 100);
        return super.deposit(amount);
    }

    @Override
    public String toString() {
        return "\nAccount Type : " + "Saving Account" + "\nAccount Name : " + this.name + "\nBalance : " + this.balance + "\nRate : " + this.intRate;
    }
}
