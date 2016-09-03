public class TennisScoreAnnouncer {

    private TennisCounter scoreCounter;

    public String announce() throws NullPointerException {

        String announce = "";
        if (scoreCounter.getScoreA() == 0 && scoreCounter.getScoreB() == 0){
            announce = "LOVE-LOVE";
        }else if (scoreCounter.scoreDifferenc() == 0){
            if (scoreCounter.getScoreA() < 3){
                announce = describedScore(scoreCounter.getScoreA()) + "-" + describedScore(scoreCounter.getScoreB());
            }else{
                announce = "DEUCE";
            }
        }else if(scoreCounter.getScoreA() >= 4 &&
                scoreCounter.getScoreA() - scoreCounter.getScoreB() >= 2){
            announce = "A-WON";
        }else if(scoreCounter.getScoreB() >= 4 &&
                scoreCounter.getScoreA() - scoreCounter.getScoreB() <= -2){
            announce = "B-WON";
        }

        return announce;
    }

    public void setScoreCounter(TennisCounter scoreCounter) {
        this.scoreCounter = scoreCounter;
    }

    public String describedScore(int score) {
        String [] scoreDescription = {"LOVE", "FIFTEEN", "THIRTY", "FORTY"};
        return scoreDescription[score];
    }

}
