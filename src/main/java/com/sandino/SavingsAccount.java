package com.sandino;

import com.sandino.exceptions.NegativeBalanceException;

public class SavingsAccount extends Account {
    public SavingsAccount(int number, double initialBalance) {
        super(number);
        setBalance(initialBalance);

    }

    @Override
    public void decreaseBalance(double amount) throws NegativeBalanceException {
        if (this.balance - amount < 0) {
            throw new NegativeBalanceException("Savings account cannot have negative balance");
        }
        this.balance = this.balance - amount;
    }

    public void earnInterest(double percentage) {
        double earnings = (this.getBalance() * percentage) / 100.0;

        double newBalance = this.getBalance() + earnings;
        this.setBalance(newBalance);
    }
}
