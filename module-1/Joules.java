/*
 Jess Monnier
 CSD-402 Programming Assignment M1
 23 March 2025
 */

import java.util.Scanner; // Import the Scanner class for user input

public class Joules {
    /* 
     A class to take user input of water mass, starting temperature, 
     and ending temperature and then calculate the Joules required
     to heat the water from the starting to ending temperature.
     */
    public static void main(String[] args) {
        // Welcome message
        System.out.print("\nThis is a program to calculate how many Joules ");
        System.out.print("it would take to heat\nx amount of water from a starting ");
        System.out.print("temperature to an ending temperature.\nYou will be asked ");
        System.out.print("to input values to use for the calculation.\nPlease input ");
        System.out.print("real numbers only, no units, and ensure that\nthe final ");
        System.out.println("temperature is higher than the starting temperature.\n");
        
        // Instantiate a Scanner object to get user input
        Scanner input = new Scanner(System.in);
        
        // Get the mass of the water from the user
        System.out.println("Enter an amount of water in kilograms: ");
        double waterMass = input.nextDouble();

        // Get the starting temperature of the water from the user
        System.out.println("Enter a starting temperature in Celsius: ");
        double initialTemperature = input.nextDouble();

        // Give finalTemperature an initial value lower than initialTemperature
        // to aid in input validation
        double finalTemperature = initialTemperature - 1;

        // Get the ending temperature of the water from the user
        // Use a while loop to ensure the value is greater than the starting temp
        while (initialTemperature >= finalTemperature) {
            System.out.println("Enter an ending temperature in Celsius: ");
            finalTemperature = input.nextDouble();
            if (initialTemperature >= finalTemperature) {
                System.out.print("\nPlease ensure you are entering a value ");
                System.out.println("greater than " + initialTemperature + "\n");
            }
        }

        // Close the Scanner instance
        input.close();

        // Perform the calculation, then format the result since it's often a big number
        double Q = waterMass * (finalTemperature - initialTemperature) * 4184;
        String formattedQ = String.format("%,.2f", Q);

        // Print the output
        System.out.print("\nHeating " + waterMass + "kg of water from ");
        System.out.print(initialTemperature + "°C to " + finalTemperature);
        System.out.println("°C would require "+ formattedQ + " Joules of energy.");
    }
}
