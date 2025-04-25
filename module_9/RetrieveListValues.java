/*
 * Jess Monnier
 * CSD-402 Programming Assignment M9 Program 1
 * 23 April 2025
 * A program to list strings from an ArrayList and allow the user
 * to select which one to display again, with error handling.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class RetrieveListValues {
    
    public static void main (String[] args) {

        // Set up the Scanner for flow control and user input
        Scanner input = new Scanner(System.in);
        
        // Initialize and build the array
        ArrayList<String> somePoetry = new ArrayList<>();
        somePoetry.add("Eyes open on a scarlet dawn");
        somePoetry.add("The heart beats fresh and new");
        somePoetry.add("The battle won for this new hope");
        somePoetry.add("It takes in the lovely view");
        somePoetry.add("The landscape of the soul is battered");
        somePoetry.add("But beauty reigns there still");
        somePoetry.add("The victor stands and takes it in");
        somePoetry.add("Silent testament to will");
        somePoetry.add("Old faith and lies a tyranny");
        somePoetry.add("Quickly though painfully broken");
        somePoetry.add("Cast down, disgraced, to silent death");
        somePoetry.add("No piece is left as token");
        somePoetry.add("Love laughs at the memory");
        somePoetry.add("Offers gentle reprimand");
        somePoetry.add("How could I miss the workings");
        somePoetry.add("Of Hate’s insidious hand?");
        somePoetry.add("But now the battle has been won");
        somePoetry.add("I’ve nothing left to fear");
        somePoetry.add("Yet streaking down my faithless cheek:");
        somePoetry.add("One single mourning tear");

        // Greeting
        System.out.println("\nPlease enjoy and/or cringe over this melodramatic poem I wrote as a teen.");
        System.out.println("Press Enter to print the poem.");
        input.nextLine();
        System.out.println("\nDoubtful Acceptance by Jess Monnier");
        
        // For loop to print the poem, with line numbers
        for (int i=0; i<somePoetry.size(); i++) {
            System.out.println((i+1) + " - " + somePoetry.get(i));
        }

        // Ask if they want to reread any line numbers; make verse initial value -1
        int verse = -1;
        String nextInput;
        System.out.println("\nIf there are any verse numbers you would like to revisit, enter the number below. Enter 0 to quit.");

        // While loop to keep going until they enter 0
        while (verse != 0) {
            nextInput = input.nextLine();
            
            // First try converting the user input to an integer; if that fails, print an error message & start loop over
            try {
                verse = Integer.parseInt(nextInput);
            } catch (Exception e) {
                System.out.println("The value you entered was not an integer! Please try again.");
                continue;
            }
            
            // Next try to retrieve the value at the index entered for printing (verse - 1 to get actual index)
            // If that fails, print out of bounds error message
            try {
                if (verse != 0) {
                    System.out.println(somePoetry.get(verse-1));
                }
            } catch (Exception e) {
                System.out.println("The value you entered was Out of Bounds. Please try again.");
                continue;
            }

            // Say goodbye if they entered 0
            if (verse == 0) {
                System.out.println("\nCool, thanks for stopping by!");
                input.close();
            }
        }
    }
}
