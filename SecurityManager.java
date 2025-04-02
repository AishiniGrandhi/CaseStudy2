package package_1;

class SecurityManager {
    public static boolean authenticate(BankAccount account, String password) {
        if (password=="123")) {
            return true;
        } else {
            System.out.println("Incorrect password! Access denied.");
            return false;
        }
    }
}
