/*
* Jess Monnier
* CSD-402 Programming Assignment M9 Program 2
* 24 April 2025
* A program to create, write to, and read from a data file.
*/

// Import all needed libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileHandler {
    
    public static void main (String[] args) {

        // Set some initial variables & a Scanner for flow control
        String fileName = "data.file";
        int listLength = 10;
        Scanner input = new Scanner(System.in);

        // Greeting & flow control
        System.out.println("\nThis program will allow you to write 10 random integers to " +
                            fileName);
        System.out.println("If the file exists, it will give you the option to append the new ");
        System.out.print("numbers or quit. Press enter to begin...\n> ");
        input.nextLine();

        // Call the createFile method with the variables established earlier
        createFile(fileName, listLength);

        // After the create/write steps are done, display the file contents
        System.out.println("\n The full contents of " + fileName + " are: \n");
        readFile(fileName);
        input.close();
    }

    // Method to generate an array of random integers, length determined by passed argument
    public static int[] generateNumbers (int listLength) {
        
        int[] list = new int[listLength];

        for (int i=0; i<listLength; i++) {
            list[i] = (int) (Math.random()*100 + 1);
        }

        return list;
    }

    // Method to create the file or, if it already exists, give the user the choice of
    // adding the random numbers to it or canceling.
    public static void createFile (String fileName, int listLength) {

        // Try with a resource so it will auto-close when the try-catch is complete
        try (Scanner input = new Scanner(System.in)) {

            // Create the file object with the passed fileName argument
            File newFile = new File(fileName);
            
            // If a new file was created, print an info message; otherwise ask how they want to proceed
            if (newFile.createNewFile()) {
                System.out.println("Successfully created " + newFile.getName());
            } else {
                char answer;
                
                // Ask the user if they want to continue or cancel; take first character of their response
                System.out.println("\n" + newFile.getName() + " already exists. Do you want to add data to it or cancel?");
                System.out.print("Enter y to add the data or n to cancel:\n> ");
                answer = input.nextLine().toLowerCase().trim().charAt(0);

                // Check if that first character was y for yes; if so send the arguments to generateNumbers and writeFile
                // methods, if not print an info message that nothing will be added to the file
                if (answer == 'y') {
                    writeFile(generateNumbers(listLength), fileName);
                } else {
                        System.out.println("\nOkay, no new numbers will be added!");
                }
            }
        } catch (IOException e) {
            
            // Print error message and the traceback for the error
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    // Method to write to the file
    public static void writeFile (int[] list, String fileName) {

        // Try-catch block with the resource included so it will auto-close
        try (FileWriter writer = new FileWriter(fileName, true)) {

            // Iterate through the numbers in the passed list & write each to file with a trailing space
            for (int i : list) {
                writer.write(i + " ");
            }

            // Let the user know it was successful
            System.out.println("Successfully wrote a new list of numbers to " + fileName);
        } catch (IOException e) {

            // Print error message and the traceback for the error
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Method to read/display the file contents given its name as an argument
    public static void readFile (String fileName) {

        // try-catch block in case the read goes wrong
        try {
            
            // Set up the file and Scanner instance to read it
            File currentFile = new File(fileName); 
            Scanner reader = new Scanner(currentFile);

            // Our file will only have one line, but shrug. While loop to get all contents.
            while (reader.hasNextLine()) {
                
                // Get and print the file contents
                String content = reader.nextLine();
                System.out.println(content);
            }
        } catch (FileNotFoundException e) {

            // Print error message and the traceback for the error
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}