// Interface for Loanable accounts
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Concrete method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Concrete method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    // Abstract method to calculate interest
    public abstract double calculateInterest();

    // Method to display account details
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

// SavingsAccount class implementing Loanable
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * (interestRate / 100);
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan application submitted for amount: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() > 1000;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Interest: " + calculateInterest());
        System.out.println("Loan Eligibility: " + (calculateLoanEligibility() ? "Eligible" : "Not Eligible"));
    }
}

// CurrentAccount class implementing Loanable
class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return 0; // Current accounts typically don't earn interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan application submitted for amount: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() + overdraftLimit > 2000;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Overdraft Limit: " + overdraftLimit);
        System.out.println("Loan Eligibility: " + (calculateLoanEligibility() ? "Eligible" : "Not Eligible"));
    }
}

// Main class to demonstrate the banking system
public class BankingSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[2];

        accounts[0] = new SavingsAccount("SAV123", "Alice", 5000, 4);
        accounts[1] = new CurrentAccount("CUR456", "Bob", 1500, 1000);

        for (int i = 0; i < accounts.length; i++) {
            accounts[i].displayDetails();
            accounts[i].deposit(1000);
            accounts[i].withdraw(500);
            System.out.println("Interest Earned: " + accounts[i].calculateInterest());

            if (accounts[i] instanceof Loanable) {
                ((Loanable) accounts[i]).applyForLoan(2000);
            }

            System.out.println("-----------------------------");
        }
    }
}