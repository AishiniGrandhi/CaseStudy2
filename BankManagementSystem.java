package package_1;
import java.util.Scanner;

public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n===== Bank Management System =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Display Account Details");
            System.out.println("5. Transfer Funds");
            System.out.println("6. Calculate Interest");
            System.out.println("7. Update Account Holder Name");
            System.out.println("8. Close Account");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Create Account
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter account number: ");
                    String accNumber = scanner.nextLine();

                    System.out.print("Enter initial deposit: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    System.out.println("Select account type:");
                    System.out.println("1. Savings Account");
                    System.out.println("2. Current Account");
                    System.out.print("Enter choice (1 or 2): ");
                    int accountType = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Customer customer = new Customer(name);
                    
                    if (accountType == 1) {
                        bank.createSavingsAccount(accNumber, customer, balance);
                    } else if (accountType == 2) {
                        System.out.print("Enter overdraft limit: ");
                        double overdraftLimit = scanner.nextDouble();
                        bank.createCurrentAccount(accNumber, customer, balance, overdraftLimit);
                    }
                    break;

                case 2: // Deposit Money
                    System.out.print("Enter account number: ");
                    String depositAcc = scanner.nextLine();

                    System.out.print("Enter deposit amount: ");
                    double deposit = scanner.nextDouble();

                    BankAccount depositAccount = bank.getAccount(depositAcc);
                    if (depositAccount != null) {
                        depositAccount.deposit(deposit);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3: // Withdraw Money
                    System.out.print("Enter account number: ");
                    String withdrawAcc = scanner.nextLine();

                    System.out.print("Enter withdrawal amount: ");
                    double withdrawal = scanner.nextDouble();

                    BankAccount withdrawAccount = bank.getAccount(withdrawAcc);
                    if (withdrawAccount != null) {
                        withdrawAccount.withdraw(withdrawal);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4: // Display Account Details
                    System.out.print("Enter account number: ");
                    String displayAcc = scanner.nextLine();

                    BankAccount displayAccount = bank.getAccount(displayAcc);
                    if (displayAccount != null) {
                        displayAccount.displayAccountInfo();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5: // Transfer Funds
                    System.out.print("Enter sender's account number: ");
                    String senderAcc = scanner.nextLine();

                    System.out.print("Enter receiver's account number: ");
                    String receiverAcc = scanner.nextLine();

                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();

                    BankAccount sender = bank.getAccount(senderAcc);
                    BankAccount receiver = bank.getAccount(receiverAcc);

                    if (sender != null && receiver != null) {
                        if (sender.getBalance() >= transferAmount) {
                            sender.withdraw(transferAmount);
                            receiver.deposit(transferAmount);
                            System.out.println("Transfer successful.");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    } else {
                        System.out.println("Invalid account details.");
                    }
                    break;

                case 6: // Calculate Interest
                    System.out.print("Enter account number: ");
                    String interestAcc = scanner.nextLine();

                    System.out.print("Enter interest rate (%): ");
                    double rate = scanner.nextDouble();

                    BankAccount interestAccount = bank.getAccount(interestAcc);
                    if (interestAccount != null) {
                        double interest = interestAccount.getBalance() * rate / 100;
                        System.out.println("Interest Amount: " + interest);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 7: // Update Account Holder Name
                    System.out.print("Enter account number: ");
                    String updateAcc = scanner.nextLine();

                    System.out.print("Enter new account holder name: ");
                    String newName = scanner.nextLine();

                    BankAccount updateAccount = bank.getAccount(updateAcc);
                    if (updateAccount != null) {
                        updateAccount.getCustomer().setName(newName);
                        System.out.println("Account holder name updated successfully.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 8: // Close Account
                    System.out.print("Enter account number: ");
                    String closeAcc = scanner.nextLine();

                    if (bank.getAccount(closeAcc) != null) {
                        bank.closeAccount(closeAcc);
                        System.out.println("Account closed successfully.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 9: // Exit
                    System.out.println("Thank you for using our banking system!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
