public class BankAccountManagement {

    // BankAccount Class
    public static class BankAccount {
        public String accountNumber;  // Public member
        protected String accountHolder;  // Protected member
        private double balance;      // Private member
        
        // Constructor
        public BankAccount(String accountNumber, String accountHolder, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = balance;
        }
        
        // Public method to access balance
        public double getBalance() {
            return this.balance;
        }
        
        // Public method to modify balance
        public void deposit(double amount) {
            if (amount > 0) {
                this.balance += amount;
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }
        
        public void withdraw(double amount) {
            if (amount > 0 && amount <= this.balance) {
                this.balance -= amount;
            } else {
                System.out.println("Insufficient balance or invalid amount.");
            }
        }
        
        // Method to display account details
        public void displayAccountDetails() {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolder);
            System.out.println("Balance: " + balance);
        }
    }

    // SavingsAccount Class (Subclass of BankAccount)
    public static class SavingsAccount extends BankAccount {
        private double interestRate;  // Additional member for interest rate
        
        // Constructor
        public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
            super(accountNumber, accountHolder, balance);
            this.interestRate = interestRate;
        }
        
        // Method to display savings account details
        @Override
        public void displayAccountDetails() {
            super.displayAccountDetails();  // Call the parent method
            System.out.println("Interest Rate: " + interestRate + "%");
        }
        
        // Method to calculate and add interest to balance
        public void applyInterest() {
            double interest = balance * (interestRate / 100);
            deposit(interest);
            System.out.println("Interest of " + interest + " applied to the balance.");
        }
        
        // Method to access protected 'accountHolder' and public 'accountNumber' from superclass
        public void printAccountInfo() {
            System.out.println("Account Number from SavingsAccount: " + accountNumber);
            System.out.println("Account Holder from SavingsAccount: " + accountHolder);
        }
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Create an instance of BankAccount
        BankAccount account1 = new BankAccount("123456", "Alice Green", 1500.00);
        account1.displayAccountDetails();
        
        // Modify balance using public methods
        account1.deposit(500.00);
        account1.withdraw(200.00);
        System.out.println("Updated Balance: " + account1.getBalance());
        
        // Create an instance of SavingsAccount
        SavingsAccount savingsAccount1 = new SavingsAccount("987654", "Bob White", 3000.00, 5.0);
        savingsAccount1.displayAccountDetails();
        
        // Apply interest to savings account
        savingsAccount1.applyInterest();
        savingsAccount1.displayAccountDetails();
        
        // Access protected 'accountHolder' and public 'accountNumber' from subclass
        savingsAccount1.printAccountInfo();
    }
}