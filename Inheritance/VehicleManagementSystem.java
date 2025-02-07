// Superclass Vehicle
class Vehicle {
    private String model;
    private int maxSpeed;

    // Constructor
    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    // Getter methods
    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    // Method to display vehicle details
    public void displayDetails() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Refuelable interface
interface Refuelable {
    void refuel();
}

// Subclass ElectricVehicle
class ElectricVehicle extends Vehicle {
    private int batteryCapacity;

    // Constructor
    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);  // Calling superclass constructor
        this.batteryCapacity = batteryCapacity;
    }

    // Getter method
    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    // Method to charge the electric vehicle
    public void charge() {
        System.out.println(getModel() + " is charging. Battery capacity: " + batteryCapacity + " kWh.");
    }

    // Display role
    public void displayRole() {
        System.out.println("Type: Electric Vehicle");
        displayDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

// Subclass PetrolVehicle implementing Refuelable
class PetrolVehicle extends Vehicle implements Refuelable {
    private int fuelCapacity;

    // Constructor
    public PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);  // Calling superclass constructor
        this.fuelCapacity = fuelCapacity;
    }

    // Getter method
    public int getFuelCapacity() {
        return fuelCapacity;
    }

    // Implementing refuel method from Refuelable interface
    @Override
    public void refuel() {
        System.out.println(getModel() + " is refueling. Fuel capacity: " + fuelCapacity + " liters.");
    }

    // Display role
    public void displayRole() {
        System.out.println("Type: Petrol Vehicle");
        displayDetails();
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
    }
}

// Main class to test
public class VehicleManagementSystem {
    public static void main(String[] args) {
        // Creating an Electric Vehicle
        ElectricVehicle ev = new ElectricVehicle("Tesla Model S", 250, 100);

        // Creating a Petrol Vehicle
        PetrolVehicle pv = new PetrolVehicle("Ford Mustang", 240, 60);

        // Displaying details and performing actions
        System.out.println("Electric Vehicle Details:");
        ev.displayRole();
        ev.charge();

        System.out.println("\nPetrol Vehicle Details:");
        pv.displayRole();
        pv.refuel();
    }
}