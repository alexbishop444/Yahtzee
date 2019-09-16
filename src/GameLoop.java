import java.util.ArrayList;

public class GameLoop {
    boolean playerOneChance = false;
    boolean playerTwoChance = false;
    boolean playerOneYahtzee = false;
    boolean playerTwoYahtzee = false;


    boolean playerOneOnes = false;
    boolean playerOneTwos = false;
    boolean playerOneThrees = false;
    boolean playerOneFours = false;
    boolean playerOneFives = false;
    boolean playerOneSixes = false;

    boolean playerTwoOnes = false;
    boolean playerTwoTwos = false;
    boolean playerTwoThrees = false;
    boolean playerTwoFours = false;
    boolean playerTwoFives = false;
    boolean playerTwoSixes = false;

    boolean playerOnePair = false;
    boolean playerOneTwoPairs = false;
    boolean playerOneThreeOfAKind = false;
    boolean playerOneFourOfAKind = false;
    boolean playerOneSmallStraight = false;
    boolean playerOneLargeStraight = false;
    boolean playerOneFullHouse = false;

    boolean playerTwoPair = false;
    boolean playerTwoTwoPairs = false;
    boolean playerTwoThreeOfAKind = false;
    boolean playerTwoFourOfAKind = false;
    boolean playerTwoSmallStraight = false;
    boolean playerTwoLargeStraight = false;
    boolean playerTwoFullHouse = false;
    //all above are game categories

    boolean gameover;

    public void start() {
        System.out.println("Welcome to Yahtzee, Player one it is your turn");
        do {


        }while(!gameover);
    }

    private boolean isGameover() {
        if((playerOneChance) && (playerTwoChance) && (playerOneYahtzee) && (playerTwoYahtzee) && (playerOneOnes) && (playerOneTwos) &&
                (playerOneThrees) && (playerOneFours) && (playerOneFives) && (playerOneSixes) && (playerTwoOnes) && (playerTwoTwos) &&
                (playerTwoThrees) && (playerTwoFours) && (playerTwoFives) && (playerTwoSixes) && (playerOnePair) && (playerOneTwoPairs) &&
                (playerOneThreeOfAKind) && (playerOneFourOfAKind) && (playerOneSmallStraight) && (playerOneLargeStraight) && (playerOneFullHouse) &&
                (playerTwoPair) && (playerTwoTwoPairs) && (playerTwoThreeOfAKind) && (playerTwoFourOfAKind) && (playerTwoSmallStraight) &&
                (playerTwoLargeStraight) && (playerTwoFullHouse)
        ){
            gameover = true;
            return true;
        }
        return false;
    }

    public Dice[] newRoll() {
        Dice[] arr = new Dice[5];
        arr[0] = roll();
        arr[1] = roll();
        arr[2] = roll();
        arr[3] = roll();
        arr[4] = roll();
        return arr;
    }

    public Dice roll() {
            double randomDouble = Math.random();
            randomDouble = randomDouble * 6 + 1;
            int randomInt = (int) randomDouble;
            return new Dice(false,randomInt);
    }


}
