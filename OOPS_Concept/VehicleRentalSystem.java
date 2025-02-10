// Interface for Insurable vehicles
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Getters and Setters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    // Abstract method to calculate rental cost
    public abstract double calculateRentalCost(int days);

    // Method to display vehicle details
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per Day: " + rentalRate);
    }
}

// Car class implementing Insurable
class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;
    private double insuranceRate;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber, double insuranceRate) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
        this.insuranceRate = insuranceRate;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return insuranceRate;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Policy: " + insurancePolicyNumber + ", Rate: " + insuranceRate;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(getInsuranceDetails());
    }
}

// Bike class implementing Insurable
class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;
    private double insuranceRate;

    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber, double insuranceRate) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
        this.insuranceRate = insuranceRate;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return insuranceRate;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Policy: " + insurancePolicyNumber + ", Rate: " + insuranceRate;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(getInsuranceDetails());
    }
}

// Truck class implementing Insurable
class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;
    private double insuranceRate;

    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber, double insuranceRate) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
        this.insuranceRate = insuranceRate;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500; // Additional charge for trucks
    }

    @Override
    public double calculateInsurance() {
        return insuranceRate;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Policy: " + insurancePolicyNumber + ", Rate: " + insuranceRate;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(getInsuranceDetails());
    }
}

// Main class to demonstrate the system
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car("CAR123", 1500, "POLICYCAR001", 300);
        vehicles[1] = new Bike("BIKE456", 500, "POLICYBIKE002", 100);
        vehicles[2] = new Truck("TRUCK789", 2500, "POLICYTRUCK003", 700);

        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i].displayDetails();
            int rentalDays = 5;
            System.out.println("Rental Cost for " + rentalDays + " days: " + vehicles[i].calculateRentalCost(rentalDays));
            if (vehicles[i] instanceof Insurable) {
                System.out.println("Insurance Cost: " + ((Insurable) vehicles[i]).calculateInsurance());
            }
            System.out.println("-----------------------------");
        }
    }
}