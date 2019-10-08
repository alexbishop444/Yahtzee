import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ScoringCombinationTests {
    ScoringCombinations game = new ScoringCombinations();
    Player player = new Player("name");
    @Test
    public void mockChanceToReturn100() {
        player.bucket.getDice()[0] = new Dice(true,3);
        player.bucket.getDice()[1] = new Dice(true,3);
        player.bucket.getDice()[2] = new Dice(true,3);
        player.bucket.getDice()[3] = new Dice(true,3);
        player.bucket.getDice()[4] = new Dice(true,3);

        ScoringCombinations mockedScoringCombinations = mock(ScoringCombinations.class);
        when(mockedScoringCombinations.chance(player)).thenReturn(100);
        System.out.println(mockedScoringCombinations.chance(player));
    }
    @Test
    public void yahtzeeTest_unhappy() {
        player.bucket.getDice()[0] = new Dice(true,3);
        player.bucket.getDice()[1] = new Dice(true,3);
        player.bucket.getDice()[2] = new Dice(true,3);
        player.bucket.getDice()[3] = new Dice(true,3);
        player.bucket.getDice()[4] = new Dice(true,2);
        int expected = 0;

        Assert.assertEquals(game.yahtzee(player),expected);
    }

    @Test
    public void yahtzeeTest() {

        player.bucket.getDice()[0] = new Dice(true,3);
        player.bucket.getDice()[1] = new Dice(true,3);
        player.bucket.getDice()[2] = new Dice(true,3);
        player.bucket.getDice()[3] = new Dice(true,3);
        player.bucket.getDice()[4] = new Dice(true,3);
        int expected = 50;

        Assert.assertEquals(game.yahtzee(player),expected);

    }

    @Test
    public void addUpSameNumbersTestFour() {
        player.bucket.getDice()[0] = new Dice(true,3);
        player.bucket.getDice()[1] = new Dice(true,4);
        player.bucket.getDice()[2] = new Dice(true,4);
        player.bucket.getDice()[3] = new Dice(true,4);
        player.bucket.getDice()[4] = new Dice(true,3);
        int expected = 12;
        int actual = game.addUpSameNumbers(ScoringCategory.FOURS,player);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addUpSameNumbersTestOnes() {
        player.bucket.getDice()[0] = new Dice(true,3);
        player.bucket.getDice()[1] = new Dice(true,1);
        player.bucket.getDice()[2] = new Dice(true,1);
        player.bucket.getDice()[3] = new Dice(true,3);
        player.bucket.getDice()[4] = new Dice(true,3);
        int expected = 2;
        int actual = game.addUpSameNumbers(ScoringCategory.ONES,player);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addUpSameNumbersTestFives() {
        player.bucket.getDice()[0] = new Dice(true,5);
        player.bucket.getDice()[1] = new Dice(true,5);
        player.bucket.getDice()[2] = new Dice(true,5);
        player.bucket.getDice()[3] = new Dice(true,5);
        player.bucket.getDice()[4] = new Dice(true,5);
        int expected = 25;
        int actualFive = game.addUpSameNumbers(ScoringCategory.FIVES,player);
        Assert.assertEquals(expected,actualFive);

    }
    @Test
    public void pairTest() {
        player.bucket.getDice()[0] = new Dice(true,3);
        player.bucket.getDice()[1] = new Dice(true,3);
        player.bucket.getDice()[2] = new Dice(true,3);
        player.bucket.getDice()[3] = new Dice(true,3);
        player.bucket.getDice()[4] = new Dice(true,3);
        int expected = 6;
        int actualOnePair = game.pair(player);
        Assert.assertEquals(expected,actualOnePair);
    }
    @Test
    public void twoPairTest() {
        player.bucket.getDice()[0] = new Dice(true,2);
        player.bucket.getDice()[1] = new Dice(true,2);
        player.bucket.getDice()[2] = new Dice(true,3);
        player.bucket.getDice()[3] = new Dice(true,3);
        player.bucket.getDice()[4] = new Dice(true,3);
        int expected = 10;
        int actualOnePair = game.twoPair(player);
        Assert.assertEquals(expected,actualOnePair);

    }
    @Test
    public void threeOfAKindTest() {
        player.bucket.getDice()[0] = new Dice(true,3);
        player.bucket.getDice()[1] = new Dice(true,3);
        player.bucket.getDice()[2] = new Dice(true,3);
        player.bucket.getDice()[3] = new Dice(true,3);
        player.bucket.getDice()[4] = new Dice(true,3);
        int expected = 9;
        int actual = game.threeOfAKind(player);
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void fourOfAKindTest() {
        player.bucket.getDice()[0] = new Dice(true,3);
        player.bucket.getDice()[1] = new Dice(true,5);
        player.bucket.getDice()[2] = new Dice(true,5);
        player.bucket.getDice()[3] = new Dice(true,5);
        player.bucket.getDice()[4] = new Dice(true,5);
        int expected = 20;
        int actualFour = game.fourOfAKind(player);
        Assert.assertEquals(expected,actualFour);

    }
    // Same method below but was bugged when used in the same test? Not sure why!
    @Test
    public void fourOfAKindTestPartTwo() {

        player.bucket.getDice()[0] = new Dice(true,2);
        player.bucket.getDice()[1] = new Dice(true,2);
        player.bucket.getDice()[2] = new Dice(true,2);
        player.bucket.getDice()[3] = new Dice(true,2);
        player.bucket.getDice()[4] = new Dice(true,2);
        int expected = 8;
        int actualOnePair = game.fourOfAKind(player);
        Assert.assertEquals(expected,actualOnePair);

    }

    @Test
    public void smallStraightTest() {
        player.bucket.getDice()[0] = new Dice(true,1);
        player.bucket.getDice()[1] = new Dice(true,2);
        player.bucket.getDice()[2] = new Dice(true,3);
        player.bucket.getDice()[3] = new Dice(true,4);
        player.bucket.getDice()[4] = new Dice(true,5);
        int expected = 15;
        int actualStraight = game.smallStraight(player);
        Assert.assertEquals(expected,actualStraight);
    }
    @Test
    public void largeStraightTest() {
        player.bucket.getDice()[0] = new Dice(true,2);
        player.bucket.getDice()[1] = new Dice(true,3);
        player.bucket.getDice()[2] = new Dice(true,4);
        player.bucket.getDice()[3] = new Dice(true,5);
        player.bucket.getDice()[4] = new Dice(true,6);
        int expected = 20;
        int actualStraight = game.largeStraight(player);
        Assert.assertEquals(expected,actualStraight);
    }
    @Test
    public void fullHouseTest() {
        player.bucket.getDice()[0] = new Dice(true,2);
        player.bucket.getDice()[1] = new Dice(true,2);
        player.bucket.getDice()[2] = new Dice(true,2);
        player.bucket.getDice()[3] = new Dice(true,1);
        player.bucket.getDice()[4] = new Dice(true,1);
        int expected = 8;
        int actual = game.fullHouse(player);
        Assert.assertEquals(expected,actual);
    }
}
