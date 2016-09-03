import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Joker on 8/25/2016.
 *
 * The rules given were the following:
 *
 * - A game is won by the first player to have won at least four points in total and at least two points
 *   more than the opponent.
 * - The running score of each game is described in a manner peculiar to tennis: scores from zero to three points
 *   are described as “love”, “fifteen”, “thirty”, and “forty” respectively.
 * - If at least three points have been scored by each player, and the scores are equal, the score is “deuce”.
 * - If at least three points have been scored by each side and a player has one more point than his opponent,
 *   the score of the game is “advantage” for the player in the lead.
 *
 */
public class TennisScoreAnnouncerUnitTest {

    @Test(expected = NullPointerException.class)
    public void beforeAnnounceShouldSetCounter(){
        TennisScoreAnnouncer tennisScoreAnnouncer = new TennisScoreAnnouncer();
        tennisScoreAnnouncer.announce();
    }

    @Test
    public void beforeGameStartScoreShouldBe0(){
        TennisScoreAnnouncer tennisScoreAnnouncer = new TennisScoreAnnouncer();
        TennisCounter tennisCounter = new TennisCounter();
        tennisCounter.setScoreA(0);
        tennisCounter.setScoreB(0);
        tennisScoreAnnouncer.setScoreCounter(tennisCounter);
        assertEquals("LOVE-LOVE", tennisScoreAnnouncer.announce());
    }

    @Test
    public void aGameWonByLeftHaveLeastFourPointsInTotalAndLeastTwoPointMoreThenTheOpponent(){
        TennisScoreAnnouncer tennisScoreAnnouncer = new TennisScoreAnnouncer();
        TennisCounter tennisCounter = new TennisCounter();
        tennisCounter.setScoreA(4);
        tennisCounter.setScoreB(0);
        tennisScoreAnnouncer.setScoreCounter(tennisCounter);
        assertEquals("A-WON", tennisScoreAnnouncer.announce());
    }

    @Test
    public void aGameWonByRightHaveLeastFourPointsInTotalAndLeastTwoPointMoreThenTheOpponent(){
        TennisScoreAnnouncer tennisScoreAnnouncer = new TennisScoreAnnouncer();
        TennisCounter tennisCounter = new TennisCounter();
        tennisCounter.setScoreA(0);
        tennisCounter.setScoreB(4);
        tennisScoreAnnouncer.setScoreCounter(tennisCounter);
        assertEquals("B-WON", tennisScoreAnnouncer.announce());
    }

    @Test
    public void runningScoreEachGameIsDescribed(){
        TennisScoreAnnouncer tennisScoreAnnouncer = new TennisScoreAnnouncer();
        TennisCounter tennisCounter = new TennisCounter();
        assertEquals("LOVE", tennisScoreAnnouncer.describedScore(tennisCounter.getScoreA()));
        tennisCounter.hitScoreA();
        assertEquals("FIFTEEN", tennisScoreAnnouncer.describedScore(tennisCounter.getScoreA()));
        tennisCounter.hitScoreA();
        assertEquals("THIRTY", tennisScoreAnnouncer.describedScore(tennisCounter.getScoreA()));
        tennisCounter.hitScoreA();
        assertEquals("FORTY", tennisScoreAnnouncer.describedScore(tennisCounter.getScoreA()));
    }
}

