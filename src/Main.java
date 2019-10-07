import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ScoringCombinations scoringCombinations = new ScoringCombinations();
        GameLoop game = new GameLoop(scoringCombinations,3);
        game.runGame();
    }
}
