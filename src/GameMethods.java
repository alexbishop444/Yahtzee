import java.util.*;
import java.util.stream.*;
import java.util.Collections;
@SuppressWarnings("Duplicates")

public class GameMethods {
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
        // For loop gets duplicate numbers, add its to the numbersDuplicated array, finds the highest number in that array since they can only be dupes then adds
//        that number twice
        int sum = 0;
        ArrayList<Integer> duplicates = findDuplicates(arr);
        int highestNumber = Collections.max(duplicates);
        sum += highestNumber * 2;
        return sum;
    }
    public int twoPair(int[] arr) {


    }
}
