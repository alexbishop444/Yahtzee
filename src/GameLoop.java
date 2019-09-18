import java.util.ArrayList;
import java.util.Scanner;
public class GameLoop {
    //all above are game categories

    boolean gameover;


    Scanner scanner = new Scanner(System.in);
    ScoringCombinations score = new ScoringCombinations();
    Player playerOne = new Player(newRoll(),0,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
    Player playerTwo = new Player(newRoll(),0,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
    public void start() {
        System.out.println("Welcome to Yahtzee, Player one it is your turn");
        do {
            System.out.println("These are your cards.");
            System.out.println(playerOne.deck.toString());
            options(playerOne);
            choices(playerOne);
            if(playerOne.checkTest()) {
                gameover = true;
            }

        }while(!gameover);
    }

    private void options(Player player) {
        System.out.println("1. Chance used: " + player.chance);
        System.out.println("2. Add up all Ones used:  " + player.ones);
        System.out.println("3. Add up all Twos used:  " + player.twos);
        System.out.println("4. Add up all Three used:  " + player.threes);
        System.out.println("5. Add up all Fours used:  " + player.fours);
        System.out.println("6. Add up all Fives used:  " + player.fives);
        System.out.println("7. Add up all Sixes used:  " + player.sixes);
        System.out.println("8. Pair used:  " + player.pair);
        System.out.println("9. Two Pair used:  " + player.twoPairs);
        System.out.println("10. Three of a kind:  " + player.threeOfAKind);
        System.out.println("11. Four of a kind used:  " + player.fourOfAKind);
        System.out.println("12. Small Straight used:  " + player.smallStraight);
        System.out.println("13. Large Straight used:  " + player.largeStraight);
        System.out.println("14. Full House used:  " + player.fullHouse);
        System.out.println("15. Yahtzee used:  " + player.yahtzee);
    }

    private void choices(Player player) {
        String choice = scanner.nextLine();
        if(choice.equals("1") && !player.chance) {
            player.score +=  score.chance(convertArray(player.deck));
            System.out.println(score.chance(convertArray(player.deck)));
            player.chance = true;
        } else if (choice.equals("2") && !player.ones) {
            player.score +=  score.addUpSameNumbers((convertArray(player.deck)),1);
            System.out.println(score.addUpSameNumbers(convertArray(player.deck),1));
            player.ones = true;
        } else if (choice.equals("3") && !player.twos) {
            player.score +=  score.addUpSameNumbers((convertArray(player.deck)),2);
            System.out.println(score.addUpSameNumbers(convertArray(player.deck),2));
            player.twos = true;
        } else if (choice.equals("4") && !player.threes) {
            player.score += score.addUpSameNumbers((convertArray(player.deck)),3);
            System.out.println(score.addUpSameNumbers(convertArray(player.deck),3));
            player.threes = true;
        } else if (choice.equals("5") && !player.fours) {
            player.score += score.addUpSameNumbers((convertArray(player.deck)),4);
            System.out.println(score.addUpSameNumbers(convertArray(player.deck),4));
            player.fours = true;
        } else if (choice.equals("6") && !player.fives) {
            player.score += score.addUpSameNumbers(convertArray(player.deck),5);
            System.out.println(score.addUpSameNumbers(convertArray(player.deck),5));
            player.fives = true;
        } else if (choice.equals("7") && !player.sixes) {
            player.score += score.addUpSameNumbers((convertArray(player.deck)),6);
            System.out.println(score.addUpSameNumbers(convertArray(player.deck),6));
            player.sixes = true;
        } else if (choice.equals("8") && !player.pair) {
            player.score += score.pair(convertArray(player.deck));
            System.out.println(score.pair(convertArray(player.deck)));
            player.pair = true;
        } else if (choice.equals("9") && !player.twoPairs) {
            player.score += score.twoPair(convertArray(player.deck));
            System.out.println(score.twoPair(convertArray(player.deck)));
            player.twoPairs = true;
        } else if (choice.equals("10") && !player.threeOfAKind) {
            player.score += score.threes(convertArray(player.deck));
            System.out.println(score.threes(convertArray(player.deck)));
            player.threeOfAKind = true;
        } else if (choice.equals("11") && !player.fourOfAKind) {
            player.score += score.foursCode(convertArray(player.deck));
            System.out.println(score.foursCode(convertArray(player.deck)));
            player.fourOfAKind = true;
        } else if (choice.equals("12") && !player.smallStraight) {
            player.score += score.smallStraight(convertArray(player.deck));
            System.out.println(score.smallStraight(convertArray(player.deck)));
            player.smallStraight = true;
        } else if (choice.equals("13") && !player.largeStraight) {
            player.score += score.largeStraight(convertArray(player.deck));
            System.out.println(score.largeStraight(convertArray(player.deck)));
            player.largeStraight = true;
        } else if (choice.equals("14") && !player.fullHouse) {
            player.score += score.fullHouse(convertArray(player.deck));
            System.out.println(score.fullHouse(convertArray(player.deck)));
            player.fullHouse = true;
        } else if (choice.equals("15") && !player.yahtzee) {
            player.score += score.yahtzee(convertArray(player.deck));
            System.out.println(score.yahtzee((convertArray(player.deck))));
            player.yahtzee = true;
        } else {
            System.out.println("You have already used this option");
        }
    }

    public ArrayList<Dice> newRoll() {
        ArrayList<Dice> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add(roll());
        }
        return arr;
    }


    public Dice[] convertArray(ArrayList<Dice> arr) {
        Dice[] arr2 = arr.toArray(new Dice[arr.size()]);
        return arr2;
    }

    public Dice roll() {
            double randomDouble = Math.random();
            randomDouble = randomDouble * 6 + 1;
            int randomInt = (int) randomDouble;
            return new Dice(false,randomInt);
    }


}
