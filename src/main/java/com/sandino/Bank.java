package com.sandino;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<Account>();
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
            System.out.println("This account doesn't exists");
            return;
        }

        System.out.println("The balance of account " + number + " is: " + existingAccount.getBalance());
    }

    public void deposit(int number, double amount){
        Account existingAccount = accounts.stream().filter(account -> account.getNumber() == number).findFirst()
                .orElse(null);

        if (existingAccount == null) {
            System.out.println("This account doesn't exists");
            return;
        }

        existingAccount.setBalance(amount);

        System.out.println("The amount of " + amount + " was deposited to the account " + existingAccount.getNumber());
    }
}
