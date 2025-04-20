/*
 Jess Monnier
 CSD-402 Programming Assignment 6
 20 April 2025
 A program to demonstrate the functionality of a collection
 of objects created from a custom Class
 */

package module_7;
import module_6.Fan;
import java.util.Scanner;

public class UseFans {

    // Create some constants to pull random values from
    public static final String[] COLORS = {"silver", "black", "white", "blue", "purple", "red"};
    public static final double maxRadius = 12;
    public static final double minRadius = 3;

    public static void main(String[] args) {

        // Greeting
        System.out.println("\nThis script will create a collection of 3 fans and display their properties.\n");
        
        // Call our methods to test out displaying a collection of three fans
        displayFans(newCollection(3));
    }

    public static void displayFans(Fan[] fanCollection) {

        // Go through the array and send each fan to displayFan()
        for (int i=0; i<fanCollection.length; i++) {
            displayFan(fanCollection[i]);
        }
    }

    public static void displayFan(Fan currentFan) {

        // Set up scanner for flow control purposes
        Scanner flowControl = new Scanner(System.in);

        // Display the characteristics of the fan
        System.out.println("\nPress enter to view the properties of Fan " + currentFan.getName() + "...");
        System.out.print("> ");
        flowControl.nextLine();
        System.out.println();
        System.out.println("Color: " + currentFan.getColor());
        System.out.println("Radius: " + currentFan.getRadius() + " inches");
        System.out.println("Status: " + currentFan.getStatus());
    }

    public static Fan[] newCollection(int num) {
        
        // Create an empty Fan array of the correct length
        Fan[] fanCollection = new Fan[num];

        // Add a fan at each index
        for (int i=0; i<num; i++) {
            fanCollection[i] = new Fan((short) 1, randomSpeed(), randomPower(), randomRadius(), randomColor());
            System.out.println();
        }
        return fanCollection;
    }

    // The following methods help randomize the fan attributes
    public static int randomSpeed() {
        // Return an integer in the 0-3 range at random to serve as speed
        return (int) (Math.random() * 4);
    }

    public static double randomRadius() {
        // Return a double between the min and max radius constants, rounded to 1 decimal place
        return Math.round((Math.random() * (maxRadius-minRadius) + minRadius)*10.0)/10.0;
    }

    public static boolean randomPower() {
        // Give the fan about a 75% chance of being on
        boolean on;
        if (Math.random() >= 0.75) {
            on = false;
        } else {
            on = true;
        }
        return on;
    }

    public static String randomColor() {
        // Return one of the strings in COLORS by index at random
        return COLORS[(int) (Math.random() * COLORS.length)];
    }
}
