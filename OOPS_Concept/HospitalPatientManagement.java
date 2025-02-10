// Interface for managing medical records
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract class Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;

    // Constructor
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = "";
    }

    // Getters and Setters
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    protected String getDiagnosis() {
        return diagnosis;
    }

    protected void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    // Abstract method to calculate bill
    public abstract double calculateBill();

    // Method to display patient details
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Diagnosis: " + (diagnosis.isEmpty() ? "Not Diagnosed" : diagnosis));
    }
}

// InPatient class implementing MedicalRecord
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private StringBuilder medicalHistory;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
        this.medicalHistory = new StringBuilder();
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.append(record).append("\n");
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History:\n" + medicalHistory);
    }
}

// OutPatient class implementing MedicalRecord
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private StringBuilder medicalHistory;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalHistory = new StringBuilder();
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.append(record).append("\n");
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History:\n" + medicalHistory);
    }
}

// Main class to demonstrate the patient management system
public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient[] patients = new Patient[2];

        patients[0] = new InPatient("P001", "Alice Smith", 45, 5, 2000);
        patients[1] = new OutPatient("P002", "Bob Johnson", 30, 500);

        processPatients(patients);
    }

    public static void processPatients(Patient[] patients) {
        for (Patient patient : patients) {
            patient.getPatientDetails();
            patient.setDiagnosis("General Checkup");

            if (patient instanceof MedicalRecord) {
                ((MedicalRecord) patient).addRecord("Visited on 2024-02-10");
                ((MedicalRecord) patient).viewRecords();
            }

            System.out.println("Total Bill: $" + patient.calculateBill());
            System.out.println("-----------------------------");
        }
    }
}