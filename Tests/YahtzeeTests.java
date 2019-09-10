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
    public void yahtzeeTest_unhappy() {
        int[] hand = new int[]{1,4,4,4,4};
        int expected = 0;

        yahtzeeTestRunner(hand, expected);
    }

    @Test
    public void yahtzeeTest() {

        int[] hand = {4,4,4,4,4};
        int expected = 50;
        yahtzeeTestRunner(hand, expected);

    }

    private void yahtzeeTestRunner(int[] hand, int expected)
    {
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
    public void addUpSameNumbersTest() {
        int[] handFive = {5,5,5,4,3};
        int expectedFive = 15;
        int actualFive = game.addUpSameNumbers(handFive,5);
        Assert.assertEquals(expectedFive,actualFive);

        int[] handFour = {5,5,4,4,3};
        int expectedFour = 8;
        int actualFour = game.addUpSameNumbers(handFour,4);
        Assert.assertEquals(expectedFour,actualFour);

        int[] handTwo = {2,2,4,2,3};
        int expectedTwo = 6;
        int actualTwo = game.addUpSameNumbers(handTwo,2);
        Assert.assertEquals(expectedTwo,actualTwo);
    }
    @Test
    public void pairTest() {

        int[] handWithOnePair = {2,2,6,5,4};
        int expectedOnePair = 4;
        int actualOnePair = game.pair(handWithOnePair);
        Assert.assertEquals(expectedOnePair,actualOnePair);


        int[] handWithTwoPairs = {3,5,3,1,1};
        int expectedTwoPairs = 6;
        int actualTwoPairs = game.pair(handWithTwoPairs);
        Assert.assertEquals(expectedTwoPairs,actualTwoPairs);

        int[] handWithNoPair = {3,0,0,5,1};
        int expectedNoPair = 0;
        int actualNoPair = game.pair(handWithNoPair);
        Assert.assertEquals(expectedNoPair,actualNoPair);
    }
    @Test
    public void twoPairTest() {

        int[] handWithOnePair = {2,2,6,5,4};
        int expectedOnePair = 0;
        int actualOnePair = game.twoPair(handWithOnePair);
        Assert.assertEquals(expectedOnePair,actualOnePair);

        int[] hand = {1,1,2,2,2};
        int expected = 6;
        int actual = game.twoPair(hand);
        Assert.assertEquals(expected,actual);

        int[] handWithNoPair = {3,0,0,5,1};
        int expectedNoPair = 0;
        int actualNoPair = game.twoPair(handWithNoPair);
        Assert.assertEquals(expectedNoPair,actualNoPair);

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
        int[] handWithFour = {4,4,4,4,5};
        int expectedFour = 16;
        int actualFour = game.threeOrFourPair(handWithFour,4);
        Assert.assertEquals(expectedFour,actualFour);

    }
    // Same method below but was bugged when used in the same test? Not sure why!
    @Test
    public void fourOfAkindTestPartTwo() {

        int[] handWithOnePair = {2,2,2,1,3};
        int expectedOnePair = 0;
        int actualOnePair = game.threeOrFourPair(handWithOnePair,4);
        Assert.assertEquals(expectedOnePair,actualOnePair);

        int[] handWithNoMatch = {1,2,3,4,5};
        int expectedNoMatch = 0;
        int actualNoMatch = game.threeOrFourPair(handWithNoMatch,4);
        Assert.assertEquals(expectedNoMatch,actualNoMatch);

    }

    @Test
    public void smallStraightTest() {
        int[] handWithStraight = {1,2,3,4,5};
        int expectedWithStraight = 15;
        int actualStraight = game.smallStraight(handWithStraight);
        Assert.assertEquals(expectedWithStraight,actualStraight);

        int[] handNoStraight = {1,2,1,4,5};
        int expectedNoStraight = 0;
        int actualNoStraight = game.smallStraight(handNoStraight);
        Assert.assertEquals(expectedNoStraight,actualNoStraight);
    }
    @Test
    public void largeStraightTest() {
        int[] handWithStraight = {2,3,4,5,6};
        int expectedStraight = 20;
        int actualStraight = game.largeStraight(handWithStraight);
        Assert.assertEquals(expectedStraight,actualStraight);

        int[] handNoStraight = {1,2,3,4,5};
        int expectedNoStraight = 0;
        int actualNoStraight = game.largeStraight(handNoStraight);
        Assert.assertEquals(expectedNoStraight,actualNoStraight);
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
