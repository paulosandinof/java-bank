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
}
