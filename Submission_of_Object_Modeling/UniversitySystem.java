import java.util.ArrayList;
import java.util.List;

public class UniversitySystem {

    // Faculty Class (Aggregation - can exist independently of a Department)
    static class Faculty {
        private String name;
        private String position;

        // Constructor
        public Faculty(String name, String position) {
            this.name = name;
            this.position = position;
        }

        // Display faculty information
        public void displayFacultyInfo() {
            System.out.println("Faculty: " + name + ", Position: " + position);
        }

        public String getName() {
            return name;
        }
    }

    // Department Class (Composition - can't exist without the University)
    static class Department {
        private String departmentName;
        private List<Faculty> facultyMembers;

        // Constructor
        public Department(String departmentName) {
            this.departmentName = departmentName;
            this.facultyMembers = new ArrayList<>();
        }

        // Add faculty to the department
        public void addFaculty(Faculty faculty) {
            if (!facultyMembers.contains(faculty)) {
                facultyMembers.add(faculty);
            }
        }

        // Display all faculty members in the department
        public void displayDepartmentInfo() {
            System.out.println("Department: " + departmentName);
            for (Faculty faculty : facultyMembers) {
                faculty.displayFacultyInfo();
            }
            System.out.println();
        }

        public String getDepartmentName() {
            return departmentName;
        }
    }

    // University Class (Composition - contains Departments, and deleting it deletes all Departments)
    static class University {
        private String universityName;
        private List<Department> departments;

        // Constructor
        public University(String universityName) {
            this.universityName = universityName;
            this.departments = new ArrayList<>();
        }

        // Add department to the university
        public void addDepartment(Department department) {
            if (!departments.contains(department)) {
                departments.add(department);
            }
        }

        // Display all departments and their faculty members
        public void displayUniversityInfo() {
            System.out.println("University: " + universityName);
            for (Department department : departments) {
                department.displayDepartmentInfo();
            }
        }

        // Delete university and associated departments
        public void deleteUniversity() {
            // Explicitly nullify all departments to simulate deletion
            for (Department department : departments) {
                department = null;
            }
            departments = null;
            System.out.println("University " + universityName + " and all associated departments have been deleted.");
        }
    }

    // Main Method
    public static void main(String[] args) {
        // Create a university
        University university = new University("Greenwood University");

        // Create departments
        Department department1 = new Department("Computer Science");
        Department department2 = new Department("Mathematics");

        // Create faculty members
        Faculty faculty1 = new Faculty("Dr. Alice", "Professor");
        Faculty faculty2 = new Faculty("Dr. Bob", "Associate Professor");
        Faculty faculty3 = new Faculty("Dr. Carol", "Assistant Professor");

        // Add faculty to departments
        department1.addFaculty(faculty1);
        department1.addFaculty(faculty2);
        department2.addFaculty(faculty3);

        // Add departments to university
        university.addDepartment(department1);
        university.addDepartment(department2);

        // Display the university and its departments
        university.displayUniversityInfo();

        // Delete the university (this should delete all departments)
        university.deleteUniversity();

        // Attempt to display the university info after deletion
        if (university != null) {
            university.displayUniversityInfo();  // This should not display anything as the university has been deleted
        }
    }
}