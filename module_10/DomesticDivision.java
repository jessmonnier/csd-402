/*
* Jess Monnier
* CSD-402 Programming Assignment M10 
* 2 May 2025
* A program to establish the child class for storing info about domestic 
* divisions of a hypothetical company
*/

package module_10; // Ensure the compiler can find all components

import module_10.Division; // Import parent class

// Create the child class that handles domestic divisions of the company
public class DomesticDivision extends Division {

    // Variables unique to domestic divisions
    private String state;

    // Constructor requiring arguments for all variables
    public DomesticDivision (String divisionName, int accountNumber, String state) {
        super(divisionName, accountNumber);
        this.state = state;
    }

    // Defining the display method for this child class
    @Override
    public void display () {
        System.out.println("Division Name: " + getDivisionName());
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("State: " + this.state);
    }

    // Getters
    public String getState () {
        return this.state;
    }

    // Setters
    public void setState (String state) {
        this.state = state;
    }
}
