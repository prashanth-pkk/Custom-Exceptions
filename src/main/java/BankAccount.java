public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withDraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdraw");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
