import java.util.*;
import java.time.LocalDate;

class InsurancePolicy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy{" + "Number='" + policyNumber + "', Holder='" + policyholderName + "', Expiry=" + expiryDate +
               ", Type='" + coverageType + "', Premium=" + premiumAmount + "}";
    }
}

public class InsurancePolicyManagement {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>();
    private LinkedHashMap<String, InsurancePolicy> orderedPolicies = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<InsurancePolicy>> sortedByExpiry = new TreeMap<>();

    // Add a policy
    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicies.put(policy.policyNumber, policy);

        sortedByExpiry.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
    }

    // Retrieve policy by number
    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List all policies expiring within the next 30 days
    public List<InsurancePolicy> getExpiringPolicies() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);
        List<InsurancePolicy> expiring = new ArrayList<>();

        for (Map.Entry<LocalDate, List<InsurancePolicy>> entry : sortedByExpiry.subMap(today, true, limit, true).entrySet()) {
            expiring.addAll(entry.getValue());
        }
        return expiring;
    }

    // List all policies for a specific policyholder
    public List<InsurancePolicy> getPoliciesByHolder(String policyholderName) {
        List<InsurancePolicy> holderPolicies = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.policyholderName.equalsIgnoreCase(policyholderName)) {
                holderPolicies.add(policy);
            }
        }
        return holderPolicies;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, List<InsurancePolicy>>> it = sortedByExpiry.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<LocalDate, List<InsurancePolicy>> entry = it.next();
            if (entry.getKey().isBefore(today)) {
                for (InsurancePolicy policy : entry.getValue()) {
                    policyMap.remove(policy.policyNumber);
                    orderedPolicies.remove(policy.policyNumber);
                }
                it.remove();
            }
        }
    }

    // Display all policies
    public void displayAllPolicies() {
        System.out.println("All Policies:");
        for (InsurancePolicy policy : orderedPolicies.values()) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagement manager = new InsurancePolicyManagement();

        // Adding sample policies
        manager.addPolicy(new InsurancePolicy("P101", "Alice", LocalDate.now().plusDays(15), "Health", 5000));
        manager.addPolicy(new InsurancePolicy("P102", "Bob", LocalDate.now().plusDays(40), "Auto", 3000));
        manager.addPolicy(new InsurancePolicy("P103", "Alice", LocalDate.now().plusDays(10), "Home", 7000));
        manager.addPolicy(new InsurancePolicy("P104", "Charlie", LocalDate.now().minusDays(5), "Health", 6000));

        // Retrieve a policy
        System.out.println("Policy P101: " + manager.getPolicyByNumber("P101"));

        // Get policies expiring within 30 days
        System.out.println("Expiring Policies: " + manager.getExpiringPolicies());

        // Get policies for a specific policyholder
        System.out.println("Alice's Policies: " + manager.getPoliciesByHolder("Alice"));

        // Remove expired policies
        manager.removeExpiredPolicies();
        System.out.println("After removing expired policies:");
        manager.displayAllPolicies();
    }
}
