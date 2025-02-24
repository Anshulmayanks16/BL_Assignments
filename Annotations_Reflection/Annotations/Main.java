// Parent class Animal
class Animal {
    // Method to be overridden
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Child class Dog overriding makeSound() method
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

// Main class to test the functionality
public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog(); // Using polymorphism
        myDog.makeSound(); // Output: Dog barks
    }
}
