import java.util.HashMap;
import java.util.Map;

public class ScoreCard {

    private HashMap<ScoringCategory, Boolean> scoreCard = new HashMap<ScoringCategory, Boolean>();



    public ScoreCard() {
        scoreCard.put(ScoringCategory.CHANCE,false);
        scoreCard.put(ScoringCategory.ONES,false);
        scoreCard.put(ScoringCategory.TWOS,false);
        scoreCard.put(ScoringCategory.THREES,false);
        scoreCard.put(ScoringCategory.FOURS,false);
        scoreCard.put(ScoringCategory.FIVES,false);
        scoreCard.put(ScoringCategory.SIXES,false);
        scoreCard.put(ScoringCategory.PAIR,false);
        scoreCard.put(ScoringCategory.TWOPAIRS,false);
        scoreCard.put(ScoringCategory.THREEOFAKIND,false);
        scoreCard.put(ScoringCategory.FOUROFAKIND,false);
        scoreCard.put(ScoringCategory.SMALLSTRAIGHT,false);
        scoreCard.put(ScoringCategory.LARGESTRAIGHT,false);
        scoreCard.put(ScoringCategory.FULLHOUSE,false);
        scoreCard.put(ScoringCategory.YAHTZEE,false);

    }

    public HashMap<ScoringCategory, Boolean> getScoreCard() {
        return scoreCard;
    }

    public boolean isScoringCategoryUsed(ScoringCategory category) {
        return scoreCard.get(category);
    }

    public boolean setScoringCategoryToTrue(ScoringCategory category) {
        return scoreCard.put(category,true);
    }

    public boolean isGameOver() {
        for(Map.Entry<ScoringCategory, Boolean> entry : scoreCard.entrySet()) {
            Boolean value = entry.getValue();
            if(!value) {
                return false;
            }
        }
        return true;
    }

}
