import java.util.*;
import java.util.stream.Stream;

public class GameLoop {

    private boolean gameOver;
    private boolean turn;
    private GameResult gameState;
    private Scanner scanner = new Scanner(System.in);
    private ScoringCombinations score;
    private Player playerOne = new Player();
    private Player playerTwo = new Player();

    public GameLoop(IScoringCombinations scoringCombinations, Player[] players, int numberOfRerolls) {
//        runGame(players);
    }

    public void runGame(Player[] players) {
        gameState = GameResult.playing;
        System.out.println("Welcome to Yahtzee, Player one it is your turn");
        do {
            if(!turn) {
                System.out.println("Player one it is your turn");
                playerTurn(players[0],players);
            }
            else {
                System.out.println("Player two it is your turn");
                playerTurn(players[1],players);
            }
        }while(!gameOver);
    }

    private void playerTurn(Player player, Player[] playerArray) {
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
            returnGameResult(playerArray);
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

    public GameResult GetGameState() {
        return gameState;
    }

    public GameResult returnGameResult(Player[] players) {
        GameResult result = GameResult.none;
        Object[] scores = Arrays.stream(players).map(g -> g.score).toArray();
        for (int i = 0; i < scores.length; i++) {
            for (int j = i + 1; j < scores.length; j++) {
                if (scores[i] == (scores[j])) {
                    System.out.println("It's a draw!");
                   return GameResult.draw;
                }
            }
        }
        Optional<Player> highestScore = Arrays.stream(players)
                    .max(Comparator.comparing(Player::getScore));
        System.out.println(highestScore);
        String playerName = highestScore.map(g -> g.name).toString().replace("Optional","").replace("[","").replace("]","");
        System.out.println(playerName + " wins");
        result = GameResult.playerWins;
        System.out.println(result);
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