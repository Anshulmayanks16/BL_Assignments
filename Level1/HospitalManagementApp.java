class Patient {
    // Static variables shared across all patients
    private static String hospitalName = "City General Hospital";
    private static int totalPatients = 0; // Keeps track of total admitted patients
    
    // Instance variables
    private String name;
    private int age;
    private String ailment;
    private final int patientID; // Final variable, cannot be changed once assigned
    
    // Constructor using 'this' to resolve ambiguity
    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID; // Final variable initialized
        totalPatients++; // Increase total patient count
    }
    
    // Static method to display total patients
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted at " + hospitalName + ": " + totalPatients);
    }
    
    // Method to display patient details (using instanceof)
    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("\n=== Patient Details ===");
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        } else {
            System.out.println("Invalid Patient Object");
        }
    }
}

// Main class to test the implementation
public class HospitalManagementApp {
    public static void main(String[] args) {
        // Creating patient objects
        Patient patient1 = new Patient("Alice Brown", 30, "Flu", 101);
        Patient patient2 = new Patient("Bob Williams", 45, "Diabetes", 102);
        
        // Display patient details
        patient1.displayPatientDetails();
        patient2.displayPatientDetails();
        
        // Display total patients admitted
        Patient.getTotalPatients();
        
        // Checking instanceof usage
        System.out.println("\nIs patient1 an instance of Patient? " + (patient1 instanceof Patient));
    }
}
