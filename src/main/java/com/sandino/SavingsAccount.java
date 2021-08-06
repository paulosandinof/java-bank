package com.sandino;

public class SavingsAccount extends Account {
    public SavingsAccount(int number) {
        super(number);
    }

    public void earnInterest(double percentage) {
        double earnings = (this.getBalance() * percentage) / 100.0;

        double newBalance = this.getBalance() + earnings;
        this.setBalance(newBalance);
    }
}
