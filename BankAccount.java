package package_1;

abstract class BankAccount implements BankOperations {
    protected String accountNumber;
    protected Customer customer;
    protected double balance;
    protected TransactionHistory transactionHistory;

    public BankAccount(String accountNumber, Customer customer, double initialBalance) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = initialBalance;
        this.transactionHistory = new TransactionHistory();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }
}

