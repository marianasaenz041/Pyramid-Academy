package com.company;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // name input
        String name = getName();
        //max number of trials player can use
        int trials = 6;
        //user guess
        int guess;
        // number of guesses used up
        int i;

        //boolean that will allow game to restart
        boolean restart = true;
        do {
            try {
                //generating random number
                int number = 1 + (int) (20 * Math.random());
                System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.\n\nTake a guess.");
//for loop iterates through trials allowed for game.
//user takes a guess and method verifies  if it's within range
//compares guess to random number generated
                for (i = 0; i < trials; i++) {
                    guess = verifyInputIsInteger(input.nextInt());
                    verifyUserInput(guess, input);
                    if (guess == number) {
                        System.out.println("Good job," + name
                                + "! You guessed my number in " + (i + 1) + " tries!");
                        break;
                    } else if (guess < number && i < trials - 1) {
                        System.out.println("Your guess is too low.\nTake a guess.");
                    } else if (guess > number && i < trials - 1) {
                        System.out.println("Your guess is too high.\nTake a guess.");
                    }
                }
//game ends when number of iterations == number of trials
                if (i == trials) {
                    System.out.println("You've exhausted the number of guesses. You lose.");
                }
                System.out.println("Would you like to play again?(y/n)");
                String restartGame = input.next();
                if (restartGame.equals("n")) {
                    restart = false;
                    System.out.println("Exiting game");
                }
            } catch (Exception e) {
                System.out.println("Input must be a number");
                verifyInputIsInteger(input.nextLine());
            }
        } while (restart);
    }


    //methods
    public static String getName() {
        System.out.println("Hello! What is your name? ");
        return input.nextLine();
    }

    static void verifyUserInput(int guess, Scanner input) {
        while (guess < 1 || guess > 20) {
            System.out.println("You must choose a number within range");
            guess = input.nextInt();
        }
    }

    static int verifyInputIsInteger(Object obj) {
        try {
            if (obj instanceof Integer) {
                return (int)obj;
            } else {
                throw new Exception();
            }
        }catch(Exception e){
            System.out.println();
        }
        return 0;
    }
}


