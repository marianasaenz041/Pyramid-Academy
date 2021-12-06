import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class hangmanGame {
    public static void drawHangman(int l) {
        if (l == 6) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 5) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 4) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 3) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 2) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 1) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   | ");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   | |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
    }

    public static boolean restartGame(String reply) {
        System.out.println("Do you want to play again? | y or n |");
        boolean res = false;
        if (reply.equals("y")) {
            res = false;
        } else if (reply.equals("n") || reply.equals("N")) {
            res = true;
        }
        return res;
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Let's Play Hangman");
        File dictionary = new File("C:\\javaprojects\\Hangman\\src\\java\\usa2.txt");
        Scanner textScanner = new Scanner(dictionary);
        Scanner input = new Scanner(System.in);
        Scanner playAgain = new Scanner(System.in);
        ArrayList<String> wordsList = new ArrayList<>();
        ArrayList<Character> missedLetters = new ArrayList<>();

        //adding all words from text file in to an arrayList
        while(textScanner.hasNext()){
            wordsList.add(textScanner.nextLine());
        }

        //generates random word from arrayList
        String secretWord = wordsList.get((int)(Math.random() * wordsList.size()));
        //char array goes through
        char[] textArray = secretWord.toCharArray();
        char[] myAnswers = new char[textArray.length];
        for(int i = 0; i < textArray.length; i++){
            myAnswers[i] = '?';
        }

        boolean finished = false;
        int lives = 6;

        try {
            while (finished == false) {
                System.out.println("**********************");
                String guess = input.next();
                //check for valid input
                while (guess.length() != 1 || Character.isDigit(guess.charAt(0))) {
                    System.out.println("Input is not valid. Try not using more than one character at a time.\n Answer will not contain any digits.");
                    guess = input.next();
                }

                //check if letter is in secret word
                boolean found = false;
                for (int i = 0; i < textArray.length; i++) {
                    if (guess.charAt(0) == textArray[i]) {
                        myAnswers[i] = textArray[i];
                        found = true;
                    }
                }
                if (!found) {
                    lives--;
                    System.out.println("Not in the secret word. Try again.");
                    missedLetters.add(guess.charAt(0));
                    System.out.println("Incorrect guesses: " + missedLetters);

                }
                boolean done = true;
                for (int i = 0; i < myAnswers.length; i++) {
                    if (myAnswers[i] == '?') {
                        System.out.print(" _");
                        done = false;
                    } else {
                        System.out.print(" " + myAnswers[i]);
                    }
                }
                System.out.println("\n" + " Lives left: " + lives);
                drawHangman(lives);

                if (done) {
                    System.out.println("You've guessed the secret word!");
                    finished = true;
                }
                if (lives <= 0) {
                    System.out.println("You died.");
                    String restart = playAgain.nextLine();
                    finished = restartGame(restart);
                }


            }
        }catch (Exception e){

        }
        System.out.println("The secret word was: " + secretWord);
        }
    }
