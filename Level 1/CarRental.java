class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate;

    // Default Constructor
    public CarRental() {
        this.customerName = "Unknown";
        this.carModel = "Standard";
        this.rentalDays = 1;
        this.dailyRate = 50.0; // Default daily rate
    }

    // Parameterized Constructor
    public CarRental(String customerName, String carModel, int rentalDays, double dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
    }

    // Method to calculate total cost
    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    // Display rental details
    public void displayRentalDetails() {
        System.out.println("Customer: " + customerName + ", Car Model: " + carModel + ", Rental Days: " + rentalDays + ", Total Cost: " + calculateTotalCost());
    }

    public static void main(String[] args) {
        CarRental defaultRental = new CarRental();
        defaultRental.displayRentalDetails();

        CarRental customRental = new CarRental("Alice Brown", "SUV", 5, 75.0);
        customRental.displayRentalDetails();
    }
}
