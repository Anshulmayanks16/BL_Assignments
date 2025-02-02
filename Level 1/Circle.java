class Circle {
    private double radius;

    // Default Constructor
    public Circle() {
        this(1.0); // Default radius is 1.0
    }

    // Parameterized Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Getter for radius
    public double getRadius() {
        return radius;
    }

    // Setter for radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double getArea() {
        return 3.14159 * radius * radius;
    }

    // Method to calculate circumference
    public double getCircumference() {
        return 2 * 3.14159 * radius;
    }

    public static void main(String[] args) {
        Circle defaultCircle = new Circle();
        System.out.println("Default Circle Radius: " + defaultCircle.getRadius());
        System.out.println("Default Circle Area: " + defaultCircle.getArea());

        Circle customCircle = new Circle(5.0);
        System.out.println("Custom Circle Radius: " + customCircle.getRadius());
        System.out.println("Custom Circle Area: " + customCircle.getArea());
    }
}
