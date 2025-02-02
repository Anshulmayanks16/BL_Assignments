public class EmployeeRecords {

    // Employee Class
    public static class Employee {
        public String employeeID;     // Public member
        protected String department;  // Protected member
        private double salary;        // Private member
        
        // Constructor
        public Employee(String employeeID, String department, double salary) {
            this.employeeID = employeeID;
            this.department = department;
            this.salary = salary;
        }
        
        // Public method to modify salary
        public void setSalary(double salary) {
            if (salary > 0) {
                this.salary = salary;
            } else {
                System.out.println("Salary must be positive.");
            }
        }
        
        // Public method to get salary
        public double getSalary() {
            return this.salary;
        }
        
        // Method to display employee details
        public void displayEmployeeDetails() {
            System.out.println("Employee ID: " + employeeID);
            System.out.println("Department: " + department);
            System.out.println("Salary: " + salary);
        }
    }

    // Manager Class (Subclass of Employee)
    public static class Manager extends Employee {
        private String title;  // Additional member for manager's title
        
        // Constructor
        public Manager(String employeeID, String department, double salary, String title) {
            super(employeeID, department, salary);
            this.title = title;
        }
        
        // Method to display manager details
        @Override
        public void displayEmployeeDetails() {
            super.displayEmployeeDetails();  // Call the parent method
            System.out.println("Manager Title: " + title);
        }
        
        // Method to access protected 'department' and public 'employeeID' from superclass
        public void printManagerInfo() {
            System.out.println("Employee ID from Manager: " + employeeID);
            System.out.println("Department from Manager: " + department);
        }
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Create an instance of Employee
        Employee employee1 = new Employee("E12345", "IT", 50000);
        employee1.displayEmployeeDetails();
        
        // Modify salary using public method
        employee1.setSalary(55000);
        System.out.println("Updated Salary: " + employee1.getSalary());
        
        // Create an instance of Manager
        Manager manager1 = new Manager("M98765", "HR", 80000, "Senior Manager");
        manager1.displayEmployeeDetails();
        
        // Access protected 'department' and public 'employeeID' from subclass
        manager1.printManagerInfo();
    }
}