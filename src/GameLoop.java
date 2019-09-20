import java.util.ArrayList;
import java.util.Scanner;
public class GameLoop {
    //all above are game categories

    private boolean gameover;
    boolean turn;


    Scanner scanner = new Scanner(System.in);
    ScoringCombinations score = new ScoringCombinations();
    Player playerOne = new Player(newRoll());
    Player playerTwo = new Player(newRoll());
    public void start() {
        System.out.println("Welcome to Yahtzee, Player one it is your turn");
        do {
            if(!turn) {
                playerTwo.reset();
                System.out.println("These are your cards.");
                System.out.println(playerOne.deck.toString());
                options(playerOne);
                choices(playerOne);
                System.out.println("Your total score is:" + playerOne.score);
//                if (playerTwo.check() && playerOne.check()) {
//                    winner(playerOne,playerTwo);
//                    System.out.println("Game over");
//                    gameover = true;
//                }
            }
            else if(turn) {
                playerOne.reset();
                System.out.println("Player twos turn. These are your cards:");
                System.out.println(playerTwo.deck.toString());
                options(playerTwo);
                choices(playerTwo);
                System.out.println("Your total score is:" + playerTwo.score);
//                if (playerTwo.check() && playerOne.check()) {
//                    winner(playerOne,playerTwo);
//                    gameover = true;
//                }
            }
        }while(!gameover);
    }

    private void options(Player player) {
        System.out.println("1. Chance used: " + player.scoreCard.get("chance"));
        System.out.println("2. Add up all Ones used:  " + player.scoreCard.get("ones"));
        System.out.println("3. Add up all Twos used:  " + player.scoreCard.get("twos"));
        System.out.println("4. Add up all Three used:  " + player.scoreCard.get("threes"));
        System.out.println("5. Add up all Fours used:  " + player.scoreCard.get("fours"));
        System.out.println("6. Add up all Fives used:  " + player.scoreCard.get("fives"));
        System.out.println("7. Add up all Sixes used:  " + player.scoreCard.get("sixes"));
        System.out.println("8. Pair used:  " + player.scoreCard.get("pair"));
        System.out.println("9. Two Pair used:  " + player.scoreCard.get("twoPairs"));
        System.out.println("10. Three of a kind:  " + player.scoreCard.get("threeOfAKind"));
        System.out.println("11. Four of a kind used:  " + player.scoreCard.get("fourOfAKind"));
        System.out.println("12. Small Straight used:  " + player.scoreCard.get("smallStraight"));
        System.out.println("13. Large Straight used:  " + player.scoreCard.get("largeStraight"));
        System.out.println("14. Full House used:  " + player.scoreCard.get("fullHouse"));
        System.out.println("15. Yahtzee used:  " + player.scoreCard.get("yahtzee"));
    }

