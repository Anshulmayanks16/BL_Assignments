class Vehicle {
    private char[] ownerName;
    private char[] vehicleType;
    private static double registrationFee = 500.0; // Default fee

    // Constructor
    public Vehicle(char[] ownerName, char[] vehicleType) {
        this.ownerName = copyCharArray(ownerName);
        this.vehicleType = copyCharArray(vehicleType);
    }

    // Copy character array manually
    private char[] copyCharArray(char[] source) {
        if (source == null) return new char[0];
        char[] copy = new char[source.length];
        for (int i = 0; i < source.length; i++) {
            copy[i] = source[i];
        }
        return copy;
    }

    // Instance method to display vehicle details
    public void displayVehicleDetails() {
        System.out.print("Owner Name: ");
        printCharArray(ownerName);
        System.out.print(" | Vehicle Type: ");
        printCharArray(vehicleType);
        System.out.println(" | Registration Fee: " + registrationFee);
    }

    // Static method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    // Print character array manually
    private void printCharArray(char[] arr) {
        for (char c : arr) {
            System.out.print(c);
        }
    }


  public static void main(String[] args) {
        char[] owner1 = {'J', 'o', 'h', 'n', ' ', 'D', 'o', 'e'};
        char[] vehicle1 = {'S', 'e', 'd', 'a', 'n'};
        
        char[] owner2 = {'A', 'l', 'i', 'c', 'e', ' ', 'S', 'm', 'i', 't', 'h'};
        char[] vehicle2 = {'S', 'U', 'V'};
        
        Vehicle vehicleA = new Vehicle(owner1, vehicle1);
        Vehicle vehicleB = new Vehicle(owner2, vehicle2);
        
        vehicleA.displayVehicleDetails();
        vehicleB.displayVehicleDetails();
        
        Vehicle.updateRegistrationFee(600.0);
        
        vehicleA.displayVehicleDetails();
        vehicleB.displayVehicleDetails();
    }
}
