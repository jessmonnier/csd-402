/*
* Jess Monnier
* CSD-402 Programming Assignment M10 
* 2 May 2025
* A program to use the division classes for a hypothetical company
* with multiple domestic and international divisions
*/

package module_10; // Ensure the compiler can find all components

// Import the classes
import module_10.Division;
import module_10.InternationalDivision;
import module_10.DomesticDivision;

// Create the class to use our other classes
public class UseDivision {
    
    public static void main (String[] args) {
        
        // Welcome message
        System.out.println("\nThis program tests the child classes of an abstract parent class.");
        System.out.println("It will instantiate 4 objects and then use their display methods.\n");
        
        // Instantiate the 4 required objects
        InternationalDivision div1 = new InternationalDivision("Paris Branch", 1000001, "France", "French");
        InternationalDivision div2 = new InternationalDivision("Berlin Branch", 1000002, "Germany", "German");
        DomesticDivision div3 = new DomesticDivision("Toledo Branch", 1000003, "Ohio");
        DomesticDivision div4 = new DomesticDivision("Omaha Branch", 1000004, "Nebraska");

        // Run their display methods
        div1.display();
        System.out.println();
        div2.display();
        System.out.println();
        div3.display();
        System.out.println();
        div4.display();
        System.out.println();
    }
}
