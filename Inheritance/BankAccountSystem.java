// Superclass BankAccount
class BankAccount {
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter methods
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

// Subclass SavingsAccount
class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);  // Calling superclass constructor
        this.interestRate = interestRate;
    }

    // Getter method
    public double getInterestRate() {
        return interestRate;
    }

    // Display account type
    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        displayAccountDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Subclass CheckingAccount
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    // Constructor
    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);  // Calling superclass constructor
        this.withdrawalLimit = withdrawalLimit;
    }

    // Getter method
    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    // Display account type
    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        displayAccountDetails();
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}

// Subclass FixedDepositAccount
class FixedDepositAccount extends BankAccount {
    private int maturityPeriod; // in months

    // Constructor
    public FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);  // Calling superclass constructor
        this.maturityPeriod = maturityPeriod;
    }

    // Getter method
    public int getMaturityPeriod() {
        return maturityPeriod;
    }

    // Display account type
    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        displayAccountDetails();
        System.out.println("Maturity Period: " + maturityPeriod + " months");
    }
}

// Main class to test
public class BankAccountSystem {
    public static void main(String[] args) {
        // Creating a SavingsAccount
        SavingsAccount savings = new SavingsAccount("SA12345", 5000.0, 3.5);

        // Creating a CheckingAccount
        CheckingAccount checking = new CheckingAccount("CA54321", 2000.0, 1000.0);

        // Creating a FixedDepositAccount
        FixedDepositAccount fixedDeposit = new FixedDepositAccount("FDA98765", 10000.0, 24);

        // Displaying account types and details
        System.out.println("Savings Account Details:");
        savings.displayAccountType();

        System.out.println("\nChecking Account Details:");
        checking.displayAccountType();

        System.out.println("\nFixed Deposit Account Details:");
        fixedDeposit.displayAccountType();
    }
}