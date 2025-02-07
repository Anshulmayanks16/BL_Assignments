// Superclass Person
class Person {
    private String name;
    private int id;

    // Constructor
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Method to display personal details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Worker interface
interface Worker {
    void performDuties();
}

// Subclass Chef implementing Worker interface
class Chef extends Person implements Worker {
    private String specialty;

    // Constructor
    public Chef(String name, int id, String specialty) {
        super(name, id);  // Calling superclass constructor
        this.specialty = specialty;
    }

    // Getter method
    public String getSpecialty() {
        return specialty;
    }

    // Implementing performDuties method
    @Override
    public void performDuties() {
        System.out.println(getName() + " is preparing " + specialty + " dishes.");
    }

    // Display role
    public void displayRole() {
        System.out.println("Role: Chef");
        displayDetails();
        System.out.println("Specialty: " + specialty);
    }
}

// Subclass Waiter implementing Worker interface
class Waiter extends Person implements Worker {
    private int tablesAssigned;

    // Constructor
    public Waiter(String name, int id, int tablesAssigned) {
        super(name, id);  // Calling superclass constructor
        this.tablesAssigned = tablesAssigned;
    }

    // Getter method
    public int getTablesAssigned() {
        return tablesAssigned;
    }

    // Implementing performDuties method
    @Override
    public void performDuties() {
        System.out.println(getName() + " is serving " + tablesAssigned + " tables.");
    }

    // Display role
    public void displayRole() {
        System.out.println("Role: Waiter");
        displayDetails();
        System.out.println("Tables Assigned: " + tablesAssigned);
    }
}

// Main class to test
public class RestaurantManagementSystem {
    public static void main(String[] args) {
        // Creating a Chef
        Chef chef = new Chef("Gordon Ramsay", 101, "Italian");

        // Creating a Waiter
        Waiter waiter = new Waiter("John Doe", 202, 5);

        // Displaying roles and details
        System.out.println("Chef Details:");
        chef.displayRole();
        chef.performDuties();

        System.out.println("\nWaiter Details:");
        waiter.displayRole();
        waiter.performDuties();
    }
}