/*
* Jess Monnier
* CSD-402 Programming Assignment M10 
* 2 May 2025
* A program to establish the abstract parent class
* for other classes to be used in this assignment
*/

package module_10; // Ensure the compiler can find all components

import java.util.HashMap; // Import hashmap for storing account number/name pairs

// Make the abstract class & display method
public abstract class Division {
    
    // Set up the common variables for the class
    private String divisionName;
    private int accountNumber;
    public static HashMap<Integer, String> accountList = new HashMap<>();

    // Constructor for the class
    public Division (String divisionName, int accountNumber) {
        this.divisionName = divisionName;
        
        // Try-throw-catch block to ensure the account number is unique
        try {
            if (accountList.containsKey(accountNumber)) {
                throw new IllegalArgumentException("This account number already exists. Account numbers must be unique.");
            } else {
                this.accountNumber = accountNumber;
                accountList.put(accountNumber, divisionName);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Caught an exception: " + e.getMessage());
        }
    }

    // Getters
    public String getDivisionName () {
        return this.divisionName;
    }
    public int getAccountNumber () {
        return this.accountNumber;
    }

    // Setters
    public void setDivisionName (String divisionName) {
        this.divisionName = divisionName;
    }
    public void setAccountNumber (int accountNumber) {
        try {
            if (accountList.containsKey(accountNumber)) {
                throw new IllegalArgumentException("This account number already exists. Account numbers must be unique.");
            } else {
                this.accountNumber = accountNumber;
                accountList.put(accountNumber, divisionName);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Caught an exception: " + e.getMessage());
        }
    }

    // Abstract display method to be defined in child classes
    public abstract void display ();
}