package package_1;

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, Customer customer, double initialBalance) {
        super(accountNumber, customer, initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.addTransaction("Deposited: " + amount);
            System.out.println("Deposited: " + amount + ". New Balance: " + balance);
        }
    } 

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.addTransaction("Withdrawn: " + amount);
            System.out.println("Withdrawn: " + amount + ". Remaining Balance: " + balance);
        }
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("Account: " + accountNumber + " | Holder: " + customer.getName() + " | Balance: " + balance);
        transactionHistory.displayTransactions();
    }

	public void calculateInterest() {
		// TODO Auto-generated method stub
		
	}
}

