import java.util.Arrays;
import java.util.Scanner;
public class GameLoop {

    private boolean gameOver;
    private boolean turn;
    private GameResult gameState;
    private Scanner scanner = new Scanner(System.in);
    private ScoringCombinations score;
    private Player playerOne = new Player();
    private Player playerTwo = new Player();

    public GameLoop(IScoringCombinations scoringCombinations, Player[] players, int numberOfRerolls)
    {
    }

    public void runGame() {
        gameState = GameResult.playing;
        System.out.println("Welcome to Yahtzee, Player one it is your turn");
        do {
            if(!turn) {
                System.out.println("Player one it is your turn");
                playerTurn(playerOne);
            }
            else {
                System.out.println("Player two it is your turn");
                playerTurn(playerTwo);
            }
        }while(!gameOver);
    }

    private void playerTurn(Player player) {
        // for loop here
        player.bucket.rollDice();
        System.out.println("These are your dice.");
        System.out.println(Arrays.toString(player.bucket.getDice()));
        printOutScoreCategories(player);
        changeHeld(player);
        // end for loop
        getPlayerCategorySelectionAndCalculate(player);
        System.out.println("Your total score is:" + player.score);
        if (playerTwo.scoreCard.isGameOver() && playerOne.scoreCard.isGameOver()) {
            returnGameResult(playerOne,playerTwo);
            System.out.println("Game over");
            gameOver = true;
        }
        player.bucket.resetDiceHeld();
        turn ^= true;
    }

    private void printOutScoreCategories(Player player) {
            for (ScoringCategory category:ScoringCategory.values()) {
                System.out.println(category.getValue() + " " + category.toString() + " " + player.scoreCard.isScoringCategoryUsed(category));

            }
    }

    private void getPlayerCategorySelectionAndCalculate(Player player) {
        int input = Integer.parseInt(scanner.nextLine());
        ScoringCategory choiceToScoringCategory = ScoringCategory.fromOrdinal(input);
        score.scoreCombinationCall(choiceToScoringCategory,player);
        player.bucket.resetDiceHeld();
        player.bucket.rollDice();
    }

    public GameResult GetGameState()
    {
        return gameState;
    }

    public GameResult returnGameResult() {
        GameResult result = GameResult.none;
        if(playerOne.score > playerTwo.score) {
            System.out.println("Player one score:" + playerOne.score);
            System.out.println("Player two score:" + playerTwo.score);
            System.out.println("Player One Wins");
            result = GameResult.playerOneWins;
        } else if (playerOne.score == playerTwo.score) {
            System.out.println("Player one score:" + playerOne.score);
            System.out.println("Player two score:" + playerTwo.score);
            System.out.println("IT'S A DRAW");
            result = GameResult.draw;
        } else {
            System.out.println("Player one score:" + playerOne.score);
            System.out.println("Player two score:" + playerTwo.score);
            System.out.println("Player Two Wins");
            result = GameResult.playerTwoWins;
        }
        return result;
    }

    public void changeHeld(Player player) {
        System.out.println("Choose dice to hold, others will be re-rolled");

        char[] charArray = scanner.nextLine().replace(",","").toCharArray(); //index numbers
        int[] intArray = new int[charArray.length];

        for (int i = 0; i < charArray.length; i++){
            intArray[i] = Character.getNumericValue(charArray[i]) - 1;
        }

        player.bucket.SetHeldDice(intArray);

        Dice[] dice = player.bucket.getDice();
        System.out.println(Arrays.toString(dice));
            //Changes dice that need to be rolled again statuses to held: false, returns the updated array.
    }


}