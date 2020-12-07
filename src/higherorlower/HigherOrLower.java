package higherorlower;

import java.util.Scanner;
import java.util.Random;

public class HigherOrLower {

    static Scanner input = new Scanner(System.in);
    static Random random = new Random();
    static int deaths = 0;
    static int rounds = 10;
    static boolean finished = false;
    static int[] cards = new int[10];
    static String guess;

    public static void main(String[] args) {

        while (finished == false) {
            deaths = 0;
            rounds = 10;
            System.out.println("HELLO");
            System.out.println("Welcome to higher or lower");
//            System.out.println("Would you like to hear the rules?");
//            String hearRules = input.next();
//            if(hearRules.equalsIgnoreCase("yes")){
//                rules();
//            }else{
//                break;
//            }
//            //switch case?
            System.out.println("Would you like to \n 1: Hear the rules \n 2: Play the game");
            String hearRules = input.next();
            
            switch(hearRules){
                case "1":
                    
                    rules();
                    cardsSetUp();
                    game();
                    break;
                    
                case "2":
                    cardsSetUp();
                    game();
                    break;
                    
            }

        }

    }
    public static void rules(){
        System.out.println("Here are the rules:");
        System.out.println();
        System.out.println(" - The aim of the game is to guess whether the next number is higher or lower \nthan the number shown");
        System.out.println(" - If you guess whether the number is higher or lower successfully,");
        System.out.println("you win that round.");
        System.out.println(" - This repeats until 10 rounds are up");
        System.out.println(" - However, if you get 3 wrong");
        System.out.println("you lose the game!");
        System.out.println(" - If by some chance the cards are the same in a row");
        System.out.println("you only win that round if you say higher!");
        System.out.println(" - You have the choice to play again at the end of the game");
        System.out.println();
        System.out.println();
        
    }

    public static void cardsSetUp() {
        // 10 cards
        for (int i = 0; i < 10; i++) {
            cards[i] = random.nextInt(14);
            
        }
        
    }

    public static void game() {
        System.out.println("Let's begin!");
        
        while ((deaths < 3) && (rounds > 0)) {
            for (int i = 0; i < 10; i++) {
                if (i < 9) {
                    System.out.println("THE CARD IS " + cards[i]);

                    System.out.println("Would you like to go higher or lower?");
                    guess = input.next();

                    if (cards[i] > cards[i + 1]) {
                        if (guess.equalsIgnoreCase("higher") ) {
                            System.out.println("Sorry thats incorrect");
                            deaths++;
                            rounds--;

                        } else if (guess.equalsIgnoreCase("lower")) {
                            System.out.println("Well done thats correct");
                            rounds--;

                        }
                    }
                    if (cards[i] <= cards[i + 1]) {
                        if (guess.equalsIgnoreCase("lower")) {
                            System.out.println("Sorry thats incorrect");
                            deaths++;
                            rounds--;

                        } else if ((guess.equalsIgnoreCase("higher")) || (cards[i] == cards[i+1])) {
                            System.out.println("Well done thats correct");
                            rounds--;

                        }
                    }
                    
                    if(cards[i] == cards[i+1]){
                        
                    }
                }
                if (i == 9) {
                    System.out.println("THE CARD IS " + cards[8]);

                    System.out.println("Would you like to go higher or lower?");
                    guess = input.next();
                    
                    if (cards[8] > cards[9]) {
                        if (guess.equalsIgnoreCase("higher")) {
                            System.out.println("Sorry thats incorrect");
                            rounds--;
                            deaths++;
                            
                        } else if(guess.equalsIgnoreCase("lower")){
                            System.out.println("Well done thats correct");
                            rounds--;
                        }
                    }
                    if(cards[8] < cards[9]){
                        if(guess.equalsIgnoreCase("lower")){
                            System.out.println("Sorry thats incorrect");
                            rounds--;
                            deaths++;
                        }else if(guess.equalsIgnoreCase("higher")){
                            System.out.println("Well done thats correct");
                            rounds--;
                            deaths++;
                        }
                    }
                }
                if(deaths == 3){
                    break;
                }
            }
        }
        if (deaths == 3) {
            loser();
        }
        if (rounds == 0) {
            winner();
        }
    }

    // set up list
    //show user first one
    //do you think next one will be higher or lower
//    public static void game() {
//        while ((deaths < 3) && (rounds > 0)) {
//            int randomCard = random.nextInt(14);
//            int temporary = randomCard;
//            randomCard = random.nextInt(14);
//            System.out.println("YOUR CARD IS: " + randomCard);
//            System.out.println("temp card: " + temporary);
//
//            try {
//                System.out.println("Higher or lower?");
//                String guess = input.next();
//
//                if (randomCard < temporary) {
//                    if (guess.equalsIgnoreCase("Higher")) {
//                        System.out.println("Correct well done");
//                        rounds--;
//                    } else if (guess.equalsIgnoreCase("lower")) {
//                        System.out.println("Incorrect sorry");
//                        rounds--;
//                        deaths++;
//
//                    }
//                }
//                if ((randomCard > temporary) || (randomCard == temporary)) {
//                    if (guess.equalsIgnoreCase("Higher")) {
//                        System.out.println("Incorrect sorry");
//                        rounds--;
//                        deaths++;
//                    } else if (guess.equalsIgnoreCase("lower")) {
//                        System.out.println("Correct well done");
//                        rounds--;
//                    }
//                }
//
//            } catch (Exception e) {
//                System.out.println("Error: " + e);
//            }
//        }
//        if (rounds == 0) {
//            winner();
//
//        }
//        if (deaths == 3) {
//            loser();
//        }
//    }
//
    public static void winner() {
        System.out.println("Well done!!!");
        System.out.println("You have won higher or lower!");
        System.out.println("With a total of " + deaths + " deaths");

        try {
            System.out.println("Would you like to play again?(y/n)");
            String playAgain = input.next();

            if (playAgain.equalsIgnoreCase("y")) {
                finished = false;
            } else if (playAgain.equalsIgnoreCase("n")) {
                finished = true;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void loser() {
        System.out.println("Sorry!");
        System.out.println("You have lost higher or lower");
        try {
            System.out.println("Would you like to play again?(y/n)");
            String playAgain = input.next();

            if (playAgain.equalsIgnoreCase("y")) {
                finished = false;
            } else if (playAgain.equalsIgnoreCase("n")) {
                finished = true;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
