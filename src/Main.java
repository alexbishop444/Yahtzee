import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        GameLoop test = new GameLoop();
        Dice[] a = test.newRoll();
        System.out.println(Arrays.deepToString(a));
        test.start();
    }
}
