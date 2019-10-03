import org.junit.Assert;
import org.junit.Test;

public class GameLoopTests {
    Player player = new Player();
    Player playerTwo = new Player();

    @Test
    public void winningPlayerTwoTest() {
        GameLoop gameLoop = new GameLoop();
        player.score = 400;
        playerTwo.score = 500;
        GameResult expected = GameResult.playerTwoWins;
        GameResult actual = gameLoop.returnGameResult(player,playerTwo);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void winningPlayerOneTest() {
        GameLoop gameLoop = new GameLoop();
        player.score = 56;
        playerTwo.score = 54;
        GameResult expected = GameResult.playerOneWins;
        GameResult actual = gameLoop.returnGameResult(player,playerTwo);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void drawTest() {
        GameLoop gameLoop = new GameLoop();
        player.score = 400;
        playerTwo.score = 400;
        GameResult expected = GameResult.draw;
        GameResult actual = gameLoop.returnGameResult(player,playerTwo);
        Assert.assertEquals(expected,actual);
    }
}
