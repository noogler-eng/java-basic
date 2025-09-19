package MediumPackage;

/*
    INHERITANCE
    ===========

     Inheritance is a fundamental principle of Object-Oriented Programming (OOP) that allows
     a new class to inherit properties and methods from an existing class.

     Key Concepts:
         - Parent Class (Superclass/Base Class): The class being inherited from
         - Child Class (Subclass/Derived Class): The class that inherits from parent
         - 'extends' keyword: Used to establish inheritance relationship
         - 'super' keyword: Used to access parent class members
         - Method Overriding: Child class provides specific implementation of parent method

     Types of Inheritance in Java:
     1. Single Inheritance: One child class inherits from one parent class
     2. Multilevel Inheritance: Chain of inheritance (A -> B -> C)
     3. Hierarchical Inheritance: Multiple child classes inherit from same parent

     Note: Java doesn't support multiple inheritance of classes (but supports it through interfaces)
     Benefits:
         - Code Reusability: Reuse existing code without rewriting
         - Method Overriding: Customize behavior in child classes
         - Polymorphism: Treat objects of different types uniformly
         - Extensibility: Add new features while maintaining existing functionality
*/

class Animal {
    // Protected fields - accessible to subclasses
    protected String name;
    protected String species;
    protected int age;
    protected double weight;

    // Private field - not directly accessible to subclasses
    private String habitat;

    // Default constructor
    public Animal() {
        this.name = "Unknown";
        this.species = "Unknown";
        this.age = 0;
        this.weight = 0.0;
        this.habitat = "Unknown";
        System.out.println("Animal default constructor called");
    }

    // Parameterized constructor
    public Animal(String name, String species, int age, double weight, String habitat) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.weight = weight;
        this.habitat = habitat;
        System.out.println("Animal parameterized constructor called for: " + name);
    }

    // Methods that can be inherited
    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }

    public void makeSound() {
        System.out.println(name + " makes a generic animal sound.");
    }

    public void displayInfo() {
        System.out.println("=== Animal Information ===");
        System.out.println("Name: " + name);
        System.out.println("Species: " + species);
        System.out.println("Age: " + age + " years");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Habitat: " + habitat);
    }

    // Method that child classes can override
    public void move() {
        System.out.println(name + " is moving.");
    }

    // Final method - cannot be overridden
    public final void breathe() {
        System.out.println(name + " is breathing.");
    }

    // Getter and setter for private field
    public String getHabitat() { return habitat; }
    public void setHabitat(String habitat) { this.habitat = habitat; }

    // Other getters and setters
    public String getName() { return name; }
    public String getSpecies() { return species; }
    public int getAge() { return age; }
    public double getWeight() { return weight; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setWeight(double weight) { this.weight = weight; }
}

class Dog extends Animal{
    // Additional fields specific to Dog
    private String breed;
    private boolean isVaccinated;

    // Default constructor
    public Dog() {
        // Calls parent default constructor
        super();
        this.breed = "Mixed";
        this.isVaccinated = false;
        System.out.println("Dog default constructor called");
    }

    // Constructor using super(), parametrized constructor
    public Dog(String name, int age, double weight, String breed, boolean isVaccinated) {
        super(name, "Canis lupus", age, weight, "Domestic");
        this.breed = breed;
        this.isVaccinated = isVaccinated;
        System.out.println("Dog parameterized constructor called for: " + name);
    }

    // Method Overriding - providing specific implementation
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }

    @Override
    public void move() {
        System.out.println(name + " runs on four legs.");
    }

    // Additional methods specific to Dog
    public void wagTail() {
        System.out.println(name + " is wagging its tail happily!");
    }

    public void fetch() {
        System.out.println(name + " is fetching the ball!");
    }

    public void guard() {
        System.out.println(name + " is guarding the house!");
    }

    // Overriding displayInfo to include dog-specific information
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent method
        System.out.println("Breed: " + breed);
        System.out.println("Vaccinated: " + (isVaccinated ? "Yes" : "No"));
    }

    // Getters and setters for dog-specific fields
    public String getBreed() { return breed; }
    public boolean isVaccinated() { return isVaccinated; }
    public void setBreed(String breed) { this.breed = breed; }
    public void setVaccinated(boolean vaccinated) { this.isVaccinated = vaccinated; }
}

class Cat extends  Animal{
    private boolean isIndoor;
    private int livesRemaining;

    public Cat() {
        super();
        this.isIndoor = true;
        this.livesRemaining = 9;
        System.out.println("Cat default constructor called");
    }

    public Cat(String name, int age, double weight, boolean isIndoor) {
        super(name, "Felis catus", age, weight, "Domestic");
        this.isIndoor = isIndoor;
        this.livesRemaining = 9;
        System.out.println("Cat parameterized constructor called for: " + name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow! Meow!");
    }

    @Override
    public void move() {
        System.out.println(name + " gracefully walks and can climb.");
    }

    public void purr() {
        System.out.println(name + " is purring contentedly.");
    }

    public void scratch() {
        System.out.println(name + " is scratching the scratching post.");
    }

    public void climb() {
        System.out.println(name + " is climbing up high!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Indoor cat: " + (isIndoor ? "Yes" : "No"));
        System.out.println("Lives remaining: " + livesRemaining);
    }

    public boolean isIndoor() { return isIndoor; }
    public int getLivesRemaining() { return livesRemaining; }
    public void setIndoor(boolean indoor) { this.isIndoor = indoor; }
}

public class Inheritance {
    public void main(String[] args){}
}
