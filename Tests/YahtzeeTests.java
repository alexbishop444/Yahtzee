import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.OptionalInt;

public class YahtzeeTests {
    GameMethods game = new GameMethods();
    @Test
    public void chanceTest() {
        Dice[] hand = {
                new Dice(true,2),
                new Dice(true,5),
                new Dice(true,5),
                new Dice(true,1),
                new Dice(true,6),
        };
        int expected = 19;
        int actual = game.chance(hand);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void yahtzeeTest_unhappy() {
        Dice[] hand = {
                new Dice(true,1),
                new Dice(true,5),
                new Dice(true,5),
                new Dice(true,5),
                new Dice(true,5),
        };
        int expected = 0;

        yahtzeeTestRunner(hand, expected);
    }

    @Test
    public void yahtzeeTest() {

        Dice[] hand = {
                new Dice(true,5),
                new Dice(true,5),
                new Dice(true,5),
                new Dice(true,5),
                new Dice(true,5),
        };
        int expected = 50;
        yahtzeeTestRunner(hand, expected);

    }

    private void yahtzeeTestRunner(Dice[] hand, int expected)
    {
        int actual = game.yahtzee(hand);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addUpSameNumbersTestFour() {
        Dice[] hand = {
                new Dice(true,4),
                new Dice(true,4),
                new Dice(true,4),
                new Dice(true,5),
                new Dice(true,5),
        };
        int expected = 12;
        int actual = game.addUpSameNumbers(hand,4);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addUpSameNumbersTest() {
        Dice[] hand = {
                new Dice(true,5),
                new Dice(true,5),
                new Dice(true,5),
                new Dice(true,5),
                new Dice(true,5),
        };
        int expectedFive = 25;
        int actualFive = game.addUpSameNumbers(hand,5);
        Assert.assertEquals(expectedFive,actualFive);

    }
    @Test
    public void pairTest() {

        Dice[] hand = {
                new Dice(true,2),
                new Dice(true,2),
                new Dice(true,5),
                new Dice(true,5),
                new Dice(true,5),
        };
        int expectedOnePair = 10;
        int actualOnePair = game.pair(hand);
        Assert.assertEquals(expectedOnePair,actualOnePair);
    }
    @Test
    public void twoPairTest() {

        Dice[] hand = {
                new Dice(true,5),
                new Dice(true,5),
                new Dice(true,4),
                new Dice(true,4),
                new Dice(true,2),
        };
        int expectedOnePair = 18;
        int actualOnePair = game.twoPair(hand);
        Assert.assertEquals(expectedOnePair,actualOnePair);

    }
    @Test
    public void threeOfAKindTest() {

        Dice[] hand = {
                new Dice(true,2),
                new Dice(true,2),
                new Dice(true,2),
                new Dice(true,1),
                new Dice(true,1),
        };
        int expected =6;
        int actual = game.threes(hand);
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void fourOfAKindTest() {
        Dice[] hand = {
                new Dice(true,3),
                new Dice(true,3),
                new Dice(true,3),
                new Dice(true,3),
                new Dice(true,5),
        };
        int expectedFour = 12;
        int actualFour = game.foursCode(hand);
        Assert.assertEquals(expectedFour,actualFour);

    }
    // Same method below but was bugged when used in the same test? Not sure why!
    @Test
    public void fourOfAkindTestPartTwo() {

        Dice[] hand = {
                new Dice(true,5),
                new Dice(true,5),
                new Dice(true,5),
                new Dice(true,5),
                new Dice(true,5),
        };
        int expectedOnePair = 20;
        int actualOnePair = game.foursCode(hand);
        Assert.assertEquals(expectedOnePair,actualOnePair);

    }

    @Test
    public void smallStraightTest() {
        Dice[] hand = {
                new Dice(true,1),
                new Dice(true,2),
                new Dice(true,3),
                new Dice(true,4),
                new Dice(true,5),
        };
        int expectedWithStraight = 15;
        int actualStraight = game.smallStraight(hand);
        Assert.assertEquals(expectedWithStraight,actualStraight);
    }
    @Test
    public void largeStraightTest() {
        Dice[] hand = {
                new Dice(true,2),
                new Dice(true,3),
                new Dice(true,4),
                new Dice(true,5),
                new Dice(true,6),
        };
        int expectedStraight = 20;
        int actualStraight = game.largeStraight(hand);
        Assert.assertEquals(expectedStraight,actualStraight);
    }
    @Test
    public void fullHouseTest() {
        Dice[] handNoHouse = {
                new Dice(true,2),
                new Dice(true,2),
                new Dice(true,2),
                new Dice(true,1),
                new Dice(true,1),
        };
        int expectedNoHouse =8;
        int actualNoHouse = game.fullHouse(handNoHouse);
        Assert.assertEquals(expectedNoHouse,actualNoHouse);
    }
}
