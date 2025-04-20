/*
 Jess Monnier
 CSD-402 Module 4 Programming Assignment
 27 March 2025
 Program to generate arrays of shorts, ints, longs, and doubles,
 then print their values and the average/mean of those values.
 */

// Import this so I don't need to overload the printArray method
import java.lang.reflect.Array;

public class AveragedArrays {
    /*
     Class to generate arrays of shorts, ints, longs, and doubles,
     then print their values and the average/mean of those values.
     */
    public static void main (String[] args) {
        // Use appropriate method to randomize array length & contents
        short[] shorts = shortArray(getLength());
        int[] ints = intArray(getLength());
        long[] longs = longArray(getLength());
        double[] doubles = doubleArray(getLength());

        // Print array contents & average for each array type
        System.out.println("Values in array of shorts: ");
        printArray(shorts);
        System.out.println("Average: " + average(shorts) + "\n");

        System.out.println("Values in array of ints: ");
        printArray(ints);
        System.out.println("Average: " + average(ints) + "\n");

        System.out.println("Values in array of longs: ");
        printArray(longs);
        System.out.println("Average: " + average(longs) + "\n");

        System.out.println("Values in array of doubles: ");
        printArray(doubles);
        System.out.println("Average: " + average(doubles) + "\n");

    }

    // The following four classes return the average in the same type as the array.
    public static short average (short[] array) {
        short total = 0;
        for (short num : array) {
            total += num;
        }
        return (short) (total / array.length);
    }

    public static int average (int[] array) {
        int total = 0;
        for (int num : array) {
            total += num;
        }
        return (int) (total / array.length);
    }

    public static long average (long[] array) {
        long total = 0;
        for (long num : array) {
            total += num;
        }
        return (long) (total / array.length);
    }

    public static double average (double[] array) {
        double total = 0;
        for (double num : array) {
            total += num;
        }
        // Round to two decimal places so it's less obnoxious to look at
        return (double) (Math.round((total / array.length) * 100.0)/100.0);
    }

    // The following four classes create an array of the specified type
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

    public static long[] longArray (int arrayLength) {
        long[] newArray = new long[arrayLength];
        for (int l=0; l<arrayLength; l++) {
            newArray[l] = (long) (Math.random() * 100 + 1);
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

    public static short[] shortArray (int arrayLength) {
        short[] newArray = new short[arrayLength];
        for (int l=0; l<arrayLength; l++) {
            newArray[l] = (short) (Math.random() * 100 + 1);
        }
        return newArray;
    }

    // This method returns an integer between 5 and 10 to use
    // for randomizing array length
    public static int getLength() {
        return (int) (Math.random() * 10 + 5);
    }

    // This method prints the contents of an array as a comma-separated list.
    public static void printArray(Object obj) {
        int arrayLength = Array.getLength(obj) - 1;
        for (int i=0; i<arrayLength; i++) {
            System.out.print(Array.get(obj, i) + ", ");
        }
        System.out.println(Array.get(obj, arrayLength));
    }
}
