import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.util.List;

public class YahtzeeTests {
    ScoringCombinations game = new ScoringCombinations();
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


        // mock creation
        ScoringCombinations mockedScoringCombinations = mock(ScoringCombinations.class);

//        using mock object - it does not throw any "unexpected interaction" exception
//        mockedScoringCombinations.chance();


        // SomeFunction()
        // gameloop
        // call scoringcombinations.yahtzee returns some value
        // if that value > 50 you win
        // else you lose


//        when(mockedScoringCombinations.chance(hand)).thenThrow(100);
        System.out.println(mockedScoringCombinations.chance(hand));
    }
    @Test
    public void mockTest() {
        Dice[] hand = {};
        // mock creation
        ScoringCombinations mockedScoringCombinations = mock(ScoringCombinations.class);
        when(mockedScoringCombinations.chance(hand)).thenReturn(100);
        System.out.println(mockedScoringCombinations.chance(hand));
    }
//    @Test
//    public void winningPlayerOneTest() {
//        Dice[] hand = {};
//        // mock creation
//        GameLoop roll = new GameLoop();
//        Player playerTwo = new Player(roll.newRoll(),0,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
//        Player playerOne = new Player(roll.newRoll(),0,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
//        GameLoop mockedGameLoop = mock(GameLoop.class);
//        when(mockedGameLoop.winner(playerOne,playerTwo)).thenReturn();
//        System.out.println(mockedScoringCombinations.chance(hand));
//    }
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
    public void addUpSameNumbersTestOnes() {
        Dice[] hand = {
                new Dice(true,1),
                new Dice(true,1),
                new Dice(true,6),
                new Dice(true,3),
                new Dice(true,4),
        };
        int expected = 2;
        int actual = game.addUpSameNumbers(hand,1);
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
    @Test
    public void keyTest() {
        GameLoop roll = new GameLoop();
        Player playerOne = new Player(roll.newRoll());
        System.out.println(playerOne.scoreCard.get("chance"));
        playerOne.scoreCard.put("chance",true);
        System.out.println(playerOne.scoreCard.get("chance"));
    }
}
