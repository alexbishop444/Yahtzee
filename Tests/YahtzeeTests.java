import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class YahtzeeTests {
    GameMethods game = new GameMethods();
    @Test
    public void chanceTest() {
        int[] hand = {1,3,6,4,3};
        int expected = 17;
        int actual = game.chance(hand);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void yahtzeeTest() {
        int[] hand = {4,4,4,4,4};
        int expected = 50;
        int actual = game.yahtzee(hand);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addUpSameNumbersTestFour() {
        int[] hand = {4,4,4,4,3};
        int expected = 16;
        int actual = game.addUpSameNumbers(hand,4);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addUpSameNumbersTestFive() {
        int[] hand = {5,5,5,4,3};
        int expected = 15;
        int actual = game.addUpSameNumbers(hand,5);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addUpSameNumbersTestFive() {
        int[] hand = {5,5,5,4,3};
        int expected = 15;
        int actual = game.addUpSameNumbers(hand,5);
        Assert.assertEquals(expected,actual);
    }
}
