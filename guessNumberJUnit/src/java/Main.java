import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    static int generator() {
        return ThreadLocalRandom.current().nextInt(1, 20);
    }

    public static Scanner input = new Scanner(System.in);

    public static String getName() {
        System.out.println("Hello! What is your name? ");
        return input.nextLine();
    }

//    static void verifyUserInput(int guess, Scanner input) {
//        while (guess < 1 || guess > 20) {
//            System.out.println("You must choose a number within range");
//            guess = input.nextInt();
//        }
//    }

//    static int verifyInputIsInteger(Object obj) {
//        try {
//            if (obj instanceof Integer) {
//                return (int) obj;
//            } else {
//                throw new Exception();
//            }
//        } catch (Exception e) {
//            System.out.println();
//        }
//        return 0;
//    }

    static int guessedNum() {
        System.out.println("Take a guess: 1-20");
        return input.nextInt();
    }

    static boolean tooHightooLow(int guess, int number) {

        if (guess < number) {
            System.out.println("Your guess is too low.");
        } else if (guess > number) {
            System.out.println("Your guess is too high.");
        } else {
            System.out.println("Good job,"
                    + "! You guessed my number");
            return true;
        }
        return false;
    }

//    static boolean playAgain() {
//        System.out.println("Would you like to play again?(y/n)");
//        return restarting(input.nextLine());
//    }
//
//    static boolean restarting(String yn) {
//        if (yn.startsWith("n")) return false;
//        return true;
//    }
static boolean playAgain() {
    System.out.println("Would you like to play again? (y or n)");
    return isPlayAgain(input.nextLine());
}

    static boolean isPlayAgain(String answer) {
        try {
            if (answer.startsWith("y")) {
                return true;
            }
        } catch (Exception exception) {
            exception.toString();
        }
        return false;
    }


    public static void main(String[] args) {
        // name input
//        String name = getName();
//        System.out.println("Hello, " + name);
//        int x = generator();
//        while (true) {
//            if (tooHightooLow(guessedNum(), x)) {
//                if (playAgain()) {
//                    x = generator();
//                }
//                break;
//            }
        String name = getName();
        System.out.println("Hello, " + name);
        int secret = generator();

        while (true) {
            if (tooHightooLow(guessedNum(), secret)) {
                if (!playAgain()) {
                    break;
                }
                secret = generator();
            }
    }


        //boolean that will allow game to restart
//        boolean restart = true;
//        do {
//            try {
//                //generating random number
//                int number = 1 + (int) (20 * Math.random());
//                System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.\n\nTake a guess.");
//
//
//
//            } catch (Exception e) {
//                System.out.println("Input must be a number");
//                verifyInputIsInteger(input.nextLine());
//            }
//        } while (restart);
//    }
    }
}


