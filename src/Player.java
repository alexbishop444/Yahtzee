import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    int score = 0;

    Bucket bucket;

    ScoreCard scoreCard = new ScoreCard();

    public Bucket getDeck() {
        return bucket;
    }

    public Player() {
        this.bucket = new Bucket();
    }

    public boolean isScoringCategoryUsed(ScoringCategory category) {
        return scoreCard.isScoringCategoryUsed(category);
    }


}
