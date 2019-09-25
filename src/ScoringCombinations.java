import java.util.*;
import java.util.stream.*;
import java.util.Collections;
@SuppressWarnings("Duplicates")

public class ScoringCombinations implements IScoringCombinations {
    DiceRollMethods dice = new DiceRollMethods();

    public ArrayList<Integer> numberArray(Dice[] bucket) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (Dice d:bucket) {
            numbers.add(d.value);
        }
        return numbers;
    }

    public int chance(Dice[] bucket,Player player) {
        if(player.scoreCard.getScoreCard().get(ScoringCategory.CHANCE)) {
            return 0;
        }
        ArrayList<Integer> numbers = numberArray(bucket);
        int[] diceValues = convertToIntegersArray(numbers);
        int sum = IntStream.of(diceValues).sum();
        return sum;
    }
    public int yahtzee(Dice[] bucket, Player player) {
        if(player.scoreCard.getScoreCard().get(ScoringCategory.YAHTZEE)) {
            return 0;
        }
        ArrayList<Integer> numbers = numberArray(bucket);
        int[] diceValues = convertToIntegersArray(numbers);
        IntStream intStream1 = Arrays.stream(diceValues);
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

    public ArrayList<Dice> findDuplicates(Dice[] bucket) {
        ArrayList<Integer> numbers = numberArray(bucket);
        int[] diceValues = convertToIntegersArray(numbers);
        ArrayList<Dice> numbersDuplicated = new <Dice>ArrayList();

        for (int i = 0; i < diceValues.length; i++) {
            for (int j = i + 1; j < diceValues.length; j++) {
                if (diceValues[i] == (diceValues[j])) {
                    numbersDuplicated.add(bucket[i]);
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
        Dice[] convertedBucket = dice.convertArrayToPrimitive(duplicates);
        ArrayList<Integer> numbers = numberArray(convertedBucket);
        if (duplicates.size() == 0) {
            return 0;
        }
        int highestNumber = Collections.max(numbers);
        sum += highestNumber * 2;
        return sum;
    }
    public int twoPair(Dice[] bucket) {
        ArrayList<Dice> duplicates = findDuplicates(bucket);
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

    public int threeOfAKind(Dice[] bucket) {
        return SharedThreesAndFoursCode(bucket, 3);
    }

    public int fourOfAKind(Dice[] bucket)
    {
        return SharedThreesAndFoursCode(bucket, 4);
    }

    private int[] getCounts(Dice[] bucket) {
        int[] counts = new int[] {0,0,0,0,0,0};
        for (Dice d:bucket) {
            counts[d.value - 1]++;
        }
        return counts;
    }

    private int SharedThreesAndFoursCode(Dice[] bucket, int max)
    {
        // 3, 3, 3, 1, 5
        int[] counts = getCounts(bucket);

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

    public int smallStraight(Dice[] bucket) {
        int[] compare = {1,2,3,4,5};
        ArrayList<Integer> numbers = numberArray(bucket);
        int[] arr2 = convertToIntegersArray(numbers);
        if(Arrays.equals(compare, arr2)) {
            return 15;
        }
        return 0;
    }
    public int largeStraight(Dice[] bucket) {
        ArrayList<Integer> numbers = numberArray(bucket);
        int[] arr2 = convertToIntegersArray(numbers);
        int[] compare = {2,3,4,5,6};
        if(Arrays.equals(compare, arr2)) {
            return 20;
        }
        return 0;
    }

    public int[] convertToIntegersArray(ArrayList<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    public int fullHouse(Dice[] bucket) {
        boolean match = Arrays.stream(bucket).allMatch(s -> s == (bucket[0]));
        if(match) {
            return 0;
        }
        int sum = 0;
        int[] counts = getCounts(bucket);
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
        Dice[] deck = dice.convertArrayToPrimitive(player.deck);
        switch (category) {
            case CHANCE:
                player.score += chance(deck,player);
                break;
            case ONES:
            case TWOS:
            case THREES:
            case FOURS:
            case FIVES:
            case SIXES:
                player.score += addUpSameNumbers(deck, category, player);
                break;
            case PAIR:
                player.score += pair(deck);
                break;
            case TWO_PAIRS:
                player.score += twoPair(deck);
                break;
            case THREE_OF_A_KIND:
                player.score += threeOfAKind(deck);
                break;
            case FOUR_OF_A_KIND:
                player.score += fourOfAKind(deck);
                break;
            case SMALL_STRAIGHT:
                player.score += smallStraight(deck);
                break;
            case LARGE_STRAIGHT:
                player.score += largeStraight(deck);
                break;
            case FULL_HOUSE:
                player.score += fullHouse(deck);
                break;
            case YAHTZEE:
                player.score += yahtzee(deck, player);
                break;
        }
        setScoreCombosToTrue(player,category);
    }
}
