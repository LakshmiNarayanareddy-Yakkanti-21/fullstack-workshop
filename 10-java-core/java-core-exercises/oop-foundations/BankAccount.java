import java.util.*;

public class BankAccount {

    private static String bankName = "MyBank";
    private static int totalAccounts = 0;
    private static int accountCounter = 1000;

    private int accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String holderName, double balance) {
        this.accountNumber = ++accountCounter;
        this.holderName = holderName;
        this.balance = balance;
        totalAccounts++;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public double getBalance() {
        return balance;
    }

    public static String getBankInfo() {
        return bankName + " - Total Accounts: " + totalAccounts;
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice", 1000);
        BankAccount acc2 = new BankAccount("Bob", 500);

        System.out.println(BankAccount.getBankInfo());
    }
}
