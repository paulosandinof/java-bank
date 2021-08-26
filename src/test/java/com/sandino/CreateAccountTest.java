package com.sandino;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class CreateAccountTest {
    private Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void createRegularAccountTest() {
        bank.createRegularAccount(1);

        Account existingAccount = bank.getAccounts().stream().filter(account -> account.getNumber() == 1).findFirst()
                .orElse(null);

        assertNotNull(existingAccount);
        assertEquals(1, existingAccount.getNumber());
        assertEquals(0.00, existingAccount.getBalance(), 0.001);
    }

    @Test
    public void createBonusAccountTest() {
        bank.createBonusAccount(1);

        BonusAccount existingAccount = (BonusAccount) bank.getAccounts().stream()
                .filter(account -> account.getNumber() == 1).findFirst().orElse(null);

        assertNotNull(existingAccount);
        assertEquals(1, existingAccount.getNumber());
        assertEquals(0.00, existingAccount.getBalance(), 0.001);
        assertEquals(10, existingAccount.getScore());
    }

    @Test
    public void createSavingsAccountTest() {
        bank.createSavingsAccount(1, 100.00);

        SavingsAccount existingAccount = (SavingsAccount) bank.getAccounts().stream()
        .filter(account -> account.getNumber() == 1).findFirst().orElse(null);

        assertNotNull(existingAccount);
        assertEquals(1, existingAccount.getNumber());
        assertEquals(100.00, existingAccount.getBalance(), 0.001);
    }
}
