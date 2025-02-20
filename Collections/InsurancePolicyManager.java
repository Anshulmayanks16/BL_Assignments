import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyHolderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InsurancePolicy that = (InsurancePolicy) obj;
        return policyNumber.equals(that.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Holder: " + policyHolderName +
               ", Expiry: " + expiryDate + ", Coverage: " + coverageType + ", Premium: $" + premiumAmount;
    }
}

public class InsurancePolicyManager {
    private Set<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("\nAll Unique Policies:");
        for (InsurancePolicy policy : hashSetPolicies) {
            System.out.println(policy);
        }
    }

    public void displayExpiringSoon() {
        System.out.println("\nPolicies Expiring Soon (Next 30 Days):");
        LocalDate today = LocalDate.now();
        for (InsurancePolicy policy : treeSetPolicies) {
            if (ChronoUnit.DAYS.between(today, policy.getExpiryDate()) <= 30) {
                System.out.println(policy);
            }
        }
    }

    public void displayPoliciesByCoverageType(String type) {
        System.out.println("\nPolicies with Coverage Type: " + type);
        for (InsurancePolicy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(policy);
            }
        }
    }

    public void findDuplicatePolicies() {
        System.out.println("\nDuplicate Policies:");
        Set<String> seen = new HashSet<>();
        for (InsurancePolicy policy : hashSetPolicies) {
            if (!seen.add(policy.getPolicyNumber())) {
                System.out.println(policy);
            }
        }
    }

    public void comparePerformance() {
        System.out.println("\nPerformance Comparison:");

        int numPolicies = 100000;
        List<InsurancePolicy> policies = new ArrayList<>();
        for (int i = 0; i < numPolicies; i++) {
            policies.add(new InsurancePolicy(
                "P" + i, "Holder" + i, LocalDate.now().plusDays(i), "Auto", 500 + (i % 100)
            ));
        }

        long startTime, endTime;

        // HashSet Performance
        startTime = System.nanoTime();
        Set<InsurancePolicy> hashSet = new HashSet<>(policies);
        endTime = System.nanoTime();
        System.out.println("HashSet add time: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        hashSet.contains(policies.get(numPolicies / 2));
        endTime = System.nanoTime();
        System.out.println("HashSet search time: " + (endTime - startTime) + " ns");

        // LinkedHashSet Performance
        startTime = System.nanoTime();
        Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>(policies);
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet add time: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        linkedHashSet.contains(policies.get(numPolicies / 2));
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet search time: " + (endTime - startTime) + " ns");

        // TreeSet Performance
        startTime = System.nanoTime();
        Set<InsurancePolicy> treeSet = new TreeSet<>(policies);
        endTime = System.nanoTime();
        System.out.println("TreeSet add time: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        treeSet.contains(policies.get(numPolicies / 2));
        endTime = System.nanoTime();
        System.out.println("TreeSet search time: " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        manager.addPolicy(new InsurancePolicy("P100", "Alice", LocalDate.now().plusDays(10), "Health", 1000.0));
        manager.addPolicy(new InsurancePolicy("P101", "Bob", LocalDate.now().plusDays(50), "Auto", 750.0));
        manager.addPolicy(new InsurancePolicy("P102", "Charlie", LocalDate.now().plusDays(20), "Home", 1200.0));
        manager.addPolicy(new InsurancePolicy("P103", "David", LocalDate.now().plusDays(5), "Health", 950.0));
        manager.addPolicy(new InsurancePolicy("P100", "Alice", LocalDate.now().plusDays(10), "Health", 1000.0)); // Duplicate

        manager.displayAllPolicies();
        manager.displayExpiringSoon();
        manager.displayPoliciesByCoverageType("Health");
        manager.findDuplicatePolicies();
        manager.comparePerformance();
    }
}
