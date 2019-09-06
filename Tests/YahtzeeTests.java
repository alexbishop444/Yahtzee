import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.OptionalInt;

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
    public void pairTest() {
        int[] hand = {3,5,3,1,1};
        int expected = 6;
        int actual = game.pair(hand);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void twoPairTest() {
        int[] hand = {1,1,2,2,2};
        int expected = 6;
        int actual = game.twoPair(hand);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void threeOfAKindTest() {
        int[] hand = {2,2,3,3,4};
        int expected = 0;
        int actual = game.threeOrFourPair(hand,3);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void fourOfAKindTest() {
        int[] hand = {4,4,4,4,5};
        int expected = 16;
        int actual = game.threeOrFourPair(hand,4);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void smallStraightTest() {
        int[] hand = {1,2,3,4,5};
        int expected = 15;
        int actual = game.smallStraight(hand);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void largeStraightTest() {
        int[] hand = {2,3,4,5,6};
        int expected = 20;
        int actual = game.largeStraight(hand);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void fullHouseTest() {
        int[] hand = {2,2,1,3,4};
        int expected =0;
        int actual = game.fullHouse(hand);
        Assert.assertEquals(expected,actual);
    }
}
