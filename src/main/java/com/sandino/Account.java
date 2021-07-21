package com.sandino;

public class Account {

    private int number;
    private double balance;

    public Account(int number) {
        this.number = number;
        this.balance = 0;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void increaseBalance(double amount) {
        this.balance = this.balance + amount;
    }

    public void decreaseBalance(double amount) {
        this.balance = this.balance - amount;
    }
}
