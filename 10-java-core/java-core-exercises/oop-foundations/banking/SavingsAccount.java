import java.util.*;

public class SavingsAccount extends Account {

    private static final double RATE = 0.04;
    private static final double MIN_BALANCE = 100;

    public SavingsAccount(String name, double balance) {
        super(name, balance);
    }

    public double calculateInterest() {
        return balance * RATE;
    }

    public void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            super.withdraw(amount);
        } else {
            System.out.println("Minimum balance required");
        }
    }
}
