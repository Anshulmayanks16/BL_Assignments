class BankAccount {
    // Static variable shared across all accounts
    private static String bankName = "ABC Bank";
    private static int totalAccounts = 0; // Keeps track of total accounts
    
    // Instance variables
    private String accountHolderName;
    private final int accountNumber; // Final variable, cannot be changed once assigned
    private double balance;
    
    // Constructor using 'this' to resolve ambiguity
    public BankAccount(String accountHolderName, int accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber; // Final variable initialized
        this.balance = initialBalance;
        totalAccounts++; // Increase total account count
    }
    
    // Static method to get total accounts
    public static void getTotalAccounts() {
        System.out.println("Total Accounts in " + bankName + ": " + totalAccounts);
    }
    
    // Method to display account details (using instanceof)
    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("\n=== Account Details ===");
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
        } else {
            System.out.println("Invalid Account Object");
        }
    }
}

// Main class to test the implementation
public class BankApp {
    public static void main(String[] args) {
        // Creating bank accounts
        BankAccount acc1 = new BankAccount("Alice Johnson", 1001, 5000.00);
        BankAccount acc2 = new BankAccount("Bob Smith", 1002, 3000.50);
        
        // Displaying account details
        acc1.displayAccountDetails();
        acc2.displayAccountDetails();
        
        // Display total number of accounts
        BankAccount.getTotalAccounts();
        
        // Checking instanceof usage
        System.out.println("\nIs acc1 an instance of BankAccount? " + (acc1 instanceof BankAccount));
    }
}