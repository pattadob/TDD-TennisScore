public class TennisCounter {
    private int scoreA = 0;
    private int scoreB = 0;

    public int getScoreB() {
        return scoreB;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }

    public int getScoreA() {
        return scoreA;
    }

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }

    public void hitScoreA() {
        this.scoreA++;
    }

    public void hitScoreB() {
        this.scoreB++;
    }

    public void resetScore() {
        this.scoreA = 0;
        this.scoreB = 0;
    }

    public int scoreDifferenc() {
        return this.getScoreA() - this.getScoreB();
    }
}
