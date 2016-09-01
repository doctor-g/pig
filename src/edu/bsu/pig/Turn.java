package edu.bsu.pig;

public final class Turn {

    private FixedValueDie die;
    private int score = 0;

    public Turn(FixedValueDie die) {
        this.die = die;
    }

    public int getScore() {
        return score;
    }

    public void roll() {
        score += die.getValue();
    }

    void setScore(int score) {
        this.score = score;
    }
}
