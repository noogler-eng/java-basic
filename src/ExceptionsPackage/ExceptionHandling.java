package ExceptionsPackage;

/*
    Understanding Exception Handling in Java

    Exception handling in Java is a powerful mechanism to handle runtime errors
    and maintain normal application flow. Exceptions are events that disrupt the
    normal flow of program execution.

    Java exception hierarchy:
    - Throwable (top-level class)
        - Error (system-level errors, usually not handled)
        - Exception
            - RuntimeException (unchecked exceptions)
            - Other exceptions (checked exceptions)

    Key concepts:
    - try-catch-finally blocks
    - throw and throws keywords
    - Custom exceptions
    - Exception propagation
*/

import java.io.*;
import java.util.*;

public class ExceptionHandling {
    // main functions
    public static void withoutTryCatch(){
        int[] numbers = {1, 2, 3};
        System.out.println("Accessing the index:2, " + numbers[2]);
        // whole code flow stops here, server crashes in this time....
        System.out.println("Accessing the index:3, " + numbers[3]);
        System.out.println("Accessing the index:1, " + numbers[1]);
    }


    public static void basicTryCatch(){
        try{
            int[] numbers = {1, 2, 3};
            System.out.println("Accessing the index:2, " + numbers[2]);
            System.out.println("Accessing the index:3, " + numbers[3]);
            System.out.println("Accessing the index:1, " + numbers[1]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Caught Exception: " + e.getMessage());
            System.out.println("Array index out of bound!");
        }finally {
            System.out.println("this is final block!");
        }

        System.out.println("Program continues after exception handling");
    }


    public static void multipleCatchBlocks(){
        String[] data = {"10", "abc", "40", "sharad"};

        // there is multiple catch blocks with different exceptions
        // there is exception family....
        /* Exception Hierarchy in Java
            java.lang.Object
            └── java.lang.Throwable
              ├── java.lang.Exception
              │       ├── java.lang.RuntimeException
              │       │       ├── NullPointerException
              │       │       ├── ArithmeticException
              │       │       ├── ArrayIndexOutOfBoundsException
              │       │       ├── ClassCastException
              │       │       └── ... (other unchecked exceptions)
              │       │
              │       ├── IOException
              │       ├── SQLException
              │       ├── ClassNotFoundException
              │       └── ... (other checked exceptions)
              │
              └── java.lang.Error
                      ├── OutOfMemoryError
                      ├── StackOverflowError
                      ├── VirtualMachineError
                      └── ... (serious system errors)
        */
        for(String item: data){
            try{
                int number = Integer.parseInt(item);
                int result = 100 / number;
                System.out.println("100 / number: " + result);
            }catch (NumberFormatException e){
                System.out.println("NumberFormatException error: " + e.getMessage());
            }catch (ArithmeticException e){
                System.out.println("Cannot divide by zero" + e.getMessage());
            }catch (Exception e){
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }


    public static void finalCatchBlock(){
        FileWriter writer = null;

        try{
            writer = new FileWriter("temp.txt");
            writer.write("Hi i am sharad");
            System.out.println("File written successfully");

            // This will throw ArithmeticException
            int result = 10 / 0;
        }catch(IOException e){
            // Exception 'java.io.IOException' is never thrown in the corresponding try block
            System.out.println("IO Exception: " + e.getMessage());
        }catch (ArithmeticException e){
            System.out.println("Arithmetic Exception: " + e.getMessage());
        }finally {
            // this is how the final block is used to close the connection
            // remove or delete the resources....
            System.out.println("Finally block executed - cleaning up resources");
            try{
                if(writer != null){
                    writer.close();
                }
            }catch (IOException e){
                System.out.println("Error closing writer: " + e.getMessage());
            }
        }
        System.out.println("Method completed");
    }


    public static void tryWithResource(){
        // FileWriter
        // - Direct writer for writing character data to a file.
        // - It writes characters directly to the file on disk.
        // - Every call to write() immediately sends data to the file (which can be slower if you write small chunks repeatedly).
        // - Doesn’t use a buffer internally.

        // BufferedWriter
        // - Wrapper over a Writer (like FileWriter).
        // - Uses an internal buffer (default size ~8KB).
        // - Data is collected in memory first, and only written to disk when the buffer fills or when you call flush()/close().
        // - Makes writing more efficient when writing many small chunks (e.g., inside loops).

        // Resources are automatically closed
        try(FileWriter writer = new FileWriter("temp2.txt");
            BufferedWriter bufferWriter = new BufferedWriter(writer)){

            bufferWriter.write("try-with-resources example");
            bufferWriter.newLine();
            bufferWriter.write("Resources are auto-closed");
            System.out.println("File written using try-with-resources");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    public static void throwingException(){
        try{
            validateAge(15);
            validateAge(25);
            validateAge(-5);
        }catch (IllegalArgumentException e){
            System.out.println("Validation error: " + e.getMessage());
        }
    }


    public static void throwsException(){
        // by-default it goes with the double
        // so making it with float....
        BankAccount account = new BankAccount(1000.0f);
        try{
            account.withdraw(200);
            account.withdraw(1000);
        }catch(Exception e){
            System.out.println("Banking error: " + e.getMessage());
        }
    }


    public static void customException(){
        try{
            BankAccount account = new BankAccount(1000);
            account.deposit(2000);
            account.deposit(3000);
        } catch (BalanceOverflow e) {
            System.out.println(e.getMessage());
            System.out.println(e.getAvailableBalance());
        }
    }



    // helper functions....
    public static void validateAge(int age){
        System.out.println("Validating age: " + age);
        if(age < 0){
            throw new IllegalArgumentException("Age cannot be negative");
        }

        if(age < 18){
            throw new IllegalArgumentException("Age must be 18 or more");
        }

        System.out.println("Ahe: " + age + " is valid");
    }



    public static void main(String[] args){
        System.out.println("1. Exception Handling Examples");
        // 0. Without try and catch....
        // withoutTryCatch();

        // 1. Basic try and catch problem....
        System.out.println("1. Single Try Catch Blocks");
        basicTryCatch();

        // 2. Multiple catch blocks
        System.out.println("2. Multiple Catch Blocks");
        multipleCatchBlocks();

        // 3. Final Catch Block
        System.out.println("3. Final Catch Block");
        finalCatchBlock();

        // 4. Try-with-Resources
        System.out.println("4. Try-with-Resources");
        tryWithResource();

        // 5. Throwing Exception
        System.out.println("4. Throwing-Exception");
        throwingException();

        // 6. Throws Exception
        System.out.println("5. Throws Exception");
        throwsException();

        // 7. Custom Exception
        System.out.println("5. Custom Exception");
        customException();
    }
}










