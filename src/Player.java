import java.util.ArrayList;

public class Player {
    boolean roll1 = false;
    boolean roll2 = false;
    boolean roll3 = false;
    boolean chance = false;
    boolean yahtzee = false;


    boolean ones = false;
    boolean twos = false;
    boolean threes = false;
    boolean fours = false;
    boolean fives = false;
    boolean sixes = false;

    boolean pair = false;
    boolean twoPairs = false;
    boolean threeOfAKind = false;
    boolean fourOfAKind = false;
    boolean smallStraight = false;
    boolean largeStraight = false;
    boolean fullHouse = false;

    int score = 0;

    ArrayList<Dice> deck;

    public void setDeck(ArrayList<Dice> deck) {
        this.deck = deck;
    }

    public ArrayList<Dice> getDeck() {
        return deck;
    }

    public Player(ArrayList<Dice> deck) {
        this.deck = deck;
    }

    public boolean check() {
        if(chance && yahtzee && ones && twos && threes && fours && fives && sixes && pair && twoPairs && threeOfAKind && fourOfAKind && smallStraight && largeStraight && fullHouse ) {
            return true;
        }
        return false;
    }

    public void reset() {
        this.roll1 = true;
        this.roll2 = true;
        this.roll3 = true;
    }

    public boolean checkTest() {
        if (chance) {
            return true;
        }
        return false;
    }
}
