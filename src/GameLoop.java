import java.util.ArrayList;
import java.util.Scanner;
public class GameLoop {
    //all above are game categories

    boolean gameover;


    Scanner scanner = new Scanner(System.in);
    ScoringCombinations score = new ScoringCombinations();
    Player playerOne = new Player(newRoll(),false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
    Player playerTwo = new Player(newRoll(),false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
    public void start() {
        System.out.println("Welcome to Yahtzee, Player one it is your turn");
        do {
            playerOne.setDeck(newRoll());
            System.out.println("These are your cards.");
            System.out.println(playerOne.deck.toString());
            options();
            String choice = scanner.nextLine();
            if(choice.equals("1") && !playerOne.chance) {
                score.chance(convertArray(playerOne.deck));
                System.out.println(score.chance(convertArray(playerOne.deck)));
                playerOne.chance = true;
            } else if (choice.equals("2") && !playerOne.ones) {
                score.addUpSameNumbers((convertArray(playerOne.deck)),1);
                System.out.println(score.addUpSameNumbers((convertArray(playerOne.deck)),1));
                playerOne.ones = true;
            } else {
                System.out.println("You have already used this option");
            }

        }while(!gameover);
    }

    private void options() {
        System.out.println("1. Chance used: " + playerOne.chance);
        System.out.println("2. Add up all Ones used:  " + playerOne.ones);
    }

//    private boolean isGameover() {
//        if((playerOneChance) && (playerTwoChance) && (playerOneYahtzee) && (playerTwoYahtzee) && (playerOneOnes) && (playerOneTwos) &&
//                (playerOneThrees) && (playerOneFours) && (playerOneFives) && (playerOneSixes) && (playerTwoOnes) && (playerTwoTwos) &&
//                (playerTwoThrees) && (playerTwoFours) && (playerTwoFives) && (playerTwoSixes) && (playerOnePair) && (playerOneTwoPairs) &&
//                (playerOneThreeOfAKind) && (playerOneFourOfAKind) && (playerOneSmallStraight) && (playerOneLargeStraight) && (playerOneFullHouse) &&
//                (playerTwoPair) && (playerTwoTwoPairs) && (playerTwoThreeOfAKind) && (playerTwoFourOfAKind) && (playerTwoSmallStraight) &&
//                (playerTwoLargeStraight) && (playerTwoFullHouse)
//        ){
//            gameover = true;
//            return true;
//        }
//        return false;
//    }

    public ArrayList<Dice> newRoll() {
        ArrayList<Dice> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add(roll());
        }
        return arr;
    }


    public Dice[] convertArray(ArrayList<Dice> arr) {
        Dice[] arr2 = arr.toArray(new Dice[arr.size()]);
        return arr2;
    }

    public Dice roll() {
            double randomDouble = Math.random();
            randomDouble = randomDouble * 6 + 1;
            int randomInt = (int) randomDouble;
            return new Dice(false,randomInt);
    }


}
