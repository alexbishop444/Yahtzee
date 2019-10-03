import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class GameLoop {

    private boolean gameover;
    private boolean turn;
    private Scanner scanner = new Scanner(System.in);
    private ScoringCombinations score = new ScoringCombinations();
    private Player playerOne = new Player();
    private Player playerTwo = new Player();
    public void runGame() {
        System.out.println("Welcome to Yahtzee, Player one it is your turn");
        do {
            if(!turn) {
                playerTurnCycle(playerOne);
            }
            else if(turn) {
                System.out.println("Player two it is your turn");
                playerTurnCycle(playerTwo);
            }
        }while(!gameover);
    }

    private void playerTurnCycle(Player player) {
        player.bucket.rollDice();
        System.out.println("These are your dice.");
        System.out.println(Arrays.toString(player.bucket.getDice()));
        printOutScoreCategories(player);
        choices(player);
        System.out.println("Your total score is:" + player.score);
        if (playerTwo.scoreCard.isGameOver() && playerOne.scoreCard.isGameOver()) {
            winner(playerOne,playerTwo);
            System.out.println("Game over");
            gameover = true;
        }
        player.bucket.resetDiceHeld();
        turn ^= true;
    }

    private void printOutScoreCategories(Player player) {
            for (ScoringCategory category:ScoringCategory.values()) {
                System.out.println(category.getValue() + " " + category.toString() + " " + player.scoreCard.isScoringCategoryUsed(category));

            }
    }

    private void choices(Player player) {
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
