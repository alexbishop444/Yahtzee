public class Dice {
    public boolean held;
    public int value;

    @Override
    public String toString() {
        return "Dice{" +
                "held=" + held +
                ", value=" + value +
                '}';
    }

    public Dice(boolean held, int value) {
        this.held = held;
        this.value = value;
    }

    public Dice()
    {

    }
}
