/*
 * Jess Monnier
 * CSD-402 Programming Assignment M8
 * 23 April 2025
 * A program to find the greatest number in a list
 * of numbers input by the user.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class JessArrayListTest {
    
    public static void main (String[] args) {
        
        // Greeting text
        System.out.println("\nThis program will find the highest value of a list of integers you enter.");
        System.out.println("Please enter integers by pressing Enter between each. Enter 0 to finalize the list.");
        
        // Get the max by calling the max method with an argument of the buildArray method
        // Save the max value as a variable that can be used in our final output string
        Integer max = max(buildArray());
        System.out.println();
        System.out.println("Great! Of the numbers you entered, " + max + " has the highest value.");
    }

    // Method to build the ArrayList using user input
    public static ArrayList<Integer> buildArray () {
        
        // Establish the variables we'll need
        String nextInput;
        Integer nextNum;
        boolean keepGoing = true;
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        // While loop that hinges on boolean value of keepGoing
        while (keepGoing) {
            
            // Grab the next line of user input
            nextInput = input.nextLine();

            try {
                // Try parsing the input value as an Integer and adding to Array List
                nextNum = Integer.parseInt(nextInput);
                list.add(nextNum);
            } catch (NumberFormatException e) {
                // In the event the user did not input an integer, that's okay, 
                // just restart while loop and keep going
                continue;
            }
            
            // A value of 0 means stop, so if we get that, set keepGoing to false to break loop
            if (nextNum == 0) {
                keepGoing = false;
            }
        }

        // Close the Scanner resource and return the ArrayList
        input.close();
        return list;
    }

    // Method to find the max value
    public static Integer max (ArrayList<Integer> list) {
        
        // Make the initial value of max the first value in the ArrayList
        Integer max = list.get(0);

        // For remaining objects in list, if they're bigger than max, update max to that value
        for (int i=1; i<list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }

        // Return max
        return max;
    }

}