    private void choices(Player player) {
        String choice = scanner.nextLine();
        if(choice.equals("1") && !player.scoreCard.get("chance")) {
            turn ^= true;
            player.score +=  score.chance(convertArray(player.deck));
            System.out.println(score.chance(convertArray(player.deck)));
            player.setDeck(newRoll());
            player.scoreCard.put("chance",true);
        } else if (choice.equals("2") && !player.scoreCard.get("ones")) {
            turn ^= true;
            player.score +=  score.addUpSameNumbers((convertArray(player.deck)),1);
            System.out.println(score.addUpSameNumbers(convertArray(player.deck),1));
            player.setDeck(newRoll());
            player.scoreCard.put("ones",true);
        } else if (choice.equals("3") && !player.scoreCard.get("twos")) {
            turn ^= true;
            player.score +=  score.addUpSameNumbers((convertArray(player.deck)),2);
            System.out.println(score.addUpSameNumbers(convertArray(player.deck),2));
            player.setDeck(newRoll());
            player.scoreCard.put("twos",true);
        } else if (choice.equals("4") && !player.scoreCard.get("threes")) {
            turn ^= true;
            player.score += score.addUpSameNumbers((convertArray(player.deck)),3);
            System.out.println(score.addUpSameNumbers(convertArray(player.deck),3));
            player.setDeck(newRoll());
            player.scoreCard.put("threes",true);
        } else if (choice.equals("5") && !player.scoreCard.get("fours")) {
            turn ^= true;
            player.score += score.addUpSameNumbers((convertArray(player.deck)),4);
            System.out.println(score.addUpSameNumbers(convertArray(player.deck),4));
            player.setDeck(newRoll());
            player.scoreCard.put("fours",true);
        } else if (choice.equals("6") && !player.scoreCard.get("fives")) {
            turn ^= true;
            player.score += score.addUpSameNumbers(convertArray(player.deck),5);
            System.out.println(score.addUpSameNumbers(convertArray(player.deck),5));
            player.setDeck(newRoll());
            player.scoreCard.put("fives",true);
        } else if (choice.equals("7") && !player.scoreCard.get("sixes")) {
            turn ^= true;
            player.score += score.addUpSameNumbers((convertArray(player.deck)),6);
            System.out.println(score.addUpSameNumbers(convertArray(player.deck),6));
            player.setDeck(newRoll());
            player.scoreCard.put("sixes",true);
        } else if (choice.equals("8") && !player.scoreCard.get("pair")) {
            turn = true;
            player.score += score.pair(convertArray(player.deck));
            System.out.println(score.pair(convertArray(player.deck)));
            player.setDeck(newRoll());
            player.scoreCard.put("pair",true);
        } else if (choice.equals("9") && !player.scoreCard.get("twoPairs")) {
            turn ^= true;
            player.score += score.twoPair(convertArray(player.deck));
            System.out.println(score.twoPair(convertArray(player.deck)));
            player.setDeck(newRoll());
            player.scoreCard.put("twoPairs",true);
        } else if (choice.equals("10") && !player.scoreCard.get("threeOfAKind")) {
            turn ^= true;
            player.score += score.threes(convertArray(player.deck));
            System.out.println(score.threes(convertArray(player.deck)));
            player.setDeck(newRoll());
            player.scoreCard.put("threeOfAKind",true);
        } else if (choice.equals("11") && !player.scoreCard.get("fourOfAKind")) {
            turn ^= true;
            player.score += score.foursCode(convertArray(player.deck));
            System.out.println(score.foursCode(convertArray(player.deck)));
            player.setDeck(newRoll());
            player.scoreCard.put("fourOfAKind",true);
        } else if (choice.equals("12") && !player.scoreCard.get("smallStraight")) {
            turn ^= true;
            player.score += score.smallStraight(convertArray(player.deck));
            System.out.println(score.smallStraight(convertArray(player.deck)));
            player.setDeck(newRoll());
            player.scoreCard.put("smallStraight",true);
        } else if (choice.equals("13") && !player.scoreCard.get("largeStraight")) {
            turn ^= true;
            player.score += score.largeStraight(convertArray(player.deck));
            System.out.println(score.largeStraight(convertArray(player.deck)));
            player.setDeck(newRoll());
            player.scoreCard.put("largeStraight",true);
        } else if (choice.equals("14") && !player.scoreCard.get("fullHouse")) {
            turn ^= true;
            player.score += score.fullHouse(convertArray(player.deck));
            System.out.println(score.fullHouse(convertArray(player.deck)));
            player.setDeck(newRoll());
            player.scoreCard.put("fullHouse",true);
        } else if (choice.equals("15") && !player.scoreCard.get("yahtzee")){
            turn ^= true;
            player.score += score.yahtzee(convertArray(player.deck));
            System.out.println(score.yahtzee((convertArray(player.deck))));
            player.setDeck(newRoll());
            player.scoreCard.put("yahtzee",true);
        } else {
            System.out.println("Invalid Input try again");
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
            return new Dice(true,randomInt);
    }

    public GameResult winner(Player player1,Player player2) {
        GameResult result = GameResult.none;
        if(player1.score > player2.score) {
            System.out.println("Player one score:" + player1.score);
            System.out.println("Player two score:" + player2.score);
            System.out.println("Player One Wins");
            result = GameResult.playerOneWins;
        } else if (player1.score == player2.score) {
            System.out.println("Player one score:" + player1.score);
            System.out.println("Player two score:" + player2.score);
            System.out.println("IT'S A DRAW");
            result = GameResult.draw;
        } else {
            System.out.println("Player one score:" + player1.score);
            System.out.println("Player two score:" + player2.score);
            System.out.println("Player Two Wins");
            result = GameResult.playerTwoWins;
        }
        System.out.println(result);
        return result;
    }

    public ArrayList<Dice> rerollArrray(Dice[] arr) {
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

    public ArrayList<Dice> reroll(Player player) {
        if(!player.roll1) {

        } else if(!player.roll2) {

        } else if(!player.roll3) {

        } else {
            System.out.println("You have used up all your turns");
        }
        return null;
    }


}
