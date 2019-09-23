import java.util.HashMap;
import java.util.Map;

public class ScoreCard {

    HashMap<String, Boolean> scoreCard = new HashMap<String, Boolean>();

    public ScoreCard() {
        scoreCard.put("chance",false);
        scoreCard.put("yahtzee",false);
        scoreCard.put("ones",false);
        scoreCard.put("twos",false);
        scoreCard.put("threes",false);
        scoreCard.put("fours",false);
        scoreCard.put("fives",false);
        scoreCard.put("sixes",false);
        scoreCard.put("pair",false);
        scoreCard.put("twoPairs",false);
        scoreCard.put("threeOfAKind",false);
        scoreCard.put("fourOfAKind",false);
        scoreCard.put("smallStraight",false);
        scoreCard.put("largeStraight",false);
        scoreCard.put("fullHouse",false);

    }

    public boolean check() {
        for(Map.Entry<String, Boolean> entry : scoreCard.entrySet()) {
            Boolean value = entry.getValue();
            if(!value) {
                return false;
            }
        }
        return true;
    }

}
