package com.sandino;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TransferTest {
    private Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void transferRegularAccountToRegularAccountTest() {
        bank.createRegularAccount(1);
        bank.createRegularAccount(2);

        bank.deposit(1, 300.00);
        bank.deposit(2, 300.00);

        bank.transfer(1, 2, 50.00);

        Account sender = bank.getAccounts().stream().filter(account -> account.getNumber() == 1).findFirst()
                .orElse(null);

        Account receiver = bank.getAccounts().stream().filter(account -> account.getNumber() == 2).findFirst()
                .orElse(null);

        assertEquals(250.00, sender.getBalance(), 0.001);
        assertEquals(350.00, receiver.getBalance(), 0.001);
    }

    @Test
    public void transferRegularAccountToBonusAccountTest() {
        bank.createRegularAccount(1);
        bank.createBonusAccount(2);

        bank.deposit(1, 300.00);
        bank.deposit(2, 300.00);

        bank.transfer(1, 2, 50.00);

        Account sender = bank.getAccounts().stream().filter(account -> account.getNumber() == 1).findFirst()
                .orElse(null);

        BonusAccount receiver = (BonusAccount) bank.getAccounts().stream().filter(account -> account.getNumber() == 2)
                .findFirst().orElse(null);

        assertEquals(250.00, sender.getBalance(), 0.001);
        assertEquals(350.00, receiver.getBalance(), 0.001);
        assertEquals(12, receiver.getScore());
    }

    @Test
    public void transferBonusAccountToRegularAccountTest() {
        bank.createBonusAccount(1);
        bank.createRegularAccount(2);

        bank.deposit(1, 300.00);
        bank.deposit(2, 300.00);

        bank.transfer(1, 2, 50.00);

        BonusAccount sender = (BonusAccount) bank.getAccounts().stream().filter(account -> account.getNumber() == 1)
                .findFirst().orElse(null);

        Account receiver = bank.getAccounts().stream().filter(account -> account.getNumber() == 2).findFirst()
                .orElse(null);

        assertEquals(250.00, sender.getBalance(), 0.001);
        assertEquals(350.00, receiver.getBalance(), 0.001);
        assertEquals(12, sender.getScore());
    }

    @Test
    public void transferBonusAccountToBonusAccountTest() {
        bank.createBonusAccount(1);
        bank.createBonusAccount(2);

        bank.deposit(1, 300.00);
        bank.deposit(2, 300.00);

        bank.transfer(1, 2, 50.00);

        BonusAccount sender = (BonusAccount) bank.getAccounts().stream().filter(account -> account.getNumber() == 1)
                .findFirst().orElse(null);

        BonusAccount receiver = (BonusAccount) bank.getAccounts().stream().filter(account -> account.getNumber() == 2)
                .findFirst().orElse(null);

        assertEquals(250.00, sender.getBalance(), 0.001);
        assertEquals(350.00, receiver.getBalance(), 0.001);
        assertEquals(12, receiver.getScore());
        assertEquals(12, sender.getScore());
    }
}
