public enum ScoringCategory {
    CHANCE(0),
    ONES(1),
    TWOS(2),
    THREES(3),
    FOURS(4),
    FIVES(5),
    SIXES(6),
    PAIR(7),
    TWOPAIRS(8),
    THREEOFAKIND(9),
    FOUROFAKIND(10),
    SMALLSTRAIGHT(11),
    LARGESTRAIGHT(12),
    FULLHOUSE(13),
    YAHTZEE(14);

    public int getValue() {
        return value;
    }

    private int value;

    private ScoringCategory(int value) {
        this.value = value;
    }


}

