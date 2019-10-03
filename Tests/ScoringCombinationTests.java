import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ScoringCombinationTests {
    ScoringCombinations game = new ScoringCombinations();
    Player player = new Player();
    @Test
    public void mockChanceToReturn100() {
        Dice[] hand = {
                new Dice(true,2),
                new Dice(true,5),
                new Dice(true,5),
                new Dice(true,1),
                new Dice(true,6),
        };
        ScoringCombinations mockedScoringCombinations = mock(ScoringCombinations.class);
        when(mockedScoringCombinations.chance(hand,player)).thenReturn(100);
        System.out.println(mockedScoringCombinations.chance(hand,player));
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
        int actual = game.yahtzee(hand,player);
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
        int actual = game.addUpSameNumbers(hand,ScoringCategory.FOURS,player);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addUpSameNumbersTestOnes() {
        Dice[] hand = {
                new Dice(true,1),
                new Dice(true,1),
                new Dice(true,6),
                new Dice(true,3),
                new Dice(true,4),
        };
        int expected = 2;
        int actual = game.addUpSameNumbers(hand,ScoringCategory.ONES,player);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addUpSameNumbersTestFives() {
        Dice[] hand = {
                new Dice(true,5),
                new Dice(true,5),
                new Dice(true,5),
                new Dice(true,5),
                new Dice(true,5),
        };
        int expectedFive = 25;
        int actualFive = game.addUpSameNumbers(hand,ScoringCategory.FIVES,player);
        Assert.assertEquals(expectedFive,actualFive);

    }
    @Test
    public void pairTest() {

        Dice[] hand = {
                new Dice(true,2),
                new Dice(true,2),
                new Dice(true,5),
                new Dice(true,5),
                new Dice(true,6),
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
        int actual = game.threeOfAKind(hand);
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
        int actualFour = game.fourOfAKind(hand);
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
        int actualOnePair = game.fourOfAKind(hand);
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
