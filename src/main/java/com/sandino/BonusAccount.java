package com.sandino;

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
        int scoreEarned = (int) amount / 100;

        System.out.println("Score earned: " + scoreEarned);

        this.score = this.score + scoreEarned;

        System.out.println("Current score: " + this.score);

        super.increaseBalance(amount);
    }

}
