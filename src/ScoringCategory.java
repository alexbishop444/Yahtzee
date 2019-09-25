public enum ScoringCategory {
    CHANCE(0),
    ONES(1),
    TWOS(2),
    THREES(3),
    FOURS(4),
    FIVES(5),
    SIXES(6),
    PAIR(7),
    TWO_PAIRS(8),
    THREE_OF_A_KIND(9),
    FOUR_OF_A_KIND(10),
    SMALL_STRAIGHT(11),
    LARGE_STRAIGHT(12),
    FULL_HOUSE(13),
    YAHTZEE(14);

    public int getValue() {
        return value;
    }

    private int value;

    private ScoringCategory(int value) {
        this.value = value;
    }

    private static ScoringCategory[] allValues = values();
    public static ScoringCategory fromOrdinal(int n) {return allValues[n];}

}

