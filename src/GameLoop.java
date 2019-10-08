import java.util.*;

public class GameLoop {

    private boolean gameOver;
    private boolean turn;
    private GameResult gameState;
    private Scanner scanner = new Scanner(System.in);
    private ScoringCombinations score;
//    ScoringCombinations score = new ScoringCombinations();
    private Player player = new Player("name");
    private int numberOfRerolls;

    public GameLoop(ScoringCombinations scoringCombinations, int numberOfRerolls) {
    this.numberOfRerolls = numberOfRerolls;
    this.score = scoringCombinations;
    }


    public void runGame() {
        Player[] players = createPlayers();
        gameState = GameResult.playing;
        System.out.println("Welcome to Yahtzee");
        do {
            for (int i = 0; i < players.length ; i++) {

                if (!turn) {
                    System.out.println(players[i].name + "s turn");
                    playerTurn(players[i], players);
                } else {
                    System.out.println(players[i].name + "s turn");
                    playerTurn(players[i], players);
                }
            }
        }while(!gameOver);
    }

    public Player[] createPlayers() {
        boolean loop = true; // is this generic name alright?
        ArrayList<Player> playerArrayList = new ArrayList<>();
        do {
            System.out.println("What is your name");
            String name = scanner.nextLine();
            playerArrayList.add(new Player(name));
            System.out.println("Continue making players, y or n?");
            String choice = scanner.nextLine();
            if (choice.equals("n")) {
                loop = false;
            }
        }while(loop);
        return player.convertArrayToPrimitive(playerArrayList);
    }

    private void playerTurn(Player player, Player[] playerArray) {
        // for loop here
        player.bucket.rollDice();
        System.out.println("These are your dice.");
        System.out.println(Arrays.toString(player.bucket.getDice()));
        printOutScoreCategories(player);
        setDiceToHeld(player);
        printOutScoreCategories(player);
        // end for loop
        getPlayerCategorySelectionAndCalculate(player);
        System.out.println("Your total score is:" + player.score);
        if (player.scoreCard.checkPlayersScoreCards(playerArray)) {
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

    public GameResult getGameState() {
        return gameState;
    }

    public GameResult returnGameResult(Player[] players) {
        GameResult result = GameResult.none;
        Integer duplicateScore = 0;
        Object[] playerScores = Arrays.stream(players).map(player -> player.score).toArray();
        for (int i = 0; i < playerScores.length; i++) {
            for (int j = i + 1; j < playerScores.length; j++) {
                if (playerScores[i] == (playerScores[j])) {
                    duplicateScore = Integer.parseInt(playerScores[i].toString());
                    break;
                }
            }
        }
        Optional<Player> highestScoringPlayer = Arrays.stream(players)
                    .max(Comparator.comparing(Player::getScore));
        Integer highestPlayerScore = Integer.parseInt(highestScoringPlayer.map(player -> player.score).toString().replace("Optional","").replace("[","").replace("]",""));
        String playerName = highestScoringPlayer.map(player -> player.name).toString().replace("Optional","").replace("[","").replace("]","");
        if(highestPlayerScore.equals(duplicateScore)) {
            System.out.println("It's a draw");
            return GameResult.draw;
        }
        System.out.println(playerName + " wins");
        result = GameResult.playerWins;
        return result;
    }

    public void setDiceToHeld(Player player) {
            for (int i = 0; i < numberOfRerolls; i++) {


                System.out.println("Choose dice to hold, others will be re-rolled");

                char[] playerInputToSelectDice = scanner.nextLine().replace(",", "").toCharArray();
                int[] selectedDice = new int[playerInputToSelectDice.length];

                for (int j = 0; j < playerInputToSelectDice.length; j++) {
                    selectedDice[j] = Character.getNumericValue(playerInputToSelectDice[j]) - 1;
                }

                player.bucket.SetHeldDice(selectedDice);
                player.bucket.rollDice();

                System.out.println(Arrays.toString(player.bucket.getDice()));
                if(i == numberOfRerolls - 1) {
                    break;
                }
                    System.out.println("Change again you have " + (i - numberOfRerolls + 1) + " turns remaining or type n to choose score option");
                    String playerInputToEndLoop = scanner.nextLine();
                    if (playerInputToEndLoop.equals("n")) {
                        break;
                    }
            }
    }


}