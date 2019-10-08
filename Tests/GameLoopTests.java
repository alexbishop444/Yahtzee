import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GameLoopTests {
    ScoringCombinations scoringCombinations = new ScoringCombinations();
    ArrayList<Player> players = new ArrayList<>();
    Player playerOne = new Player("alex");
    Player playerTwo = new Player("nick");
    Player playerThree = new Player("matt");
    Player playerFour = new Player("sofia");

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
        playerOne.score = 1;
        playerTwo.score = 2;
        playerThree.score = 1;
        playerFour.score = 1;
        players.add(playerOne);
        players.add(playerTwo);
        players.add(playerThree);
        players.add(playerFour);
        Player[] test = playerOne.convertArrayToPrimitive(players);
        GameLoop game = new GameLoop(scoringCombinations,3);
//        System.out.println(Arrays.toString(test));
        Assert.assertEquals(GameResult.playerWins,game.returnGameResult(test));
    }
    @Test
    public void drawTest() {
        playerOne.score = 22;
        playerTwo.score = 45;
        playerThree.score = 45;
        playerFour.score = 22;
        players.add(playerOne);
        players.add(playerTwo);
        players.add(playerThree);
        players.add(playerFour);
        Player[] test = playerOne.convertArrayToPrimitive(players);
        GameLoop game = new GameLoop(scoringCombinations,3);
//        System.out.println(Arrays.toString(test));
        Assert.assertEquals(GameResult.draw,game.returnGameResult(test));
    }
//    @Test
//    public void heldTest() {
//        GameLoop game = new GameLoop(scoringCombinations,3);
//        game.changeDiceHeld(playerOne);
//    }
//    @Test
//    public void gamePlayingTest() {
//        GameLoop game = new GameLoop(scoringCombinations,3);
//        game.runGame();
//        Assert.assertEquals(GameResult.playing,game.getGameState());
//    }
}
