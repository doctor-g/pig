package edu.bsu.pig;

import org.junit.Assert;
import org.junit.Test;

public class TurnTest {

    @Test
    public void getScore_startsAtZero() {
        Turn turn = new Turn();
        Assert.assertEquals(0, turn.getScore());
    }
}
