package com.sandino;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EarnInterestTest {
    private Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void earnInterestTest() {
        bank.createSavingsAccount(1, 300.00);

        SavingsAccount existingAccount = (SavingsAccount) bank.getAccounts().stream().filter(account -> account.getNumber() == 1).findFirst()
                .orElse(null);

        existingAccount.earnInterest(5);

        assertEquals(315.00, existingAccount.getBalance(), 0.001);
    }
}
