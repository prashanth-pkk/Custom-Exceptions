public class BankAccount {
    private String name;
    private String accountNumber;
    private double balance;
    private boolean active;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public BankAccount(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.active = true;
    }

    public void withDraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdraw");
        }
        balance -= amount;
    }

    public void deposit(double depositAmount) throws ZeroDepositException {
        if (depositAmount <= 0) {
            throw new ZeroDepositException("Deposit amount must be greater than zero");
        }
        balance += depositAmount;
    }

    //Verify the account details
    public boolean verifyAccountDetails(String name, String accountNumber) {
        return this.name.equals(name) && this.accountNumber.equals(accountNumber);
    }

    //Transfer money
    public void transfer(BankAccount recipient, double amount) throws InsufficientFundsException, ZeroDepositException {
        if(recipient == null){
            throw new InsufficientFundsException("The recipient account can't be zero");
        }
        if(recipient.isActive()){
            throw  new IllegalArgumentException("Recipient account is not active");
        }
        if(amount <= 0){
            throw  new ZeroDepositException("The transfer amount more than zero");
        }
        if(amount > balance){
            throw new InsufficientFundsException("Insufficient balance to transfer money");
        }
        this.withDraw(amount);
        recipient.deposit(amount);
    }
}
