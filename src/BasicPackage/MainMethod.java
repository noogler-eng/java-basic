package BasicPackage;

/*
    Understanding the Main Method in Java

    The main method is the entry point of any Java application.
    It's where the JVM starts executing your program.

    Syntax: public static void main(String[] args)
    public: Access modifier - can be accessed from anywhere
    static: Belongs to the class, not to any instance
    void: Returns nothing
    main: Method name (fixed)
    String[] args: Command line arguments passed to the program
*/

public class MainMethod {
    public static void greetUser(){
        System.out.println("Welcome to Java programming!");
    }

    public static void displayInfo(String msg){
        System.out.println("msg -> " + msg);
    }

    public static int addNumbers(int a, int b){
        return a + b;
    }

    public static void main(String[] args){
        System.out.println("1. Standard Main Method Examples:");

        // Basic output
        System.out.println("Hello, World!");
        System.out.println("This is the main method");

        // 2. Using Command Line Arguments
        // args is the strings array
        System.out.println("\n2. Command Line c:");
        System.out.println("Number of arguments: " + args.length);

        if(args.length > 0){
            System.out.println("First arguments: " + args[0]);

            // Print all arguments
            System.out.println("All arguments:");
            for (int i = 0; i < args.length; i++) {
                System.out.println("Argument " + i + ": " + args[i]);
            }
        }else{
            System.out.println("No command line arguments provided");
        }


        // 3. Calling other methods from main
        System.out.println("\n3. Calling Other Methods:");
        greetUser();
        displayInfo("Java Programming");
        int result = addNumbers(10, 20);
        System.out.println("add -> " + result);

        // 4. Different ways to write main method (all valid)
        System.out.println("\n4. Note: These are all valid main method signatures:");
        System.out.println("public static void main(String[] args)");
        System.out.println("public static void main(String args[])");
        System.out.println("static public void main(String[] args)");
        // Note: The order of public and static can be-change.
    }
}


/*
    Key Points:
    1. Every Java application must have at least one main method
    2. The main method must be public, static, and void
    3. The method signature is fixed and cannot be changed
    4. Command line arguments are passed as String array
    5. Static methods can be called without creating class objects
    To run with command line arguments:
    java MainMethod arg1 arg2 arg3
*/














