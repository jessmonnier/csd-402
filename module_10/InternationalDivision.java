/*
* Jess Monnier
* CSD-402 Programming Assignment M10 
* 2 May 2025
* A program to establish the child class for storing info about international 
* divisions of a hypothetical company
*/

package module_10; // Ensure the compiler can find all components

import module_10.Division; // Import parent class

// Create the child class that handles international divisions of the company
public class InternationalDivision extends Division {
    
    // variables unique to international divisions
    private String country;
    private String language;

    // Constructor requiring arguments for all variables
    public InternationalDivision (String divisionName, int accountNumber, String country, String language) {
        super(divisionName, accountNumber);
        this.country = country;
        this.language = language;
    }

    // Defining the display method for this child class
    @Override
    public void display () {
        System.out.println("Division Name: " + getDivisionName());
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Country: " + this.country);
        System.out.println("Primary Language: " + this.language);
    }

    // Getters
    public String getCountry () {
        return this.country;
    }
    public String getLanguage () {
        return this.language;
    }

    // Setters
    public void setCountry (String country) {
        this.country = country;
    }
    public void setLanguage (String language) {
        this.language = language;
    }
}
