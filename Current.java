package package_1;

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, Customer customer, double balance, double overdraftLimit) {
        super(accountNumber, customer, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance() + overdraftLimit) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawal of $" + amount + " successful. New balance: $" + getBalance());
        } else {
            System.out.println("Withdrawal denied! Exceeds overdraft limit.");
        }
    }

    private void setBalance(double d) {
		// TODO Auto-generated method stub
		
	}

	public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("Current Account: " + getAccountNumber());
        System.out.println("Account Holder: " + getCustomer().getName());
        System.out.println("Balance: $" + getBalance());
        System.out.println("Overdraft Limit: $" + overdraftLimit);
    }

	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		
	}
}
