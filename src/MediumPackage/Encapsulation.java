package MediumPackage;

/*
    ENCAPSULATION
    ==============
    Encapsulation is one of the four fundamental principles of Object-Oriented Programming (OOP).
    It refers to bundling data (variables) and methods that operate on that data into a single unit (class),
    and restricting direct access to some of the object's components.

    Key Concepts:
    - Data Hiding: Making instance variables private
    - Access Control: Using access modifiers (private, protected, public)
    - Getter and Setter Methods: Controlled access to private variables
    - Validation: Adding checks in setter methods

    Benefits:
    - Data Security: Prevents unauthorized access and modification
    - Code Maintainability: Changes to internal implementation don't affect external code
    - Flexibility: Can add validation, logging, or other logic in getter/setter methods
    - Control: Can make properties read-only, write-only, or read-write
*/

import java.util.Arrays;

class BankAccount {
    public final String acc_no;
    public String name;
    private double balance;
    public String type;

    public BankAccount(String acc_no, String name, double amount, String type){
        this.acc_no = acc_no;
        this.name = name;
        this.type = type;

        // amount validation
        if(amount >= 0){
            this.balance = amount;
        }else{
            this.balance = 0;
            System.out.println("negative balance is not allowed so set up to zero");
        }
    }

    public void displayInfo(){
        System.out.printf("------- %s------%n", acc_no);
        System.out.println("name: " + name);
        System.out.println("balance: " + balance);
        System.out.println("account_type: " + type);
    }
    public void showBalance(){
        System.out.println("current balance in account: " + balance);
    }
    public void deposit(double amount){
        if(amount <= 0){
            System.out.println("please enter valid amount");
            return;
        }

        balance+=amount;
        System.out.println("amount added to your account successfully!");
    }
    public void withdraw(double amount){
        if(amount <= 0){
            System.out.println("please enter valid amount");
            return;
        }

        if(balance >= amount){
            balance-=amount;
            System.out.println("amount deducted to your account successfully!");
        }else{
            System.out.println("insufficient funds!");
        }
    }

    // setter functions
    public void setName(String name){
        if(name == null || name.isBlank() || name.length() < 6) {
            System.out.println("please enter the valid name, length should be greater then or equals 6");
            return;
        }
        this.name = name;
        System.out.println("Account name has been changed....");
    }
    public void setAccountType(String accountType){
        if(accountType != null
                || accountType.equals("saving")
                || accountType.equals("fixed")
                || accountType.equals("current")){
            this.type = accountType;
        }else{
            System.out.println("Error: Invalid account type. Allowed: Savings, Current, Fixed");
        }
    }
}

class Student {
    public int rollNo;
    public String firstName;
    public String lastName;
    int age;
    String email;

    float[] grades;
    private int index = 0;

    public Student(int rollNo, String firstName, String lastName, int age, String email){
        if(!email.contains("@gmail.com")){
            System.out.println("please enter the valid email");
            return;
        }

        if(age < 18){
            System.out.println("age must be greater or equal then 18");
            return;
        }

        if(firstName == null || lastName == null || firstName.isBlank() || lastName.isBlank()){
            System.out.println("there must be a proper firstname and lastname");
            return;
        }

        this.rollNo = rollNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.grades = new float[7];
    }

    public void infoDisplay(){
        System.out.printf("------ %s ------%n", rollNo);
        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);
        System.out.println("age: " + age);
        System.out.println("email: " + email);
        System.out.println("grades: " + Arrays.toString(grades));
    }

    public void addGrade(float grade){
        if(index >= 7){
            System.out.println("already filled grades");
            return;
        }

        if(grade < 0 || grade > 100){
            System.out.println("grade must be non-negative or not must be greater then 100");
            return;
        }

        grades[index] = grade;
        index++;
        System.out.println("grade has been added in student database");
    }

    public float getAverage(){
        float grades_avg = 0;
        for(float i: grades){
            grades_avg += i;
        }

        return grades_avg / index + 1;
    }

    // getter function
    public float[] getGrades(){
        return grades;
    }
}

class Employee {
    // different access modifier demonstration
    public String department;          // Public - accessible everywhere
    protected String position;         // Protected - accessible in same package and subclasses
    String projectName;                // Package-private - accessible in same package
    private double salary;             // Private - accessible only within this class
    private final int employeeId;      // Final field - cannot be changed after initialization

    // static class variable
    private static int total_emp = 0;

    public Employee(int emp_id, String department, String position, String projectName, double salary){
        this.employeeId = emp_id;
        this.department = department;
        this.position = position;
        this.projectName = projectName;
        setSalary(salary);
        total_emp++;
    }

    // Getter for private final field (read-only)
    public int getEmployeeId() {
        return employeeId;
    }

