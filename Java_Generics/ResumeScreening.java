
import java.util.*;

// 1. Abstract JobRole (Parent Class)
abstract class JobRole {
    private String candidateName;
    private int yearsOfExperience;

    public JobRole(String candidateName, int yearsOfExperience) {
        this.candidateName = candidateName;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    // Abstract method for job-specific evaluation
    public abstract void evaluateResume();

    // Common details display
    public void displayCandidateDetails() {
        System.out.println("Candidate: " + candidateName + ", Experience: " + yearsOfExperience + " years");
    }
}

// 2. Specific Job Role Classes
class SoftwareEngineer extends JobRole {
    private String primaryLanguage;

    public SoftwareEngineer(String candidateName, int yearsOfExperience, String primaryLanguage) {
        super(candidateName, yearsOfExperience);
        this.primaryLanguage = primaryLanguage;
    }

    @Override
    public void evaluateResume() {
        System.out.println(" Evaluating Software Engineer Resume (Language: " + primaryLanguage + ")");
    }
}

class DataScientist extends JobRole {
    private String preferredTool;

    public DataScientist(String candidateName, int yearsOfExperience, String preferredTool) {
        super(candidateName, yearsOfExperience);
        this.preferredTool = preferredTool;
    }

    @Override
    public void evaluateResume() {
        System.out.println(" Evaluating Data Scientist Resume (Tool: " + preferredTool + ")");
    }
}

class ProductManager extends JobRole {
    private String domainExpertise;

    public ProductManager(String candidateName, int yearsOfExperience, String domainExpertise) {
        super(candidateName, yearsOfExperience);
        this.domainExpertise = domainExpertise;
    }

    @Override
    public void evaluateResume() {
        System.out.println(" Evaluating Product Manager Resume (Domain: " + domainExpertise + ")");
    }
}

// 3. Generic Resume Class (Type-Safe Resume Handling)
class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    public void displayResumeDetails() {
        jobRole.displayCandidateDetails();
        jobRole.evaluateResume();
    }
}

// 4. Resume Screening Manager (Manages Screening Pipeline)
class ResumeScreeningSystem {
    private List<Resume<? extends JobRole>> resumes = new ArrayList<>();

    // Generic Method to Add Resume
    public <T extends JobRole> void addResume(Resume<T> resume) {
        resumes.add(resume);
    }

    // Wildcard Method to Process All Resumes
    public void processAllResumes() {
        System.out.println("\n Screening All Resumes:");
        for (Resume<? extends JobRole> resume : resumes) {
            resume.displayResumeDetails();
            System.out.println("--------------------------------");
        }
    }

    // Generic Method to Screen Specific Resume
    public <T extends JobRole> void screenResume(Resume<T> resume) {
        System.out.println("\n Screening Resume for: " + resume.getJobRole().getCandidateName());
        resume.displayResumeDetails();
    }
}

// 5. Main Class (Running the System)
public class ResumeScreening {
    public static void main(String[] args) {
        // Create Specific Job Role Resumes
        SoftwareEngineer se = new SoftwareEngineer("Alice", 5, "Java");
        DataScientist ds = new DataScientist("Bob", 3, "TensorFlow");
        ProductManager pm = new ProductManager("Charlie", 7, "E-Commerce");

        // Wrap in Generic Resume Class
        Resume<SoftwareEngineer> seResume = new Resume<>(se);
        Resume<DataScientist> dsResume = new Resume<>(ds);
        Resume<ProductManager> pmResume = new Resume<>(pm);

        // AI Resume Screening System
        ResumeScreeningSystem screeningSystem = new ResumeScreeningSystem();

        // Add Resumes to the System
        screeningSystem.addResume(seResume);
        screeningSystem.addResume(dsResume);
        screeningSystem.addResume(pmResume);

        // Process All Resumes
        screeningSystem.processAllResumes();

        // Screen Specific Resume
        screeningSystem.screenResume(new Resume<>(new DataScientist("Eve", 4, "PyTorch")));
    }
}