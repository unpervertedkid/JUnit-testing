package annotations;

public class BankAccount {
    private double minimumBalance;
    private double balance;
    private State state = State.ACTIVE;

    public BankAccount(double minimumBalance, double balance){
        this.minimumBalance = minimumBalance;
        this.balance = balance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return state == State.ACTIVE;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;

    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new RuntimeException("Deposit amount must be 1 or larger");
        }
    }

    public void withdraw(double amount) {
        if (balance - amount >= minimumBalance) {
            balance -= amount;
        } else {
            throw new RuntimeException("Cannot withdraw below the minimum balance");
        }
    }
}
