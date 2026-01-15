import java.util.*;

public class CheckingAccount extends Account {

    private static final double OVERDRAFT = 500;

    public CheckingAccount(String name, double balance) {
        super(name, balance);
    }

    public double calculateInterest() {
        return 0;
    }

    public void withdraw(double amount) {
        if (amount <= balance + OVERDRAFT) {
            balance -= amount;
        } else {
            System.out.println("Overdraft limit exceeded");
        }
    }
}
