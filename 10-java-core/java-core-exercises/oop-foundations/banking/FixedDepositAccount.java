import java.util.*;

public class FixedDepositAccount extends Account {

    private static final double RATE = 0.07;

    public FixedDepositAccount(String name, double balance) {
        super(name, balance);
    }

    public double calculateInterest() {
        return balance * RATE;
    }

    public void withdraw(double amount) {
        throw new RuntimeException("Withdrawal not allowed");
    }
}
