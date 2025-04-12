/*
 Jess Monnier
 CSD-402 Module 5 Programming Assignment
 11 April 2025
 Program to return the indices of the largest and smallest
 values (left-most, if there are duplicates) in nested arrays.
 */
import java.util.Arrays; // to make printing the arrays easy
import java.util.Scanner; // for flow control

public class MinMaxArrays {
    /*
     Program to return the indices of the largest and smallest
     values (left-most, if there are duplicates) in nested arrays.
     */
    
    public static void main (String[] args) {
        System.out.println("""

This program tests methods to find the position of the largest and smallest
values in nested arrays. The arrays are randomly generated, so feel free to run
the program multiple times. Nested arrays of doubles will be tested three times, 
followed by three nested arrays of integers.

As a reminder, array positional parameters start at 0, so [1,2] would refer 
to the 3rd value in the 2nd array.""");

        Scanner flowControl = new Scanner(System.in);
        
        // Tests of nested double arrays
        System.out.print("\nPress enter to continue > ");
        flowControl.nextLine();
        System.out.println("\n\n*** TEST ONE: NESTED DOUBLE ARRAY ***\n");
        testArrays(nestedDoubleArray(getLength(2, 5), getLength(2, 8)));
        System.out.print("\nPress enter to continue > ");
        flowControl.nextLine();
        System.out.println("\n\n*** TEST TWO: NESTED DOUBLE ARRAY ***\n");
        testArrays(nestedDoubleArray(getLength(2, 5), getLength(2, 8)));
        System.out.print("\nPress enter to continue > ");
        flowControl.nextLine();
        System.out.println("\n\n*** TEST THREE: NESTED DOUBLE ARRAY ***\n");
        testArrays(nestedDoubleArray(getLength(2, 5), getLength(2, 8)));

        // Tests of nested integer arrays
        System.out.print("\nPress enter to continue > ");
        flowControl.nextLine();
        System.out.println("\n\n*** TEST ONE: NESTED INTEGER ARRAY ***\n");
        testArrays(nestedIntArray(getLength(2, 5), getLength(2, 8)));
        System.out.print("\nPress enter to continue > ");
        flowControl.nextLine();
        System.out.println("\n\n*** TEST TWO: NESTED INTEGER ARRAY ***\n");
        testArrays(nestedIntArray(getLength(2, 5), getLength(2, 8)));
        System.out.print("\nPress enter to continue > ");
        flowControl.nextLine();
        System.out.println("\n\n*** TEST THREE: NESTED INTEGER ARRAY ***\n");
        testArrays(nestedIntArray(getLength(2, 5), getLength(2, 8)));
        
    }

    public static void testArrays(double[][] testArray) {
        int[] position = new int[2];
        
        System.out.println("Nested array:");
        
        // Use the Arrays.deepToString method but, with replace, make the format a little more friendly.
        System.out.println(
            Arrays.deepToString(testArray).replace("[[","[\n[").replace("]]","]\n]").replace("], ","],\n")
            );
        System.out.println("\nTest finding the max value's position:");
        position = locateLargest(testArray);
        System.out.print(Arrays.toString(position) + " - value: ");
        System.out.println(testArray[position[0]][position[1]]);
        System.out.println("\nTest finding the min value's position:");
        position = locateSmallest(testArray);
        System.out.print(Arrays.toString(position) + " - value: ");
        System.out.println(testArray[position[0]][position[1]]);
    }

    public static void testArrays(int[][] testArray) {
        int[] position = new int[2];
        
        System.out.println("Nested array:");
        System.out.println(
            Arrays.deepToString(testArray).replace("[[","[\n[").replace("]]","]\n]").replace("], ","],\n")
            );
        System.out.println("Test finding the max value's position:");
        position = locateLargest(testArray);
        System.out.print(Arrays.toString(position) + " - value: ");
        System.out.println(testArray[position[0]][position[1]]);
        System.out.println("Test finding the min value's position:");
        position = locateSmallest(testArray);
        System.out.print(Arrays.toString(position) + " - value: ");
        System.out.println(testArray[position[0]][position[1]]);
    }

