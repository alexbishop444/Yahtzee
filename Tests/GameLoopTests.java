import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class GameLoopTests {
    ScoringCombinations scoringCombinations = new ScoringCombinations();
    ArrayList<Player> players = new ArrayList<>();
    Player playerOne = new Player();
    Player playerTwo = new Player();

//    @Test
//    public void winningPlayerTwoTest() {
//        GameLoop gameLoop = new GameLoop();
//        player.score = 400;
//        playerTwo.score = 500;
//        GameResult expected = GameResult.playerTwoWins;
//        GameResult actual = gameLoop.returnGameResult(player,playerTwo);
//        Assert.assertEquals(expected,actual);
//    }
    @Test
    public void winningPlayerOneTest() {
        playerOne.score = 34;
        playerOne.name = "alex";
        playerTwo.score = 34;
        playerTwo.name = "nick";
        players.add(playerOne);
        players.add(playerTwo);
        Player[] test = playerOne.convertArrayToPrimitive(players);
        GameLoop game = new GameLoop(scoringCombinations,test,3);
//        System.out.println(Arrays.toString(test));
        game.returnGameResult(test);
    }
//    @Test
//    public void drawTest() {
//        GameLoop gameLoop = new GameLoop();
//        player.score = 400;
//        playerTwo.score = 400;
//        GameResult expected = GameResult.draw;
//        GameResult actual = gameLoop.returnGameResult(player,playerTwo);
//        Assert.assertEquals(expected,actual);
//    }
}
