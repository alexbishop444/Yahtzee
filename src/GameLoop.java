import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class GameLoop {
    //all above are game categories

    private boolean gameover;
    boolean turn;
    boolean rollChoice;
    Scanner scanner = new Scanner(System.in);
    DiceRollMethods dice = new DiceRollMethods();
    ScoringCombinations score = new ScoringCombinations();
    Player playerOne = new Player(dice.newRoll());
    Player playerTwo = new Player(dice.newRoll());
    ScoreCard scoreCard = new ScoreCard();
    public void start() {
        System.out.println("Welcome to Yahtzee, Player one it is your turn");
        do {
            if(!turn) {
                rollChoice = false;
                playerTwo.reset();
                System.out.println("These are your cards.");
                System.out.println(playerOne.deck.toString());
                options(playerOne);
                choices(playerOne,playerOne.deck);
                System.out.println("Your total score is:" + playerOne.score);
                if (playerTwo.scoreCard.isGameOver() && playerOne.scoreCard.isGameOver()) {
                    winner(playerOne,playerTwo);
                    System.out.println("Game over");
                    gameover = true;
                }
                turn ^= true;
            }
            else if(turn) {
                rollChoice = false;
                playerOne.reset();
                System.out.println("Player twos turn. These are your cards:");
                System.out.println(playerTwo.deck.toString());
                options(playerTwo);
                choices(playerTwo,playerTwo.deck);
                System.out.println("Your total score is:" + playerTwo.score);
                if (playerTwo.scoreCard.isGameOver() && playerOne.scoreCard.isGameOver()) {
                    winner(playerOne,playerTwo);
                    gameover = true;
                }
                turn ^= true;
            }
        }while(!gameover);
    }

        private void options(Player player) {
            for(Map.Entry<ScoringCategory, Boolean> entry : scoreCard.getScoreCard().entrySet()) {
                ScoringCategory key = entry.getKey();
                Boolean value = entry.getValue();
                System.out.println(key.getValue() + " " + key.toString() + " " + "Used " + value);
            }
    }

    private void choices(Player player, ArrayList<Dice> playerArray) {
        Integer choice = Integer.parseInt(scanner.nextLine());
        score.scoreCombinationCall(choice,player);
        player.setDeck(dice.newRoll());
    }
//        Integer choice = Integer.parseInt(scanner.nextLine());
//        ScoringCategory.
//        //make choice pass to int then get the enum value.
//        if(choice.equals("1") && !player.scoreCard.get("chance")) {
//            turn ^= true;
//            player.score +=  score.chance(convertArray(player.deck));
//            System.out.println(score.chance(convertArray(player.deck)));
//            player.setDeck(newRoll());
//            player.scoreCard.put("chance",true);
//        } else if (choice.equals("2") && !player.scoreCard.get("ones")) {
//            turn ^= true;
//            player.score +=  score.addUpSameNumbers((convertArray(player.deck)),1);
//            System.out.println(score.addUpSameNumbers(convertArray(player.deck),1));
//            player.setDeck(newRoll());
//            player.scoreCard.put("ones",true);
//        } else if (choice.equals("3") && !player.scoreCard.get("twos")) {
//            turn ^= true;
//            player.score +=  score.addUpSameNumbers((convertArray(player.deck)),2);
//            System.out.println(score.addUpSameNumbers(convertArray(player.deck),2));
//            player.setDeck(newRoll());
//            player.scoreCard.put("twos",true);
//        } else if (choice.equals("4") && !player.scoreCard.get("threes")) {
//            turn ^= true;
//            player.score += score.addUpSameNumbers((convertArray(player.deck)),3);
//            System.out.println(score.addUpSameNumbers(convertArray(player.deck),3));
//            player.setDeck(newRoll());
//            player.scoreCard.put("threes",true);
//        } else if (choice.equals("5") && !player.scoreCard.get("fours")) {
//            turn ^= true;
//            player.score += score.addUpSameNumbers((convertArray(player.deck)),4);
//            System.out.println(score.addUpSameNumbers(convertArray(player.deck),4));
//            player.setDeck(newRoll());
//            player.scoreCard.put("fours",true);
//        } else if (choice.equals("6") && !player.scoreCard.get("fives")) {
//            turn ^= true;
//            player.score += score.addUpSameNumbers(convertArray(player.deck),5);
//            System.out.println(score.addUpSameNumbers(convertArray(player.deck),5));
//            player.setDeck(newRoll());
//            player.scoreCard.put("fives",true);
//        } else if (choice.equals("7") && !player.scoreCard.get("sixes")) {
//            turn ^= true;
//            player.score += score.addUpSameNumbers((convertArray(player.deck)),6);
//            System.out.println(score.addUpSameNumbers(convertArray(player.deck),6));
//            player.setDeck(newRoll());
//            player.scoreCard.put("sixes",true);
//        } else if (choice.equals("8") && !player.scoreCard.get("pair")) {
//            turn = true;
//            player.score += score.pair(convertArray(player.deck));
//            System.out.println(score.pair(convertArray(player.deck)));
//            player.setDeck(newRoll());
//            player.scoreCard.put("pair",true);
//        } else if (choice.equals("9") && !player.scoreCard.get("twoPairs")) {
//            turn ^= true;
//            player.score += score.twoPair(convertArray(player.deck));
//            System.out.println(score.twoPair(convertArray(player.deck)));
//            player.setDeck(newRoll());
//            player.scoreCard.put("twoPairs",true);
//        } else if (choice.equals("10") && !player.scoreCard.get("threeOfAKind")) {
//            turn ^= true;
//            player.score += score.threes(convertArray(player.deck));
//            System.out.println(score.threes(convertArray(player.deck)));
//            player.setDeck(newRoll());
//            player.scoreCard.put("threeOfAKind",true);
//        } else if (choice.equals("11") && !player.scoreCard.get("fourOfAKind")) {
//            turn ^= true;
//            player.score += score.foursCode(convertArray(player.deck));
//            System.out.println(score.foursCode(convertArray(player.deck)));
//            player.setDeck(newRoll());
//            player.scoreCard.put("fourOfAKind",true);
//        } else if (choice.equals("12") && !player.scoreCard.get("smallStraight")) {
//            turn ^= true;
//            player.score += score.smallStraight(convertArray(player.deck));
//            System.out.println(score.smallStraight(convertArray(player.deck)));
//            player.setDeck(newRoll());
//            player.scoreCard.put("smallStraight",true);
//        } else if (choice.equals("13") && !player.scoreCard.get("largeStraight")) {
//            turn ^= true;
//            player.score += score.largeStraight(convertArray(player.deck));
//            System.out.println(score.largeStraight(convertArray(player.deck)));
//            player.setDeck(newRoll());
//            player.scoreCard.put("largeStraight",true);
//        } else if (choice.equals("14") && !player.scoreCard.get("fullHouse")) {
//            turn ^= true;
//            player.score += score.fullHouse(convertArray(player.deck));
//            System.out.println(score.fullHouse(convertArray(player.deck)));
//            player.setDeck(newRoll());
//            player.scoreCard.put("fullHouse",true);
//        } else if (choice.equals("15") && !player.scoreCard.get("yahtzee")) {
//            turn ^= true;
//            player.score += score.yahtzee(convertArray(player.deck));
//            System.out.println(score.yahtzee((convertArray(player.deck))));
//            player.setDeck(newRoll());
//            player.scoreCard.put("yahtzee", true);
//        } else if(choice.equals("r")) {
//            while(!rollChoice) {
//                System.out.println("What dice do you want to re-roll? Pick from 1-5 separated by commas");
//                changeHeld(playerArray);
//                player.deck = reroll(player,playerArray);
//                System.out.println("These are your cards, are you happy to use these?");
//                System.out.println(player.deck.toString());
//                String playerRollChoice = scanner.nextLine();
//                if(playerRollChoice.equals("y")) {
//                    rollChoice = true;
//                    options(player);
//                    choices(player,player.deck);
//                }
//            }
//
//        } else {
//            System.out.println("Invalid Input try again");
//        }
//    }

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
        return result;
    }

    public ArrayList<Dice> changeHeld(ArrayList<Dice> playerArr) {
        char[] choiceArr = scanner.nextLine().replace(",","").toCharArray(); //index numbers
            for (char item:choiceArr) {
                int charValue = Character.getNumericValue(item) - 1;
                Dice changeDice = playerArr.get(charValue);
                changeDice.held = false;
            }
            //Changes dice that need to be rolled again statuses to held: false, returns the updated array.
            return playerArr;
    }


}
