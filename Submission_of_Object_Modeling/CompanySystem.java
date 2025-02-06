public class CompanySystem {

    // Employee Class (nested inside Department)
    static class Employee {
        private String name;
        private String position;

        // Constructor
        public Employee(String name, String position) {
            this.name = name;
            this.position = position;
        }

        // Display employee information
        public void displayEmployeeInfo() {
            System.out.println("Employee Name: " + name + ", Position: " + position);
        }
    }

    // Department Class (composition within Company)
    static class Department {
        private String deptName;
        private Employee[] employees;
        private int employeeCount;

        // Constructor
        public Department(String deptName, int maxEmployees) {
            this.deptName = deptName;
            this.employees = new Employee[maxEmployees];  // Fixed-size array for employees
            this.employeeCount = 0;
        }

        // Add employee to department
        public void addEmployee(String name, String position) {
            if (employeeCount < employees.length) {
                employees[employeeCount] = new Employee(name, position);
                employeeCount++;
            } else {
                System.out.println("Cannot add more employees to " + deptName);
            }
        }

        // Display all employees in the department
        public void displayDepartmentInfo() {
            System.out.println("Department: " + deptName);
            for (int i = 0; i < employeeCount; i++) {
                employees[i].displayEmployeeInfo();
            }
            System.out.println();
        }
    }

    // Company Class (composition containing Departments)
    static class Company {
        private String companyName;
        private Department[] departments;
        private int departmentCount;

        // Constructor
        public Company(String companyName, int maxDepartments) {
            this.companyName = companyName;
            this.departments = new Department[maxDepartments];  // Fixed-size array for departments
            this.departmentCount = 0;
        }

        // Add a department to the company
        public void addDepartment(String deptName, int maxEmployees) {
            if (departmentCount < departments.length) {
                departments[departmentCount] = new Department(deptName, maxEmployees);
                departmentCount++;
            } else {
                System.out.println("Cannot add more departments to " + companyName);
            }
        }

        // Get department by name
        public Department getDepartment(String deptName) {
            for (int i = 0; i < departmentCount; i++) {
                if (departments[i].deptName.equals(deptName)) {
                    return departments[i];
                }
            }
            return null;  // Department not found
        }

        // Display all departments and their employees
        public void displayCompanyInfo() {
            System.out.println("Company: " + companyName);
            for (int i = 0; i < departmentCount; i++) {
                departments[i].displayDepartmentInfo();
            }
        }

        // Delete company and associated departments and employees
        public void deleteCompany() {
            // Explicitly nullify all departments and employees to simulate deletion
            for (int i = 0; i < departmentCount; i++) {
                departments[i] = null;
            }
            departments = null;
            System.out.println("Company " + companyName + " and all associated departments and employees have been deleted.");
        }
    }

    // Main Method
    public static void main(String[] args) {
        // Create a company with capacity for 3 departments
        Company company = new Company("Tech Innovators", 3);

        // Add departments to the company
        company.addDepartment("Engineering", 5);
        company.addDepartment("HR", 3);
        company.addDepartment("Marketing", 4);

        // Add employees to departments
        Department engineering = company.getDepartment("Engineering");
        if (engineering != null) {
            engineering.addEmployee("Alice", "Software Engineer");
            engineering.addEmployee("Bob", "DevOps Engineer");
        }

        Department hr = company.getDepartment("HR");
        if (hr != null) {
            hr.addEmployee("Carol", "HR Manager");
        }

        Department marketing = company.getDepartment("Marketing");
        if (marketing != null) {
            marketing.addEmployee("Dave", "Marketing Specialist");
            marketing.addEmployee("Eve", "Content Creator");
        }

        // Display the company's departments and employees
        company.displayCompanyInfo();

        // Delete the company and associated departments/employees
        company.deleteCompany();

        // Attempt to display company info after deletion
        if (company != null) {
            company.displayCompanyInfo();  // This will not display anything as the company has been "deleted"
        }
    }
}