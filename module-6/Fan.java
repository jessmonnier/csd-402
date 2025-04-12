/*
 Jess Monnier
 CSD-402 Programming Assignment 6
 11 April 2025
 A program emulating a fan, including setting the speed,
 color, radius, and whether it is on.
 */
import java.util.Scanner; // for flow control

 public class Fan {
    /*
     A class emulating a fan, including setting its speed, 
     color, radius, and whether it is on.
     */
    
    // Constants
    int STOPPED = 0;
    int SLOW = 1;
    int MEDIUM = 2;
    int FAST = 3;
    short QUIET = 0;
    short HELP = 1;
    
    // Create the private class variables
    private short mode;
    private int speed;
    private boolean on;
    private double radius;
    private String color;
    private char name = '0';
    
    // Main class, where tests of the fan class will occur
    public static void main(String[] args) {
        
        // Set up scanner for flow control purposes
        Scanner flowControl = new Scanner(System.in);

        // Redo constants because they can't be accessed in a static method SIGH
        int STOPPED = 0;
        int SLOW = 1;
        int MEDIUM = 2;
        int FAST = 3;
        short QUIET = 0;
        short HELP = 1;

        // Greeting & initial flow control (let user press enter between steps)
        System.out.println("\nWe will be running some tests instantiating three fan objects.");
        System.out.println("Please press Enter to continue...");
        System.out.print("> ");
        flowControl.nextLine();
        System.out.println("\n");

        // Instantiate the three test fan objects
        Fan fanOne = new Fan();
        System.out.println();
        Fan fanTwo = new Fan(MEDIUM, true, 8.5, "black");
        System.out.println();
        Fan fanThree = new Fan(STOPPED, false, 4.2, "blue");
        
        // Initial test of toString method
        System.out.println("\nPress enter to print the base object (toString method)...");
        System.out.print("> ");
        flowControl.nextLine();
        System.out.println("\n");
        System.out.println(fanOne);
        System.out.println(fanTwo);
        System.out.println(fanThree);

        // Use the setters
        System.out.println("\nPress enter to test the setters...");
        System.out.print("> ");
        flowControl.nextLine();
        System.out.println("\n");
        fanOne.setColor("purple");
        fanTwo.setPower(false);
        fanThree.setRadius(12);
        fanOne.setSpeed(FAST);
        fanTwo.setMode(QUIET);
        fanThree.setPower(true);
        fanOne.setRadius(9);
        fanTwo.setColor("pink");
        fanThree.setColor("silver");

        // Use the getters
        System.out.println("\nPress enter to test the getters...");
        System.out.print("> ");
        flowControl.nextLine();
        System.out.println("\n");
        System.out.println("Fan " + fanOne.getName() + "'s color is " + fanOne.getColor() + ".");
        System.out.println("Fan " + fanTwo.getName() + "'s color is " + fanTwo.getColor() + ".");
        System.out.println("Fan " + fanThree.getName() + "'s color is " + fanThree.getColor() + ".");
        System.out.println("Fan " + fanOne.getName() + "'s radius is " + fanOne.getRadius() + " inches.");
        System.out.println("Fan " + fanTwo.getName() + "'s speed is " + fanTwo.getSpeed() + ".");
        System.out.println("Fan " + fanThree.getName() + " is on: " + fanThree.getPower() + ".");

        // Final run of toString method
        System.out.println("\nPress enter to do a final print of each base object...");
        System.out.print("> ");
        flowControl.nextLine();
        System.out.println("\n");
        System.out.println(fanOne);
        System.out.println(fanTwo);
        System.out.println(fanThree);

        flowControl.close();
    }
    
    // constructor that uses purely defaults
    public Fan () {
        mode = HELP;
        speed = STOPPED;
        on = true;
        radius = 6;
        color = "white";
        name = getAssignedChar();
        System.out.println("Fan " + name + " has been initialized in help mode.\n" + 
                        "Use setMode(QUIET); to turn off info messages.");
    }

    // full constructor (except name, which is set through user input each time)
    public Fan (short myMode, int mySpeed, boolean myPower, double myRadius, String myColor) {
        mode = myMode;
        speed = mySpeed;
        on = myPower;
        radius = myRadius;
        color = myColor;
        name = getAssignedChar();
        if (myMode == HELP) {
            System.out.println("Fan " + name + " has been initialized in help mode.\n" + 
                            "Use setMode(QUIET); to turn off info messages.");
        }
    }
    
    // constructor to set all but help mode with arguments
    public Fan (int mySpeed, boolean myPower, double myRadius, String myColor) {
        mode = HELP;
        speed = mySpeed;
        on = myPower;
        radius = myRadius;
        color = myColor;
        name = getAssignedChar();
        System.out.println("Fan " + name + " has been initialized in help mode.\n" + 
                        "Use setMode(QUIET); to turn off info messages.");
    }

    // constructor to set all but help mode and radius with arguments
    public Fan (int mySpeed, boolean myPower, String myColor) {
        mode = HELP;
        speed = mySpeed;
        on = myPower;
        color = myColor;
        name = getAssignedChar();
        System.out.println("Fan " + name + " has been initialized in help mode.\n" + 
                        "Use setMode(QUIET); to turn off info messages.");
    }

    // use this method to get user input on a single character designator for a new fan object
    // this is only used in the methods that instantiate the fan object
    public char getAssignedChar() {
        
        // I learned that closing the Scanner instance in a scenario like this causes errors;
        // after the first use, it doesn't actually grab more input. So I left it open.
        Scanner input = new Scanner(System.in);
        char result;
        System.out.println("Please enter a 1-character designation for this fan:");
        System.out.print("> ");
        
        // Using trim prevents most potential errors, although a user could just press Enter
        // and cause this to error out still. I elected not to put in error handling because
        // this is already overboard compared to what was assigned.
        result = input.nextLine().trim().charAt(0);
        System.out.println();
        return result;
    }
    
    // determine what is output when the object itself is printed
    public String toString () {
        String description = "";
        String speedText = getSpeed();
        
        // if fan is on and not stopped, print its speed & other characteristics
        // if it's on and stopped, basically say that's weird & print other characteristics
        // else print fan isn't running, characteristics, and how to start it.
        if (on && speed > STOPPED) {            
            description = "Fan " + name + " is a " + color + " fan running at " +
            speedText + " speed. Its radius is " + radius + " inches.\n";
        } else if (on) {
            description = "Fan " + name + " is a " + color + " fan set to on but " +
            "it isn't running... \nMight need to send it in for maintenance!" + 
            " It has a radius of " + radius + " inches.\n";
        } else {
            description = "Fan " + name + " is " + color + " and is currently off. Use " +
            "setPower(true); to turn it on.\n" +
            "Its radius is " + radius + " inches.\n";
        }
        return description;
    }

    // The setters and getters follow. They're pretty straightforward. Each setter has an
    // info/confirmation message that prints if help mode is on. setSpeed and setPower
    // have "warning" messages if it's set to on and stopped.
    public void setSpeed (int newSpeed) {
        speed = newSpeed;
        if (on && speed == STOPPED && mode == HELP) {
            System.out.println("Fan " + name + "'s speed has been set, but be aware that it " + 
            "is set to on with a speed of 0/stopped, \n   so it will be treated as off.");
        } else if (mode == HELP) {
            System.out.println("Fan " + name + "'s new speed is " + getSpeed() + ".");
        }
    }

    // This is the only getter that returns a different type than it's actually stored.
    // Wanted to make it more user-friendly to look at. This is also used in other methods.
    public String getSpeed () {
        String speedText = "";
        switch (speed) {
            case 0:
                speedText = "stopped";
            case 1:
                speedText = "slow";
            case 2:
                speedText = "medium";
            default:
                speedText = "fast";
        }
        return speedText;
    }

    public void setPower (boolean newPower) {
        on = newPower;
        if (on && speed == STOPPED && mode == HELP) {
            System.out.println("Although you set fan " + name + " to on, " + 
            "its speed is 'stopped,'\n   so it will be treated as off.");
        } else if (mode == HELP) {
            System.out.println("Fan " + name + " has been turned on.");
        }
    }

    public boolean getPower () {
        return on;
    }

    public void setRadius (double newRadius) {
        radius = newRadius;
        if (mode == HELP) {
            System.out.println("Fan " + name + "'s new radius is " + radius + " inches.");
        }
    }

    public double getRadius () {
        return radius;
    }

    public void setColor (String newColor) {
        color = newColor;
        if (mode == HELP) {
            System.out.println("Fan " + name +  "'s new color is " + color + ".");
        }
    }

    public String getColor () {
        return color;
    }

    public void setMode (short newMode) {
        mode = newMode;
        if (mode == HELP) {
            System.out.println("You've set fan " + name + " to help mode!");
        } else {
            System.out.println("You've disabled help mode. Now only printing " +
            "the fan " + name + " object \n   or its getters will output any information about it.");
        }
    }

    // This is not used. If I were going to use it I'd probably treat it like getSpeed and have it
    // return a string.
    public short getMode () {
        return mode;
    }

    // This has no setter because it's always and only set when the object is instantiated.
    public char getName () {
        return name;
    }
}
