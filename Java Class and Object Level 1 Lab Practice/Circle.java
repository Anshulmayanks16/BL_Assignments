class Circle {
    private double radius;
    private final double PI = 3.141592653589793; // Manually defining PI

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double calculateArea() {
        return PI * radius * radius;
    }

    // Method to calculate circumference
    public double calculateCircumference() {
        return 2 * PI * radius;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }

    // Main method to test the Circle class
    public static void main(String[] args) {
        Circle circle = new Circle(5.0); // Example radius = 5.0
        circle.displayDetails();
    }
}
