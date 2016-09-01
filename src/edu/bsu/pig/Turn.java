package edu.bsu.pig;

public final class Turn {

    private Die die;
    private int score = 0;

    public Turn(Die die) {
        this.die = die;
    }

    public int getScore() {
        return score;
    }

    public void roll() {
        score += die.roll();
    }

    void setScore(int score) {
        this.score = score;
    }
}
