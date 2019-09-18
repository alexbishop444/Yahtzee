import java.util.ArrayList;

public class Player {
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

    public Player(ArrayList<Dice> deck, int score, boolean chance, boolean yahtzee, boolean ones, boolean twos, boolean threes, boolean fours, boolean fives, boolean sixes, boolean pair, boolean twoPairs, boolean threeOfAKind, boolean fourOfAKind, boolean smallStraight, boolean largeStraight, boolean fullHouse) {
        this.chance = chance;
        this.yahtzee = yahtzee;
        this.ones = ones;
        this.twos = twos;
        this.threes = threes;
        this.fours = fours;
        this.fives = fives;
        this.sixes = sixes;
        this.pair = pair;
        this.twoPairs = twoPairs;
        this.threeOfAKind = threeOfAKind;
        this.fourOfAKind = fourOfAKind;
        this.smallStraight = smallStraight;
        this.largeStraight = largeStraight;
        this.fullHouse = fullHouse;
        this.deck = deck;
        this.score = score;
    }

    public boolean check() {
        if(chance && yahtzee && ones && twos && threes && fours && fives && sixes && pair && twoPairs && threeOfAKind && fourOfAKind && smallStraight && largeStraight && fullHouse ) {
            return true;
        }
        return false;
    }

    public boolean checkTest() {
        if (chance) {
            return true;
        }
        return false;
    }
}
