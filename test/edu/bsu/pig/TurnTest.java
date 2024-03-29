package edu.bsu.pig;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TurnTest {

    private Player player;

    @Before
    public void setUp() {
         this.player = new Player("Test Player");
    }

    @Test
    public void getScore_startsAtZero() {
        Turn turn = makeTurnWithFixedDieValue(3);
        Assert.assertEquals(0, turn.getScore());
    }

    private Turn makeTurnWithFixedDieValue(int value) {
        return new Turn(player, new FixedValueDie(value));
    }

    @Test
    public void testRoll_modifiesScoreByRollAmount() {
        Turn turn = makeTurnWithFixedDieValue(3);
        turn.roll();
        Assert.assertEquals(3, turn.getScore());
    }

    @Test
    public void testRoll_secondRollNonBust() {
        Turn turn = makeTurnWithFixedDieValue(4);
        turn.setScore(3);
        turn.roll();
        Assert.assertEquals(7, turn.getScore());
    }

    @Test
    public void testEnd_modifiesPlayerScore() {
        Turn turn = makeTurnWithFixedDieValue(4);
        turn.setScore(10);
        turn.end();
        Assert.assertEquals(10, turn.getPlayer().getScore());
    }

    @Test
    public void testRoll_rollOneWithSomeScore_turnScoreBecomesZero() {
        Turn turn = makeTurnWithFixedDieValue(1);
        turn.setScore(10);
        turn.roll();
        Assert.assertEquals(0, turn.getScore());
    }

    @Test
    public void testIsOver_initiallyFalse() {
        Turn turn = makeTurnWithFixedDieValue(1);
        Assert.assertFalse(turn.isOver());
    }

    @Test
    public void testIsOver_rollOne_true() {
        Turn turn = makeTurnWithFixedDieValue(1);
        turn.roll();
        Assert.assertTrue(turn.isOver());
    }

    @Test
    public void testIsOver_rollTwo_true() {
        Turn turn = makeTurnWithFixedDieValue(2);
        turn.roll();
        Assert.assertFalse(turn.isOver());
    }

    @Test
    public void testIsOver_endTurn_true() {
        Turn turn = makeTurnWithFixedDieValue(2);
        turn.end();
        Assert.assertTrue(turn.isOver());
    }
}
