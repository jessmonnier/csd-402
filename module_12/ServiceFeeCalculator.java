/*
 * Jess Monnier
 * CSD-402 Module 12 Programming Assignment
 * 18 May 2025
 * A program to calculate the fee for annual vehicle service with
 * that particular method overloaded to account for different fees/discounts
 */

import java.util.Scanner;

public class ServiceFeeCalculator {
    
    // Set the standard fee
    private static double standardCharge = 49.99;
    
    public static void main(String[] args) {
        
        // Set up Scanner for flow control & some test variables
        Scanner input = new Scanner(System.in);
        double oilFeeOne = 14.99;
        double oilFeeTwo = 18.99;
        double tireFeeOne = 32.49;
        double tireFeeTwo = 29.99;
        double couponOne = 14.99;
        double couponTwo = 10;

        // Welcome message
        System.out.println("\nWelcome to the test program for the Fake Jiffy Lube Service Calculator.\n");
        
        // Using a Scanner for flow control, run the first pair of tests
        System.out.print("\nPress Enter to test the yearlyService() method with no arguments\n>");
        input.nextLine();
        System.out.println();
        System.out.println("yearlyService() test 1 with no arguments: $" + yearlyService());
        System.out.println("yearlyService() test 2 with no arguments: $" + yearlyService());

        // Using a Scanner for flow control, run the second pair of tests
        System.out.print("\nPress Enter to test the yearlyService() method with 1 argument\n>");
        input.nextLine();
        System.out.println();
        System.out.println("yearlyService() test 1 with oil change fee of $" + oilFeeOne + ": $" + yearlyService(oilFeeOne));
        System.out.println("yearlyService() test 2 with oil change fee of $" + oilFeeTwo + ": $" + yearlyService(oilFeeTwo));

        // Using a Scanner for flow control, run the third pair of tests
        System.out.print("\nPress Enter to test the yearlyService() method with 2 arguments\n>");
        input.nextLine();
        System.out.println();
        System.out.println("yearlyService() test 1 with oil change fee of $" + oilFeeOne + 
        " and tire rotation fee of $" + tireFeeOne + ": $" + yearlyService(oilFeeOne, tireFeeOne));
        System.out.println("yearlyService() test 2 with oil change fee of $" + oilFeeTwo + 
        " and tire rotation fee of $" + tireFeeTwo + ": $" + yearlyService(oilFeeOne, tireFeeTwo));

        // Using a Scanner for flow control, run the final pair of tests
        System.out.print("\nPress Enter to test the yearlyService() method with 3 arguments\n>");
        input.nextLine();
        System.out.println();
        System.out.println("yearlyService() test 1 with oil change fee of $" + oilFeeOne + 
        ", tire rotation fee of $" + tireFeeOne + ", and coupon discount of $" + couponOne + 
        ": $" + yearlyService(oilFeeOne, tireFeeOne, couponOne));
        System.out.println("yearlyService() test 2 with oil change fee of $" + oilFeeTwo + 
        ", tire rotation fee of $" + tireFeeTwo + ", and coupon discount of $" + couponTwo +  
        ": $" + yearlyService(oilFeeOne, tireFeeTwo, couponTwo));

        // Exit message
        System.out.print("\nTests concluded. Please press Enter to exit\n>");
        input.nextLine();
        System.out.println();
    }

    // The overloaded yearlyService methods follow
    public static double yearlyService() {
        return standardCharge;
    }

    public static double yearlyService(double oilChangeFee) {
        return standardCharge + oilChangeFee;
    }

    public static double yearlyService(double oilChangeFee, double tireRotationFee) {
        return standardCharge + oilChangeFee + tireRotationFee;
    }

    public static double yearlyService(double oilChangeFee, double tireRotationFee, double couponAmount) {
        return standardCharge + oilChangeFee + tireRotationFee - couponAmount;
    }
}