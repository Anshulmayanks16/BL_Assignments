import java.util.ArrayList;
import java.util.List;

public class HospitalSystem {

    // Doctor Class (Association - can consult with multiple patients)
    static class Doctor {
        private String name;
        private String specialty;
        private List<Patient> patients;

        // Constructor
        public Doctor(String name, String specialty) {
            this.name = name;
            this.specialty = specialty;
            this.patients = new ArrayList<>();
        }

        // Add a patient to the doctor's list
        public void addPatient(Patient patient) {
            if (!patients.contains(patient)) {
                patients.add(patient);
            }
        }

        // Consultation between a doctor and a patient
        public void consult(Patient patient) {
            if (patients.contains(patient)) {
                System.out.println("Dr. " + name + " (Specialty: " + specialty + ") is consulting with " + patient.getName() + ".");
                // Simulate consultation
                patient.receiveConsultation(this);
            } else {
                System.out.println("Dr. " + name + " has not seen " + patient.getName() + " yet.");
            }
        }

        public String getName() {
            return name;
        }

        public String getSpecialty() {
            return specialty;
        }
    }

    // Patient Class (Association - can consult with multiple doctors)
    static class Patient {
        private String name;
        private int age;
        private List<Doctor> doctors;

        // Constructor
        public Patient(String name, int age) {
            this.name = name;
            this.age = age;
            this.doctors = new ArrayList<>();
        }

        // Add a doctor to the patient's list
        public void addDoctor(Doctor doctor) {
            if (!doctors.contains(doctor)) {
                doctors.add(doctor);
            }
        }

        // Method to simulate patient receiving a consultation
        public void receiveConsultation(Doctor doctor) {
            System.out.println(patientName() + " is receiving consultation from Dr. " + doctor.getName() + " (Specialty: " + doctor.getSpecialty() + ").");
        }

        public String getName() {
            return name;
        }

        private String patientName() {
            return "Patient " + name;
        }
    }

    // Hospital Class (Manages doctors and patients)
    static class Hospital {
        private String hospitalName;
        private List<Doctor> doctors;
        private List<Patient> patients;

        // Constructor
        public Hospital(String hospitalName) {
            this.hospitalName = hospitalName;
            this.doctors = new ArrayList<>();
            this.patients = new ArrayList<>();
        }

        // Add doctor to the hospital
        public void addDoctor(Doctor doctor) {
            if (!doctors.contains(doctor)) {
                doctors.add(doctor);
            }
        }

        // Add patient to the hospital
        public void addPatient(Patient patient) {
            if (!patients.contains(patient)) {
                patients.add(patient);
            }
        }

        // Display the hospital information
        public void displayHospitalInfo() {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Doctors:");
            for (Doctor doctor : doctors) {
                System.out.println("Dr. " + doctor.getName() + " (Specialty: " + doctor.getSpecialty() + ")");
            }
            System.out.println("Patients:");
            for (Patient patient : patients) {
                System.out.println("Patient: " + patient.getName() + " (Age: " + patient.age + ")");
            }
        }
    }

    // Main Method
    public static void main(String[] args) {
        // Create a hospital
        Hospital hospital = new Hospital("Greenwood Medical Center");

        // Create doctors
        Doctor doctor1 = new Doctor("Alice", "Cardiology");
        Doctor doctor2 = new Doctor("Bob", "Orthopedics");

        // Create patients
        Patient patient1 = new Patient("John", 30);
        Patient patient2 = new Patient("Mary", 25);

        // Add doctors and patients to the hospital
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        // Link doctors and patients
        doctor1.addPatient(patient1);
        doctor1.addPatient(patient2);
        doctor2.addPatient(patient1);

        patient1.addDoctor(doctor1);
        patient1.addDoctor(doctor2);
        patient2.addDoctor(doctor1);

        // Display hospital information
        hospital.displayHospitalInfo();

        // Simulate consultations
        doctor1.consult(patient1);
        doctor2.consult(patient1);
        doctor1.consult(patient2);
        doctor2.consult(patient2);
    }
}