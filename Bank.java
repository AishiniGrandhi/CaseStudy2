package package_1;

import java.util.HashMap;
import java.util.Map;

class Bank {
    private Map<String, BankAccount> accounts = new HashMap<>();

    public void createSavingsAccount(String accountNumber, Customer customer, double initialBalance) {
        accounts.put(accountNumber, new SavingsAccount(accountNumber, customer, initialBalance));
        System.out.println("Account created for " + customer.getName());
    }

    public void createCurrentAccount(String accountNumber, Customer customer, double initialBalance, double overdraftLimit) {
        accounts.put(accountNumber, new CurrentAccount(accountNumber, customer, initialBalance, overdraftLimit));
        System.out.println("Current Account created for " + customer.getName());
    }

    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void deposit(String accountNumber, double amount) {
        BankAccount account = getAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        BankAccount account = getAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
            System.out.println("Successfully withdrawn $" + amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void displayAccountDetails(String accountNumber) {
        BankAccount account = getAccount(accountNumber);
        if (account != null) {
            account.displayAccountInfo();
        } else {
            System.out.println("Account not found!");
        }
    }

    public void transferFunds(String fromAccount, String toAccount, double amount) {
        BankAccount source = getAccount(fromAccount);
        BankAccount target = getAccount(toAccount);
        
        if (source != null && target != null) {
            source.withdraw(amount);
            target.deposit(amount);
            System.out.println("Successfully transferred $" + amount);
        } else {
            System.out.println("One or both accounts not found!");
        }
    }

    public void calculateInterest(String accountNumber) {
        BankAccount account = getAccount(accountNumber);
        if (account instanceof SavingsAccount) {
            ((SavingsAccount) account).calculateInterest();
        } else {
            System.out.println("Interest calculation is only available for Savings Accounts!");
        }
    }

    public void updateAccountHolderName(String accountNumber, String newName) {
        BankAccount account = getAccount(accountNumber);
        if (account != null) {
            account.getCustomer().setName(newName);
            System.out.println("Account holder name updated successfully!");
        } else {
            System.out.println("Account not found!");
        }
    }

    public void closeAccount(String accountNumber) {
        if (accounts.remove(accountNumber) != null) {
            System.out.println("Account closed successfully!");
        } else {
            System.out.println("Account not found!");
        }
    }
}