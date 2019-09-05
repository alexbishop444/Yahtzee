import java.util.stream.*;
import java.util.HashSet;
import java.util.Arrays;

public class GameMethods {
    int sumOfAllNumbers(int[] arr) {
        int sum = IntStream.of(arr).sum();
        return sum;
    }

    int yahtzee(int[] arr) {
        IntStream intStream1 = Arrays.stream(arr);
        boolean allEqual = intStream1.distinct().limit(2).count() <= 1;
        if (allEqual) {
            return 50;
        } else {
            return 0;
        }
    }
}
