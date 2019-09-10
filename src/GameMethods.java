import java.util.*;
import java.util.stream.*;
import java.util.Collections;
@SuppressWarnings("Duplicates")

//public interface IGameMethods
//{
//    int chance(Dice[] dices);
//}

public class GameMethods {

    public ArrayList<Integer> numberArray(Dice[] arr) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (Dice d:arr) {
            numbers.add(d.value);
        }
        return numbers;
    }

    public int chance(Dice[] arr) {
        ArrayList<Integer> numbers = numberArray(arr);
        int[] arr2 = convertIntegers(numbers);
        int sum = IntStream.of(arr2).sum();
        return sum;
    }
    public int yahtzee(Dice[] arr) {
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

    public int addUpSameNumbers(Dice[] arr, int arg) {
        int sum = 0;
        for (Dice item : arr) {
            if (item.value == arg) {
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

    public int pair(Dice[] arr) {
        // For loop gets duplicate numbers by only adding if there is a duplicate, add its to the numbersDuplicated array,
        // finds the highest number in that array since they can only be dupes then adds that number twice
        int sum = 0;
        ArrayList<Dice> duplicates = findDuplicates(arr);
        ArrayList<Integer> numbers = numberArray(arr);
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

}
