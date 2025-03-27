/*
 Jess Monnier
 CSD-402 Module 2 Programming Assignment
 26 March 2025
 A program to allow a user to play Rock Paper Scissors vs. the "computer"
 */

 // Import the Random class for more precise randomization than Math.random
 import java.util.Random;
 // Import the Scanner class for user input
 import java.util.Scanner; 

public class RockPaperScissors {
    public static void main(String[] args) {
        // Set up our imported classes
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        // This will allow for a while loop for multiple rounds
        boolean playAgain = true;
        // These will track the wins for the "computer" and user
        int pcWins = 0;
        int userWins = 0;
        // Initial userChoice and pcChoice variables
        int pcChoice = 0;
        int userChoice = 0;
        int userContinue = 1;
        // Create an array to make "weapon" conversion easier
        String[] weapons = {"None", "Rock", "Paper", "Scissors"};

        // Welcome message
        System.out.print("\nWelcome to Rock Paper Scissors! Time to see who's ");
        System.out.print("superior, (wo)man or machine!\nTo play, please input ");
        System.out.println("1, 2, or 3 to select your weapon:");
        System.out.println("1: Rock");
        System.out.println("2: Paper");
        System.out.println("3: Scissors");
        System.out.print("Remember, Rock beats Scissors, Scissors beat Paper, ");
        System.out.println("and Paper beats Rock.");
        System.out.print("After each round, you will be given a chance to ");
        System.out.println("keep playing or quit. Good luck!");

        while (playAgain) {
            // Get a random integer between 1 & 3 inclusive; it starts with 0
            // but we get around this by adding 1
            pcChoice = rand.nextInt(3) + 1;
            System.out.print("\nChoose your weapon: ");
            
            // Save the next integer the user submits as userChoice
            userChoice = input.nextInt();

            // Check for a draw; use position in array to retrieve for system output
            if (userChoice == pcChoice) {
                System.out.println("Draw! You both chose " + weapons[userChoice]);
            
            // Non-draw outcomes for user choosing rock
            } else if (userChoice == 1) {
                if (pcChoice == 2) {
                    pcWins += 1;
                    System.out.println("Computer's Paper beats your Rock!");
                } else {
                    userWins += 1;
                    System.out.println("Your Rock beats computer's Scissors!");
                }
            
            // Non-draw outcomes for user choosing paper
            } else if (userChoice == 2) {
                if (pcChoice == 1) {
                    userWins += 1;
                    System.out.println("Your Paper beats computer's Rock!");
                } else {
                    pcWins += 1;
                    System.out.println("Computer's Scissors beat your Paper!");
                }
            
            // Non-draw outcomes for user choosing scissors
            } else if (userChoice == 3) {
                if (pcChoice == 1) {
                    userWins += 1;
                    System.out.println("Your Scissors beat computer's Paper!");
                } else {
                    pcWins += 1;
                    System.out.println("Computer's Rock beats your Scissors!");
                }
            
            // Feedback if user inputs invalid integer
            } else {
                System.out.print("Your input was invalid. Remember, it's 1 for ");
                System.out.println("Rock, 2 for Paper, and 3 for Scissors.");
                System.out.println("You may try again or quit.");
            }
            
            // Print the current score, give the user an option to continue
            System.out.println("SCORE: Computer " + pcWins + " - User " + userWins);
            System.out.print("\nKeep going? Enter 0 for no, any other number for yes: ");
            userContinue = input.nextInt();
            
            // If user inputs 0, set playAgain to false to end loop, close input variable.
            if (userContinue == 0) {
                playAgain = false;
                input.close();
            }
        }
    }
}
