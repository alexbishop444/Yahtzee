import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    boolean roll1 = false;
    boolean roll2 = false;
    boolean roll3 = false;
    int score = 0;

    ArrayList<Dice> deck;

    ScoreCard scoreCard = new ScoreCard();

    public void setDeck(ArrayList<Dice> deck) {
        this.deck = deck;
    }

    public ArrayList<Dice> getDeck() {
        return deck;
    }

    public Player(ArrayList<Dice> deck) {
        this.deck = deck;
    }

    public void reset() {
        this.roll1 = true;
        this.roll2 = true;
        this.roll3 = true;
    }

    public boolean isScoringCategoryUsed(ScoringCategory category) {
        return scoreCard.isScoringCategoryUsed(category);
    }


}
