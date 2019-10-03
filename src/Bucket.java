import java.util.ArrayList;

public class Bucket {
    private Dice[] dice = new Dice[5];

    public void setDice(Dice[] dice) {
        this.dice = dice;
    }

    public Dice[] getDice() {
        return dice;
    }

    public Bucket() {
        for (int i = 0; i < 5; i++) {
            dice[i] = new Dice();
        }
    }

    public Dice[] convertArrayToPrimitive(ArrayList<Dice> arr) {
        Dice[] arr2 = arr.toArray(new Dice[arr.size()]);
        return arr2;
    }


    public void rollDice() {
        for (Dice item : dice) {
            if (!item.held) {
                item.roll();
                item.held = true;
            }
        }
    }

    public void resetDiceHeld() {
        for (Dice item : dice) {
            item.held = false;
        }

    }
}
