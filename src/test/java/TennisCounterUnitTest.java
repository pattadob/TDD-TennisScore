import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisCounterUnitTest {

    @Test
    public void whenStartBothScoreShouldBeBoth0(){
        TennisCounter tennisCounter = new TennisCounter();
        assertEquals(0, tennisCounter.getScoreA());
        assertEquals(0, tennisCounter.getScoreB());
    }

    @Test
    public void whenHitScoreTheScoreShouldBeIncressByLastScorePlus1(){
        TennisCounter tennisCounter = new MyTennisCounter();
        tennisCounter.hitScoreA();
        assertEquals(1, tennisCounter.getScoreA());
    }

    @Test
    public void whenResetScoreTheScoreShouldBeBoth0(){
        TennisCounter tennisCounter = new MyTennisCounter();
        tennisCounter.hitScoreA();
        tennisCounter.hitScoreB();
        tennisCounter.resetScore();
        assertEquals(0, tennisCounter.getScoreA());
        assertEquals(0, tennisCounter.getScoreB());
    }

    public class MyTennisCounter extends TennisCounter{
        @Override
        public void setScoreA(int scoreA) {
            super.setScoreA(scoreA);
        }

        @Override
        public void setScoreB(int scoreB) {
            super.setScoreB(scoreB);
        }
    }
}
