import java.util.*;
import java.util.stream.*;
import java.util.Collections;
@SuppressWarnings("Duplicates")

//public interface IGameMethods
//{
//    int chance(Dice[] dices);
//}

public class GameMethods {
    int counterOne = 0;
    int counterTwo = 0;
    int counterThree = 0;
    int counterFour = 0;
    int counterFive = 0;
    int counterSix = 0;

    public int chance(int[] arr) {
        int sum = IntStream.of(arr).sum();
        return sum;
    }
    public int yahtzee(int[] arr) {
        IntStream intStream1 = Arrays.stream(arr);
        boolean allEqual = intStream1.distinct().limit(2).count() <= 1;
        if (allEqual) {
            return 50;
        } else {
            return 0;
        }
    }

    public int addUpSameNumbers(int[] arr, int arg) {
        int sum = 0;
        for (int item : arr) {
            if (item == arg) {
                sum += item;
            }
        }
        return sum;
    }

    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> numbersDuplicated = new <Integer>ArrayList();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == (arr[j])) {
                    numbersDuplicated.add(arr[i]);
                }
            }
        }
        return numbersDuplicated;
    }

    public int pair(int[] arr) {
        // For loop gets duplicate numbers by only adding if there is a duplicate, add its to the numbersDuplicated array,
        // finds the highest number in that array since they can only be dupes then adds that number twice
        int sum = 0;
        ArrayList<Integer> duplicates = findDuplicates(arr);
        if (duplicates.size() == 0) {
            return 0;
        }
        int highestNumber = Collections.max(duplicates);
        sum += highestNumber * 2;
        return sum;
    }
    public int twoPair(int[] arr) {
        ArrayList<Integer> duplicates = findDuplicates(arr);
        int sum = 0;
        int pair1 = Collections.max(duplicates);
        int pair2 = Collections.min(duplicates);
        if ((pair1 > 0 && pair2 > 0) && (pair1 != pair2)) {
            sum += pair1 * 2;
            sum += pair2 * 2;
        } else {
            sum = 0;
        }
        return sum;
    }

    public int timesCounters(int arg, int arg2) {
        int sum = 0;
        if (arg == 1) {
            sum = arg2;
        } else if (arg == 2) {
            sum += 2 * arg2;
        } else if (arg == 3) {
            sum += 3 * arg2;
        } else if (arg == 4) {
            sum += 4 * arg2;
        } else if (arg == 5) {
            sum += 5 * arg2;
        } else if (arg == 6) {
            sum += 6 * arg2;
        }
        return sum;
    }

    public int threes(Dice[] dices) {
        return SharedThreesAndFoursCode(dices, 3);
    }

    public int FoursCode(Dice[] dices)
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
            }
        }

        if (highestCount < max)
        {
            return 0;
        }

        return highestCountNumber * max;
    }

    public int smallStraight(int[] arr) {
        int[] compare = {1,2,3,4,5};
        if(Arrays.equals(compare, arr)) {
            return 15;
        }
        return 0;
    }
    public int largeStraight(int[] arr) {
        int[] compare = {2,3,4,5,6};
        if(Arrays.equals(compare, arr)) {
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
        System.out.println(Arrays.toString(counts));
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
