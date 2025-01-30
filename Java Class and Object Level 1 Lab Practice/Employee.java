class Employee {
    private String name;
    private int id;
    private double salary;

    // Constructor
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }

    // Main method to test the Employee class
    public static void main(String[] args) {
        Employee emp1 = new Employee("John Doe", 101, 50000.0);
        emp1.displayDetails();
    }
}
