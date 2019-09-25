import java.util.*;
import java.util.stream.*;
import java.util.Collections;
@SuppressWarnings("Duplicates")

public class ScoringCombinations implements IScoringCombinations {
    DiceRollMethods dice = new DiceRollMethods();
//    ScoreCard scoreCard = new ScoreCard();

    public ArrayList<Integer> numberArray(Dice[] arr) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (Dice d:arr) {
            numbers.add(d.value);
        }
        return numbers;
    }

    public int chance(Dice[] arr,Player player) {
        if(player.scoreCard.getScoreCard().get(ScoringCategory.CHANCE)) {
            return 0;
        }
        ArrayList<Integer> numbers = numberArray(arr);
        int[] arr2 = convertIntegers(numbers);
        int sum = IntStream.of(arr2).sum();
        return sum;
    }
    public int yahtzee(Dice[] arr, Player player) {
        if(player.scoreCard.getScoreCard().get(ScoringCategory.YAHTZEE)) {
            return 0;
        }
        ArrayList<Integer> numbers = numberArray(arr);
        int[] arr2 = convertIntegers(numbers);
        IntStream intStream1 = Arrays.stream(arr2);
        boolean allEqual = intStream1.distinct().limit(2).count() <= 1;
        if (allEqual) {
            return 50;
        } else {
            return 0;
        }
    }

    public int addUpSameNumbers(Dice[] arr, ScoringCategory category, Player player) {
        if(player.scoreCard.isScoringCategoryUsed(category)) {
            return 0;
        }
        int sum = 0;
        for (Dice item : arr) {
            if (item.value == category.getValue()) {
                sum += item.value;
            }
        }
        return sum;
    }

    public ArrayList<Dice> findDuplicates(Dice[] arr) {
        ArrayList<Integer> numbers = numberArray(arr);
        int[] arr2 = convertIntegers(numbers);
        ArrayList<Dice> numbersDuplicated = new <Dice>ArrayList();

        for (int i = 0; i < arr2.length; i++) {
            for (int j = i + 1; j < arr2.length; j++) {
                if (arr2[i] == (arr2[j])) {
                    numbersDuplicated.add(arr[i]);
                }
            }
        }
        return numbersDuplicated;
    }

    public int pair(Dice[] bucket) {
        // For loop gets duplicate numbers by only adding if there is a duplicate, add its to the numbersDuplicated array,
        // finds the highest number in that array since they can only be dupes then adds that number twice
        int sum = 0;
        ArrayList<Dice> duplicates = findDuplicates(bucket);
        Dice[] convertedBucket = dice.convertArray(duplicates);
        ArrayList<Integer> numbers = numberArray(convertedBucket);
        if (duplicates.size() == 0) {
            return 0;
        }
        int highestNumber = Collections.max(numbers);
        sum += highestNumber * 2;
        return sum;
    }
    public int twoPair(Dice[] arr) {
        ArrayList<Dice> duplicates = findDuplicates(arr);
        ArrayList<Integer> duplicatesInNums = new ArrayList<>();
        if(duplicates.size() < 2) {
            return 0;
        }
        for (Dice item:duplicates) {
            duplicatesInNums.add(item.value);
        }
        int sum = 0;
        int pair1 = Collections.max(duplicatesInNums);
        int pair2 = Collections.min(duplicatesInNums);
        if ((pair1 > 0 && pair2 > 0) && (pair1 != pair2)) {
            sum += pair1 * 2;
            sum += pair2 * 2;
        } else {
            sum = 0;
        }
        return sum;
    }

    public int threes(Dice[] dices) {
        return SharedThreesAndFoursCode(dices, 3);
    }

    public int foursCode(Dice[] dices)
    {
        return SharedThreesAndFoursCode(dices, 4);
    }

    private int[] getCounts(Dice[] dices) {
        int[] counts = new int[] {0,0,0,0,0,0};
        for (Dice d:dices) {
            counts[d.value - 1]++;
        }
        return counts;
    }

    private int SharedThreesAndFoursCode(Dice[] dices, int max)
    {
        // 3, 3, 3, 1, 5
        int[] counts = getCounts(dices);

        // {1, 0, 3, 0, 1}
        int highestCountNumber = 0;
        int highestCount = 0;
        for (int i = 1; i <= counts.length; i++)
        {
            if (counts[i - 1] >= highestCount)
            {
                highestCountNumber = i;
                highestCount = counts[i - 1];
            }
        }

        if (highestCount < max)
        {
            return 0;
        }

        return highestCountNumber * max;
    }

    public int smallStraight(Dice[] arr) {
        int[] compare = {1,2,3,4,5};
        ArrayList<Integer> numbers = numberArray(arr);
        int[] arr2 = convertIntegers(numbers);
        if(Arrays.equals(compare, arr2)) {
            return 15;
        }
        return 0;
    }
    public int largeStraight(Dice[] arr) {
        ArrayList<Integer> numbers = numberArray(arr);
        int[] arr2 = convertIntegers(numbers);
        int[] compare = {2,3,4,5,6};
        if(Arrays.equals(compare, arr2)) {
            return 20;
        }
        return 0;
    }

    public int[] convertIntegers(ArrayList<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    public int fullHouse(Dice[] dices) {
        boolean match = Arrays.stream(dices).allMatch(s -> s == (dices[0]));
        if(match) {
            return 0;
        }
        int sum = 0;
        int[] counts = getCounts(dices);
        //change counts to a list, then check if it contains the values 3 and 2.
//        System.out.println(Arrays.toString(counts));
        boolean match1 = Arrays.stream(counts).anyMatch(i -> i == 3);
        boolean match2 = Arrays.stream(counts).anyMatch(i -> i == 2);
        if (!match1 || !match2) {
            return 0;
        }

        for (int i = 0; i < counts.length; i++) {
            int value = counts[i];

            if (value > 0)
            {
                sum += value * (i + 1);
            }
        }

        return sum;
    }

    private void setScoreCombosToTrue(Player player, ScoringCategory category) {
        player.scoreCard.setScoringCategoryToTrue(category);
    }

    public void scoreCombinationCall (ScoringCategory category, Player player){
        Dice[] deck = dice.convertArray(player.deck);
        switch (category) {
            case CHANCE:
                player.score += chance(deck,player);
                break;
            case ONES:
                player.score += addUpSameNumbers(deck, category, player);
                break;
            case TWOS:
                player.score += addUpSameNumbers(deck, category, player);
                break;
            case THREES:
                player.score += addUpSameNumbers(deck, category, player);
                break;
            case FOURS:
                player.score += addUpSameNumbers(deck, category, player);
                break;
            case FIVES:
                player.score += addUpSameNumbers(deck, category, player);
                break;
            case SIXES:
                player.score += addUpSameNumbers(deck, category, player);
                break;
            case PAIR:
                player.score += pair(deck);
                break;
            case TWOPAIRS:
                player.score += twoPair(deck);
                break;
            case THREEOFAKIND:
                player.score += threes(deck);
                break;
            case FOUROFAKIND:
                player.score += foursCode(deck);
                break;
            case SMALLSTRAIGHT:
                player.score += smallStraight(deck);
                break;
            case LARGESTRAIGHT:
                player.score += largeStraight(deck);
                break;
            case FULLHOUSE:
                player.score += fullHouse(deck);
                break;
            case YAHTZEE:
                player.score += yahtzee(deck, player);
                break;
        }
        setScoreCombosToTrue(player,category);
    }
}
