import java.util.ArrayList;

public class DiceRollMethods {

    public Dice[] convertArray(ArrayList<Dice> arr) {
        Dice[] arr2 = arr.toArray(new Dice[arr.size()]);
        return arr2;
    }

    public ArrayList<Dice> newRoll() {
        ArrayList<Dice> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add(roll());
        }
        return arr;
    }

    public Dice roll() {
        double randomDouble = Math.random();
        randomDouble = randomDouble * 6 + 1;
        int randomInt = (int) randomDouble;
        return new Dice(true,randomInt);
    }

    public ArrayList<Dice> rerollArrray(ArrayList<Dice> arr) {
        ArrayList<Dice> updatedArray = new ArrayList<>();
        for (Dice item:arr) {
            if(item.held) {
                updatedArray.add(item);
            }
        }
        for (int i = updatedArray.size(); i < 5; i++) {
            updatedArray.add(roll());
        }
        return updatedArray;
    }

    public ArrayList<Dice> reroll(Player player, ArrayList<Dice> arr) {
        if(!player.roll1) {
            return rerollArrray(arr);
        } else if(!player.roll2) {
            return rerollArrray(arr);
        } else if(!player.roll3) {
            return rerollArrray(arr);
        } else {
            System.out.println("You have used up all your turns");
        }
        return null;
    }
}
