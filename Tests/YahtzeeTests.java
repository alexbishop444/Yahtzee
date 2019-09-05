import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class YahtzeeTests {
    GameMethods game = new GameMethods();
    @Test
    public void ChanceTest() {
        int[] hand = {1,3,6,4,3};
        int expected = 17;
        int actual = game.sumOfAllNumbers(hand);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void YahtzeeTest() {
        int[] hand = {4,4,4,4,4};
        int expected = 50;
        int actual = game.yahtzee(hand);
        Assert.assertEquals(expected,actual);
    }
}
