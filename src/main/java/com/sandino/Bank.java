package com.sandino;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static final String ERROR_MESSAGE = "This account doesn't exists";

    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void createAccount(int number) {

        boolean exists = accounts.stream().anyMatch(account -> account.getNumber() == number);

        if (exists) {
            System.out.println("An account with this number already exists");
            return;
        }

        Account account = new Account(number);
        accounts.add(account);
        System.out.println("Account created");
    }

    public void checkBalance(int number) {
        Account existingAccount = accounts.stream().filter(account -> account.getNumber() == number).findFirst()
                .orElse(null);

        if (existingAccount == null) {
            System.out.println(ERROR_MESSAGE);
            return;
        }

        System.out.println("The balance of account " + number + " is: " + existingAccount.getBalance());
    }

    public void deposit(int number, double amount) {
        Account existingAccount = accounts.stream().filter(account -> account.getNumber() == number).findFirst()
                .orElse(null);

        if (existingAccount == null) {
            System.out.println(ERROR_MESSAGE);
            return;
        }

        existingAccount.increaseBalance(amount);

        System.out.println("The amount of " + amount + " was deposited to the account " + existingAccount.getNumber());
    }

    public void withdraw(int number, double amount) {
        Account existingAccount = accounts.stream().filter(account -> account.getNumber() == number).findFirst()
                .orElse(null);

        if (existingAccount == null) {
            System.out.println(ERROR_MESSAGE);
            return;
        }

        existingAccount.decreaseBalance(amount);

        System.out.println(
                "The amount of " + amount + " was withdrawned from the account " + existingAccount.getNumber());
    }

    public void transfer(int sender, int receiver, double amount) {
        Account existingSender = accounts.stream().filter(account -> account.getNumber() == sender).findFirst()
                .orElse(null);

        if (existingSender == null) {
            System.out.println("Sender account doesn't exists");
            return;
        }

        Account existingReceiver = accounts.stream().filter(account -> account.getNumber() == receiver).findFirst()
                .orElse(null);

        if (existingReceiver == null) {
            System.out.println("Receiver account doesn't exists");
            return;
        }

        // existingSender.decreaseBalance(amount);
        // existingReceiver.increaseBalance(amount);

        existingReceiver.transfer(existingSender, amount);

        System.out.println("The amount of " + amount + " was transfered from account " + existingSender.getNumber()
                + " to account " + existingReceiver.getNumber());
    }
}
