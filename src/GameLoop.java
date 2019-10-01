import java.util.ArrayList;
import java.util.Scanner;
public class GameLoop {

    private boolean gameover;
    private boolean turn;
    private Scanner scanner = new Scanner(System.in);
    private ScoringCombinations score = new ScoringCombinations();
    private Player playerOne = new Player();
    private Player playerTwo = new Player();
    public void start() {
        System.out.println("Welcome to Yahtzee, Player one it is your turn");
        do {
            if(!turn) {
                playerOne.bucket.rollDice();
                System.out.println("These are your dice.");
                System.out.println(playerOne.deck.toString());
                scoreOptionsList(playerOne);
                choices(playerOne,playerOne.deck);
                System.out.println("Your total score is:" + playerOne.score);
                if (playerTwo.scoreCard.isGameOver() && playerOne.scoreCard.isGameOver()) {
                    winner(playerOne,playerTwo);
                    System.out.println("Game over");
                    gameover = true;
                }
                playerOne.bucket.resetDiceHeld();
                turn ^= true;
            }
            else if(turn) {
                System.out.println("Player twos turn. These are your cards:");
                System.out.println(playerTwo.deck.toString());
                scoreOptionsList(playerTwo);
                choices(playerTwo,playerTwo.deck);
                System.out.println("Your total score is:" + playerTwo.score);
                if (playerTwo.scoreCard.isGameOver() && playerOne.scoreCard.isGameOver()) {
                    winner(playerOne,playerTwo);
                    gameover = true;
                }
                turn ^= true;
            }
        }while(!gameover);
    }

    private void scoreOptionsList(Player player) {
            for (ScoringCategory category:ScoringCategory.values()) {
                System.out.println(category.getValue() + " " + category.toString() + " " + player.scoreCard.isScoringCategoryUsed(category));

            }
    }

    private void choices(Player player, ArrayList<Dice> bucket) {
        int input = Integer.parseInt(scanner.nextLine());
        ScoringCategory choiceToScoringCategory = ScoringCategory.fromOrdinal(input);
        score.scoreCombinationCall(choiceToScoringCategory,player);
        player.bucket.resetDiceHeld();
        player.bucket.rollDice();
    }

    public GameResult winner(Player player1,Player player2) {
        GameResult result = GameResult.none;
        if(player1.score > player2.score) {
            System.out.println("Player one score:" + player1.score);
            System.out.println("Player two score:" + player2.score);
            System.out.println("Player One Wins");
            result = GameResult.playerOneWins;
        } else if (player1.score == player2.score) {
            System.out.println("Player one score:" + player1.score);
            System.out.println("Player two score:" + player2.score);
            System.out.println("IT'S A DRAW");
            result = GameResult.draw;
        } else {
            System.out.println("Player one score:" + player1.score);
            System.out.println("Player two score:" + player2.score);
            System.out.println("Player Two Wins");
            result = GameResult.playerTwoWins;
        }
        return result;
    }

    public ArrayList<Dice> changeHeld(ArrayList<Dice> bucket) {
        char[] choiceArr = scanner.nextLine().replace(",","").toCharArray(); //index numbers
            for (char item:choiceArr) {
                int charValue = Character.getNumericValue(item) - 1;
                Dice changeDice = bucket.get(charValue);
                changeDice.held = false;
            }
            //Changes dice that need to be rolled again statuses to held: false, returns the updated array.
            return bucket;
    }


}
