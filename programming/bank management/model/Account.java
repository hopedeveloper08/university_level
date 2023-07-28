package model;

public class Account {
    String name;
    double balance;

    public Account(String name, double balance) {
        setName(name);
        setBalance(balance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        if (amount >= 20000)
            this.balance = amount;
        else
            this.balance = 20000;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount < balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "\nAccount Type : " + "Simple Account" + "\nAccount Name : " + this.name + "\nBalance : " + this.balance;
    }
}
