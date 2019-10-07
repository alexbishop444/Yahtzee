import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ScoringCombinations scoringCombinations = new ScoringCombinations();
        ArrayList<Player> players = new ArrayList<>();
        Player playerOne = new Player();
        playerOne.name = "alex";
        Player playerTwo = new Player();
        playerTwo.name = "nick";
        players.add(playerOne);
        players.add(playerTwo);
        Player[] test = playerOne.convertArrayToPrimitive(players);
        GameLoop game = new GameLoop(scoringCombinations,test,3);
//        game.runGame(test);
    }
}
