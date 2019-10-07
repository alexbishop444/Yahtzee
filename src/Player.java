import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    int score = 0;

    Bucket bucket;

    @Override
    public String toString() {
        return "Player{" +
                "score=" + score +
                ", bucket=" + bucket +
                ", name='" + name + '\'' +
                ", scoreCard=" + scoreCard +
                '}';
    }

    public int getScore() {
        return score;
    }

    String name;

    ScoreCard scoreCard = new ScoreCard();

    public Bucket getDeck() {
        return bucket;
    }


    public Player(String name) {
        this.bucket = new Bucket();
        this.name = name;
    }

    public Player[] convertArrayToPrimitive(ArrayList<Player> arr) {
        Player[] arr2 = arr.toArray(new Player[arr.size()]);
        return arr2;
    }

    public boolean isScoringCategoryUsed(ScoringCategory category) {
        return scoreCard.isScoringCategoryUsed(category);
    }


}
