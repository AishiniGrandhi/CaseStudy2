package package_1;

public class CurrentAccount extends BankAccount {
    private double overdraftLimit;
    
    public CurrentAccount(String accountNumber, Customer customer, double initialBalance, double overdraftLimit) {
        super(accountNumber, customer, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }
    
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.addTransaction("Deposit", amount);
        }
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance + overdraftLimit) >= amount) {
            balance -= amount;
            transactionHistory.addTransaction("Withdrawal", amount);
        }
    }
    
    @Override
    public void displayAccountInfo() {
        System.out.println("Current Account Details:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Balance: $" + balance);
        System.out.println("Overdraft Limit: $" + overdraftLimit);
    }
    
    public double getOverdraftLimit() {
        return overdraftLimit;
    }
    
    public void setOverdraftLimit(double limit) {
        if (limit >= 0) {
            this.overdraftLimit = limit;
        }
    }
}
