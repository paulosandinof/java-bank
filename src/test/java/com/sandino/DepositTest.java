package com.sandino;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DepositTest {
    private Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void depositRegularAccountTest() {
        bank.createRegularAccount(1);

        bank.deposit(1, 100.00);

        Account existingAccount = bank.getAccounts().stream().filter(account -> account.getNumber() == 1).findFirst()
                .orElse(null);
    
        assertEquals(100.00, existingAccount.getBalance(), 0.001);
    }

    @Test
    public void depositBonusAccountTest() {
        bank.createBonusAccount(1);

        bank.deposit(1, 150.00);

        BonusAccount existingAccount = (BonusAccount) bank.getAccounts().stream().filter(account -> account.getNumber() == 1).findFirst()
                .orElse(null);

        assertEquals(150.00, existingAccount.getBalance(), 0.001);
        assertEquals(11, existingAccount.getScore());
    }

    @Test
    public void depositSavingsAccountTest() {
        bank.createSavingsAccount(1, 150.00);

        bank.deposit(1, 150.00);

        SavingsAccount existingAccount = (SavingsAccount) bank.getAccounts().stream().filter(account -> account.getNumber() == 1).findFirst()
                .orElse(null);

        assertEquals(300.00, existingAccount.getBalance(), 0.001);
    }
}
