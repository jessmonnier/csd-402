/*
 Jess Monnier
 CSD-402 Module 3 Programming Assignment
 26 March 2025
 A program to create a pyramid of ascending/descending powers of two
 Per assignment, primary purpose seems to be to explore nested for loops
 */

public class PyramidOfSquares {
    public static void main(String[] args) {
        String bottomRow = "1 2 4 8 16 32 64 32 16 8 4 2 1";
        int rowLength = bottomRow.length();
        int maxPower = 6;
        String spaceFormat = "%" + (rowLength - 1)/2 + "s";
        String currentRow = "";
        int nextNum = 0;
        
        // Handle first row
        System.out.printf(spaceFormat, "");
        System.out.print("1");
        System.out.printf(spaceFormat, "");
        System.out.println("   @");

        // For loop to iterate through the powers up to maxPower
        for (int r=1; r < maxPower; r++) {

            // Empty out the currentRow string to prepare for new content
            currentRow = "";

            // For loop to get ascending numbers for row
            for (int i=0; i<r; i++) {
                nextNum = (int) Math.pow(2, i); // cast to int from double
                currentRow += nextNum + " "; // add number & trailing space to row
            }

            // Middle number of current row
            nextNum = (int) Math.pow(2, r);
            currentRow += nextNum + " ";
            
            // For loop to get descending numbers for row
            for (int i=r-1; i>=0; i--) {
                nextNum = (int) Math.pow(2, i);
                currentRow += nextNum + " ";
            }

            // Calculate how much white space will be needed
            spaceFormat = "%" + Math.round((rowLength - currentRow.length())/2) + "s";
            
            // Print beginning white space
            System.out.printf(spaceFormat, "");
            
            // Bc of double-digit numbers sometimes currentRow length is odd;
            // when this occurs we need an extra space up front
            if (currentRow.length()%2 == 1) {
                System.out.print(" ");
            }

            // Print current row, trailing whitespace, & final @
            System.out.print(currentRow);
            System.out.printf(spaceFormat, "");
            System.out.println("  @");
        }
        
        // Handle final row
        System.out.println(bottomRow + "  @");
    }
}
