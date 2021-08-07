package com.sandino;

import com.sandino.exceptions.NegativeBalanceLimitException;

public class SavingsAccount extends Account {
    public SavingsAccount(int number) {
        super(number);
    }

    @Override
    public void decreaseBalance(double amount) throws NegativeBalanceLimitException {
        this.balance = this.balance - amount;
    }

    public void earnInterest(double percentage) {
        double earnings = (this.getBalance() * percentage) / 100.0;

        double newBalance = this.getBalance() + earnings;
        this.setBalance(newBalance);
    }
}
