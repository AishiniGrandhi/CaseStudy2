package package_1;

import java.util.ArrayList;
import java.util.List;

class TransactionHistory {
    private List<String> transactions = new ArrayList<>();

    public void addTransaction(String transaction) {
        transactions.add(transaction);
    }

    public void displayTransactions() {
        transactions.forEach(System.out::println);
    }
}

