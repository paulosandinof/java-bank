package com.sandino;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class WithdrawTest {
    private Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void withdrawRegularAccountTest() {
        bank.createRegularAccount(1);

        bank.deposit(1, 200.00);

        bank.withdraw(1, 100.00);

        Account existingAccount = bank.getAccounts().stream().filter(account -> account.getNumber() == 1).findFirst()
                .orElse(null);

        assertEquals(100.00, existingAccount.getBalance(), 0.001);
    }

    @Test
    public void withdrawBonusAccountTest() {
        bank.createBonusAccount(1);

        bank.deposit(1, 300.00);

        bank.withdraw(1, 150.00);

        BonusAccount existingAccount = (BonusAccount) bank.getAccounts().stream()
                .filter(account -> account.getNumber() == 1).findFirst().orElse(null);

        assertEquals(150.00, existingAccount.getBalance(), 0.001);
        assertEquals(12, existingAccount.getScore());
    }

    @Test
    public void withdrawSavingsAccountTest() {
        bank.createSavingsAccount(1, 150.00);

        bank.deposit(1, 150.00);

        bank.withdraw(1, 150.00);

        SavingsAccount existingAccount = (SavingsAccount) bank.getAccounts().stream()
                .filter(account -> account.getNumber() == 1).findFirst().orElse(null);

        assertEquals(150.00, existingAccount.getBalance(), 0.001);
    }
}
