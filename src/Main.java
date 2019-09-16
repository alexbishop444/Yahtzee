import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        GameLoop test = new GameLoop();
        ArrayList<Dice> a = test.newRoll();
        System.out.println(a.toString());
    }
}
