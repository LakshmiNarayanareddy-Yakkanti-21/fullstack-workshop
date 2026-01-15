import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private List<Account> accounts = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public void addAccount(Account acc) {
        accounts.add(acc);
    }

    public double getTotalDeposits() {
        double total = 0;
        for (Account acc : accounts) {
            total += acc.getBalance();
        }
        return total;
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }
}