    // Getter and setter for salary with business logic
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary){
        if(salary >= 30000 && salary <= 200000){
            this.salary = salary;
            System.out.println("salary update to :$" + salary);
        }else{
            System.out.println("Error: Salary must be between $30,000 and $200,000");
        }
    }

    // Static method to access private static variable
    public static int getTotalEmployees() {
        return total_emp;
    }

    public void giveRaise(double percentage){
        if(percentage > 0 && percentage <= 50){
            double salary = this.salary + 0.50 * (this.salary);
            this.salary = salary;
            System.out.println("Raise of " + percentage + "% granted. New salary: $" + salary);
        } else {
            System.out.println("Error: Raise percentage must be between 0% and 50%");
        }
    }

    // Method with different access levels for internal operations
    private void calculateTax(){
        // Private method - internal business logic
        double tax = salary * 0.25;
        System.out.println("Calculated tax: $" + tax);
    }
}


public class Encapsulation {
    public static void main(String[] args){
        System.out.println("=== Encapsulation Examples in Java ===\n");




        // 1. Bank Account Example
        System.out.println("1. Bank Account Encapsulation:");
        BankAccount account = new BankAccount("ACC001", "sharad", 1000.0d, "saving");
        account.displayInfo();

        System.out.println("\n--- Account Operations ---");
        account.deposit(500.0);
        account.withdraw(200.0);
        account.withdraw(2000.0); // Should fail
        account.deposit(-100.0);
        account.showBalance();

        System.out.println("\n--- Attempting to modify account details ---");
        account.setName("sharad-poddar");
        account.displayInfo();

        account.setAccountType("current");
        account.displayInfo();

        System.out.println("\n" + "=".repeat(70) + "\n");




        // 2. Student Example
        System.out.println("2. Student Encapsulation:");
        Student stud = new Student(12345, "sharad", "poddar", 20, "sharad@gmail.com");
        stud.infoDisplay();

        stud.addGrade(85.5f);
        stud.addGrade(92.0f);
        stud.addGrade(78.5f);
        stud.addGrade(88.0f);
        stud.addGrade(95.5f);
        stud.addGrade(105.0f); // Should fail
        stud.addGrade(-10.0f); // Should fail

        float avg = stud.getAverage();
        System.out.println("avg: " + avg);

        // Accessing grades safely (getting a copy)
        float[] grades_copy = stud.getGrades();
        System.out.print("Individual grades: ");
        for(float i: grades_copy){
            System.out.println("grade -> " + i);
        }

        System.out.println("\n--- Attempting to modify student details ---");
        System.out.println("\n" + "=".repeat(70) + "\n");




        // 3. Employee Example - Access Modifiers
        System.out.println("3. Employee Encapsulation - Access Modifiers:");
        Employee emp1 = new Employee(1001, "Engineering", "software developer", "projectX", 75000);
        Employee emp2 = new Employee(1002, "Marketing", "Marketing Manager", "projectY", 65000);

        // this is static variable we are calling it with the class...
        System.out.println("Total employees: " + Employee.getTotalEmployees());

        // Accessing public field directly
        System.out.println("Employee 1 department (public): " + emp1.department);
        // modify the public field
        emp1.department = "Research & Development";
        System.out.println("Modified department: " + emp1.department);

        // Accessing protected field (within same package)
        System.out.println("Employee 1 position (protected): " + emp1.position);

        // Accessing package-private field
        System.out.println("Employee 1 project (package-private): " + emp1.projectName);

        // Cannot access private field directly
        // System.out.println(emp1.salary); // This would cause compilation error

        // Must-use getter for private field
        System.out.println("Employee 1 salary (via getter): $" + emp1.getSalary());
        System.out.println("\n--- Employee operations ---");
        emp1.setSalary(80000);
        emp1.giveRaise(10);
        emp1.setSalary(250000); // Should fail
        emp1.giveRaise(60); // Should fail

        System.out.println("\n" + "=".repeat(70) + "\n");
    }
}




/*
    Key Points about Encapsulation:

    1. Data Hiding:
        - Make instance variables private
        - Prevents direct access from outside the class
        - Protects data integrity and maintains object state

    2. Access Modifiers:
        - private: Accessible only within the same class
        - protected: Accessible within same package and subclasses
        - package-private (default): Accessible within same package
        - public: Accessible from anywhere

     3. Getter and Setter Methods:
        - Getters (accessors): Provide read access to private fields
        - Setters (mutators): Provide controlled write access with validation
        - Can implement business logic, validation, and logging

     4. Benefits:
        - Security: Prevents unauthorized access and modification
        - Maintainability: Internal changes don't affect external code
        - Flexibility: Can add validation, logging, computation
        - Control: Can make fields read-only, write-only, or computed
        - Debugging: Easier to track data modifications

     5. Best Practices:
        - Keep fields private unless there's a specific reason not to
        - Provide public getter/setter methods for controlled access
        - Add validation in setter methods
        - Use meaningful names for getter/setter methods
        - Don't provide setters for fields that shouldn't change
        - Return copies of mutable objects to prevent external modification

     6. Common Patterns:
        - Read-only properties: Getter only, no setter
        - Write-only properties: Setter only, no getter (rare)
        - Computed properties: Getter calculates value from other fields
        - Validated properties: Setter includes business rule validation
        - Immutable objects: No setters, all fields final

     7. Real-world Applications:
        - Banking systems: Account balance protection
        - User management: Password and email validation
        - Configuration objects: Preventing invalid settings
        - Data models: Maintaining referential integrity
        - APIs: Controlling how data is accessed and modified
 */




















