import java.util.*;

class BankingSystem {
    private Map<Integer, Double> accounts = new HashMap<>();
    private TreeMap<Double, List<Integer>> sortedBalances = new TreeMap<>();
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    static class WithdrawalRequest {
        int accountNumber;
        double amount;

        WithdrawalRequest(int accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }

    // Create a new account
    public void createAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        updateSortedBalances(accountNumber, initialBalance);
    }

    // Deposit money into an account
    public void deposit(int accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found: " + accountNumber);
            return;
        }
        double newBalance = accounts.get(accountNumber) + amount;
        accounts.put(accountNumber, newBalance);
        updateSortedBalances(accountNumber, newBalance);
    }

    // Request withdrawal (added to queue)
    public void requestWithdrawal(int accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found: " + accountNumber);
            return;
        }
        withdrawalQueue.offer(new WithdrawalRequest(accountNumber, amount));
        System.out.println("Withdrawal request added for Account " + accountNumber + ": $" + amount);
    }

    // Process withdrawals in FIFO order
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            int accNumber = request.accountNumber;
            double amount = request.amount;

            if (accounts.get(accNumber) >= amount) {
                double newBalance = accounts.get(accNumber) - amount;
                accounts.put(accNumber, newBalance);
                updateSortedBalances(accNumber, newBalance);
                System.out.println("Withdrawal of $" + amount + " processed for Account " + accNumber);
            } else {
                System.out.println("Insufficient funds for Account " + accNumber);
            }
        }
    }

    // Display all accounts sorted by balance
    public void displaySortedAccounts() {
        System.out.println("Accounts Sorted by Balance:");
        for (Map.Entry<Double, List<Integer>> entry : sortedBalances.entrySet()) {
            for (Integer account : entry.getValue()) {
                System.out.println("Account " + account + ": $" + entry.getKey());
            }
        }
    }

    // Update balance in TreeMap
    private void updateSortedBalances(int accountNumber, double newBalance) {
        sortedBalances.values().forEach(list -> list.remove((Integer) accountNumber));

        sortedBalances.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Create accounts
        bank.createAccount(101, 500.0);
        bank.createAccount(102, 1500.0);
        bank.createAccount(103, 800.0);

        // Deposit money
        bank.deposit(101, 200.0);
        bank.deposit(103, 100.0);

        // Request withdrawals
        bank.requestWithdrawal(102, 500.0);
        bank.requestWithdrawal(101, 1000.0); // Insufficient funds
        bank.requestWithdrawal(103, 300.0);

        // Process withdrawals
        bank.processWithdrawals();

        // Display sorted accounts
        bank.displaySortedAccounts();
    }
}
