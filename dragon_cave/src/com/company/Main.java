package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("You are in a land full of dragons. In front of you, " +
                "\nyou see two caves. In one cave, the dragon is friendly " +
                "\nand will share his treasure with you. The other dragon is greedy and hungry and will eat you on sight.");

        Scanner pick = new Scanner(System.in);
        System.out.println("Which can will go into? (1 or 2)");

        try {
            checkUserInput(pick.nextInt(), pick);
        } catch (Exception e) {
            System.out.println("A problem occurred: User Entry Not Accepted ");
        }

    }

    static void checkUserInput(int choose, Scanner pick)  {
        while(choose != 1 && choose != 2){
            System.out.println("Must choose either 1 or 2");
            choose = pick.nextInt();
        }
            if (choose == 1) {
                System.out.println("You approach the cave...\n" +
                        "It is dark and spooky...\n" +
                        "A large dragon jumps out in front of you! He opens his jaws\n" +
                        "and...\n" +
                        "Gobbles you down in one bite!");
            } else{
                System.out.println("Friendly dragon!\nHe shares his treasures with you!");
            }
        }
    }



