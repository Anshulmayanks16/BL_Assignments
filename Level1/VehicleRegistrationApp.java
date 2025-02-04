class Vehicle {
    // Static variable shared across all vehicles
    private static double registrationFee = 5000.0; // Default registration fee
    
    // Instance variables
    private String ownerName;
    private String vehicleType;
    private final String registrationNumber; // Final variable, cannot be changed after assignment
    
    // Constructor using 'this' to resolve ambiguity
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber; // Final variable initialized
    }
    
    // Static method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
    
    // Method to display vehicle details (using instanceof)
    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("\n=== Vehicle Registration Details ===");
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        } else {
            System.out.println("Invalid Vehicle Object");
        }
    }
}

// Main class to test the implementation
public class VehicleRegistrationApp {
    public static void main(String[] args) {
        // Creating vehicle objects
        Vehicle vehicle1 = new Vehicle("John Doe", "Car", "ABC123");
        Vehicle vehicle2 = new Vehicle("Jane Smith", "Motorcycle", "XYZ789");
        
        // Display initial vehicle details
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
        
        // Updating registration fee
        Vehicle.updateRegistrationFee(5500.0); // Change fee to $5500
        System.out.println("\nUpdated registration fee applied to all vehicles!");

        // Display vehicle details after fee update
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
        
        // Checking instanceof usage
  
      System.out.println("\nIs vehicle1 an instance of Vehicle? " + (vehicle1 instanceof Vehicle));
    }
}