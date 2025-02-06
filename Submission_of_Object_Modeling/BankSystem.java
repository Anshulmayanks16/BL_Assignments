public class BankSystem {

    // Account Class
    static class Account {
        private String accountNumber;
        private double balance;

        // Constructor
        public Account(String accountNumber, double initialDeposit) {
            this.accountNumber = accountNumber;
            this.balance = initialDeposit;
        }

        // Deposit money
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited $" + amount + " into Account " + accountNumber);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        // Withdraw money
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew $" + amount + " from Account " + accountNumber);
            } else {
                System.out.println("Invalid or insufficient funds for withdrawal.");
            }
        }

        // View balance
        public void viewBalance() {
            System.out.println("Account " + accountNumber + " Balance: $" + balance);
        }

        public String getAccountNumber() {
            return accountNumber;
        }
    }

    // Customer Class
    static class Customer {
        private String name;
        private String customerId;
        private Account[] accounts;
        private int accountCount;

        // Constructor
        public Customer(String name, String customerId, int maxAccounts) {
            this.name = name;
            this.customerId = customerId;
            this.accounts = new Account[maxAccounts];  // Fixed size array
            this.accountCount = 0;
        }

        // Add account to customer
        public void addAccount(Account account) {
            if (accountCount < accounts.length) {
                accounts[accountCount] = account;
                accountCount++;
            } else {
                System.out.println("Cannot open more accounts for " + name);
            }
        }

        // View all accounts
        public void viewAllAccounts() {
            System.out.println("Customer: " + name);
            for (int i = 0; i < accountCount; i++) {
                accounts[i].viewBalance();
            }
            System.out.println();
        }

        public String getName() {
            return name;
        }
    }

    // Bank Class
    static class Bank {
        private String bankName;
        private Customer[] customers;
        private int customerCount;

        // Constructor
        public Bank(String bankName, int maxCustomers) {
            this.bankName = bankName;
            this.customers = new Customer[maxCustomers];  // Fixed size array
            this.customerCount = 0;
        }

        // Open an account for a customer
        public void openAccount(Customer customer, String accountNumber, double initialDeposit) {
            Account newAccount = new Account(accountNumber, initialDeposit);
            customer.addAccount(newAccount);
            addCustomer(customer);
            System.out.println("Account " + accountNumber + " opened for " + customer.getName() + " at " + bankName);
        }

        // Add customer to the bank if not already added
        private void addCustomer(Customer customer) {
            boolean exists = false;
            for (int i = 0; i < customerCount; i++) {
                if (customers[i] == customer) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                if (customerCount < customers.length) {
                    customers[customerCount] = customer;
                    customerCount++;
                } else {
                    System.out.println("Bank has reached the maximum number of customers.");
                }
            }
        }

        // Display all customers and their accounts
        public void displayAllCustomers() {
            System.out.println("Bank: " + bankName);
            for (int i = 0; i < customerCount; i++) {
                customers[i].viewAllAccounts();
            }
        }
    }

    // Main Method
    public static void main(String[] args) {
        // Create a bank with a capacity for 5 customers
        Bank bank = new Bank("National Bank", 5);

        // Create customers with a capacity for 3 accounts each
        Customer customer1 = new Customer("Alice", "C001", 3);
        Customer customer2 = new Customer("Bob", "C002", 3);

        // Open accounts for customers
        bank.openAccount(customer1, "A1001", 500.0);
        bank.openAccount(customer1, "A1002", 1500.0);

        bank.openAccount(customer2, "B2001", 1000.0);
        bank.openAccount(customer2, "B2002", 2000.0);

        // Display all customers and their accounts in the bank
        bank.displayAllCustomers();

        // Demonstrate account operations
        customer1.viewAllAccounts();
        customer2.viewAllAccounts();

        // Deposits and Withdrawals
        customer1.accounts[0].deposit(200);
        customer1.accounts[1].withdraw(300);

        // View balances after transactions
        customer1.viewAllAccounts();
    }
}