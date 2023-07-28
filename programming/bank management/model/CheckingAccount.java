package model;

public class CheckingAccount extends Account {
    double perCheckFee;

    public CheckingAccount(String name, double balance, double perCheckFee) {
        super(name, balance);
        this.perCheckFee = perCheckFee;
    }

    public double getPerCheckFee() {
        return perCheckFee;
    }

    public void setPerCheckFee(double perCheckFee) {
        this.perCheckFee = perCheckFee;
    }

    public boolean withdraw(double amount) {
        amount += perCheckFee;
        return super.withdraw(amount);
    }

    @Override
    public String toString() {
        return "\nAccount Type : " + "Checking Account"+ "\nAccount Name : " +this.name+ "\nBalance : " + this.balance +"\nPer Check Fee : " + this.perCheckFee;
    }
}
