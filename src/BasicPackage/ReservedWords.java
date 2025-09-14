package BasicPackage;

/*
    Understanding Reserved Words (Keywords) in Java
    Reserved words are predefined words in Java that have special meanings
    and cannot be used as identifiers (variable names, method names, class names).

    Java has 50 reserved words divided into different categories:
    1. Access Modifiers: public, private, protected
    2. Class/Method/Variable Modifiers: static, final, abstract, synchronized, etc.
    3. Control Flow: if, else, switch, case, default, for, while, do, break, continue
    4. Data Types: boolean, byte, char, short, int, long, float, double, void
    5. Exception Handling: try, catch, finally, throw, throws
    6. Object-Oriented: class, interface, extends, implements, super, this
    7. Package/Import: package, import
    8. Others: new, return, instanceof, native, strictfp, transient, volatile
*/


public class ReservedWords {
    // Class-level variables demonstrating access modifiers
    public String publicVar = "Accessible everywhere";
    private String privateVar = "Only withing this class";
    protected String protectedVar = "within package and subclass";

    public static final String CONSTANT = "This is a constant and cannot final changes";
    public static int staticCounter = 0;

    public static void main(String[] args) {
        System.out.println("1. Access Modifiers and Variable Modifiers:");
        ReservedWords obj = new ReservedWords();

        System.out.println("Public variable: " + obj.publicVar);
        // This would cause compilation error
        // System.out.println(obj.privateVar);

        System.out.println("Protected variable: " + obj.protectedVar);
        System.out.println("Static constant: " + CONSTANT);

        // 2. Data Type Keywords
        System.out.println("\n2. Data Type Keywords:");
        boolean booleanVar = true;
        byte byteVar = 127;
        char charVar = 'A';
        short shortVar = 32767;
        int intVar = 2147483647;
        long longVar = 9223372036854775807L;
        float floatVar = 3.14f;
        double doubleVar = 3.14159265359;

        System.out.println("boolean: " + booleanVar);
        System.out.println("byte: " + byteVar);
        System.out.println("char: " + charVar);
        System.out.println("short: " + shortVar);
        System.out.println("int: " + intVar);
        System.out.println("long: " + longVar);
        System.out.println("float: " + floatVar);
        System.out.println("double: " + doubleVar);

        // 3. Control Flow Keywords
        System.out.println("\n3. Control Flow Keywords:");
        if (intVar > 0) {
            System.out.println("Number is positive");
        } else {
            System.out.println("Number is not positive");
        }

        // switch-case-default
        switch (charVar) {
            case 'A':
                System.out.println("Character is A");
                break;
            case 'B':
                System.out.println("Character is B");
                break;
            default:
                System.out.println("Character is something else");
                break;
        }

        // for loop
        // Skip iteration when i = 3
        // Exit loop when i = 7
        System.out.println("For loop with break and continue:");
        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                continue;
            }
            if (i == 7) {
                break;
            }
            System.out.print(i + " ");
        }
        System.out.println();


        // while loop
        System.out.println("While loop:");
        int count = 0;
        while (count < 3) {
            System.out.println("Count: " + count);
            count++;
        }


        // do-while loop
        System.out.println("Do-while loop:");
        int num = 0;
        do {
            System.out.println("Number: " + num);
            num++;
        } while (num < 2);


        // 4. Object-Oriented Keywords
        System.out.println("\n4. Object-Oriented Keywords:");

        // new keyword
        String str = new String("Created using new keyword");
        System.out.println(str);
    }
}






















