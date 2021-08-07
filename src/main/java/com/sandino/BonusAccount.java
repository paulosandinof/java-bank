package com.sandino;

import com.sandino.exceptions.NegativeBalanceLimitException;

public class BonusAccount extends Account {
    private int score;

    public BonusAccount(int number) {
        super(number);
        this.score = 10;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void increaseBalance(double amount) {
        int scoreEarned = (int) amount / 150;

        System.out.println("Score earned: " + scoreEarned);

        this.score = this.score + scoreEarned;

        System.out.println("Current score: " + this.score);

        super.increaseBalance(amount);
    }

    @Override
    public void transfer(Account sender, double amount) throws NegativeBalanceLimitException {
        int scoreEarned = (int) amount / 100;

        System.out.println("Score earned: " + scoreEarned);

        this.score = this.score + scoreEarned;

        System.out.println("Current score: " + this.score);
        
        sender.decreaseBalance(amount);
        super.increaseBalance(amount);
    }
}
