import java.util.*;
import java.util.stream.*;
import java.util.Collections;
@SuppressWarnings("Duplicates")

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
        // For loop gets duplicate numbers by only adding if there is a duplicate, add its to the numbersDuplicated array, finds the highest number in that array since they can only be dupes then adds
//        that number twice
        int sum = 0;
        ArrayList<Integer> duplicates = findDuplicates(arr);
        int highestNumber = Collections.max(duplicates);
        sum += highestNumber * 2;
        return sum;
    }
    public int twoPair(int[] arr) {
        ArrayList<Integer> duplicates = findDuplicates(arr);
        System.out.println(duplicates);
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

    public int threeOrFourPair(int[] arr, int arg) {
        ArrayList<Integer> duplicates = findDuplicates(arr);
        int sum = 0;
        for (Integer item:duplicates) {
            System.out.println(item);
            switch (item) {
                case 1:
                    counterOne += 1;
                case 2:
                    counterTwo += 1;
                case 3:
                    counterThree += 1;
                case 4:
                    counterFour += 1;
                case 5:
                    counterFive += 1;
                case 6:
                    counterSix += 1;
            }
        }
        if(counterOne >= arg) {
            sum = timesCounters(1,arg);
        } else if (counterTwo >= 3) {
            sum = timesCounters(2,arg);
        } else if (counterThree >= 3) {
            sum = timesCounters(3,arg);
        } else if (counterFour >= 3) {
            sum = timesCounters(4,arg);
        } else if (counterFive >= 3) {
            sum = timesCounters(5,arg);
        } else if (counterSix >= 3) {
            sum = timesCounters(6,arg);
        } else {
            return 0;
        }
        return sum;
    }

}