    // This method returns an integer between minParam and maxParam 
    // to use for randomizing array length
    public static int getLength(int minParam, int maxParam) {
        return (int) (Math.random() * maxParam + minParam);
    }

    // The following two methods create an array of the specified type
    // with the length being determined by the passed parameter and the
    // values randomized between 1 and 100.
    public static double[] doubleArray (int arrayLength) {
        double[] newArray = new double[arrayLength];
        for (int l=0; l<arrayLength; l++) {
            // Round to two decimal places so it's less obnoxious to look at
            newArray[l] = Math.round((Math.random() * 100 + 1)*100.0)/100.0;
        }
        return newArray;
    }

    public static int[] intArray (int arrayLength) {
        int[] newArray = new int[arrayLength];
        for (int l=0; l<arrayLength; l++) {
            newArray[l] = (int) (Math.random() * 100 + 1);
        }
        return newArray;
    }

    // The following two methods create nested arrays of the length specified
    // by the numArrays parameter using the above two parameters to further
    // randomize the subarrays.
    public static double[][] nestedDoubleArray (int numArrays, int subLength) {
        double[][] newParentArray = new double[numArrays][subLength];
        for (int i=0; i<numArrays; i++) {
            newParentArray[i] = doubleArray(subLength);
        }
        return newParentArray;
    }
    
    public static int[][] nestedIntArray (int numArrays, int subLength) {
        int[][] newParentArray = new int[numArrays][subLength];
        for (int i=0; i<numArrays; i++) {
            newParentArray[i] = intArray(subLength);
        }
        return newParentArray;
    }

    // The following two methods locate the nested indices of the largest
    // number in all nested arrays. If there are duplicates, the left-most
    // of the duplicate max values will be returned.
    public static int[] locateLargest (double[][] arrayParam) {
        int[] returnArray = {0, 0};
        double maxDouble = arrayParam[0][0];
        for (int i=0; i<arrayParam.length; i++) {
            for (int j=0; j<arrayParam[i].length; j++) {
                if (arrayParam[i][j] > maxDouble) {
                    maxDouble = arrayParam[i][j];
                    returnArray[0] = i;
                    returnArray[1] = j;
                }
            }
        }
        return returnArray;
    }

    public static int[] locateLargest (int[][] arrayParam) {
        int[] returnArray = {0, 0};
        int maxInt = arrayParam[0][0];
        for (int i=0; i<arrayParam.length; i++) {
            for (int j=0; j<arrayParam[i].length; j++) {
                if (arrayParam[i][j] > maxInt) {
                    maxInt = arrayParam[i][j];
                    returnArray[0] = i;
                    returnArray[1] = j;
                }
            }
        }
        return returnArray;
    }

    // The following two methods locate the nested indices of the smallest
    // number in all nested arrays. If there are duplicates, the left-most
    // of the duplicate min values will be returned.
    public static int[] locateSmallest (double[][] arrayParam) {
        int[] returnArray = {0, 0};
        double minDouble = arrayParam[0][0];
        for (int i=0; i<arrayParam.length; i++) {
            for (int j=0; j<arrayParam[i].length; j++) {
                if (arrayParam[i][j] < minDouble) {
                    minDouble = arrayParam[i][j];
                    returnArray[0] = i;
                    returnArray[1] = j;
                }
            }
        }
        return returnArray;
    }

    public static int[] locateSmallest (int[][] arrayParam) {
        int[] returnArray = {0, 0};
        int minInt = arrayParam[0][0];
        for (int i=0; i<arrayParam.length; i++) {
            for (int j=0; j<arrayParam[i].length; j++) {
                if (arrayParam[i][j] < minInt) {
                    minInt = arrayParam[i][j];
                    returnArray[0] = i;
                    returnArray[1] = j;
                }
            }
        }
        return returnArray;
    }
}
