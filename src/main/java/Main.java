public class Main {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount("Nidhi", "12345", 500.0);
        BankAccount transferAccount = new BankAccount("Vani", "12345", 0.0);

        //To verify the name and account number
        String verifyName = "Nidhi";
        String verifyAccountNumber = "12345";

        if (bankAccount.verifyAccountDetails(verifyName, verifyAccountNumber)) {
            System.out.println("Account verification successful");
        } else {
            System.out.println("Account verification failed");
        }

        //Withdraw amount
        try {
            bankAccount.withDraw(15000);
        } catch (InsufficientFundsException e) {
            System.out.println("Error : " + e.getMessage());
        }

        //Deposit zero amount
        try {
            bankAccount.deposit(0);
        } catch (ZeroDepositException e) {
            System.out.println("Error : " + e.getMessage());
        }

        // Deposit amount
        try {
            bankAccount.deposit(1000);
            System.out.println("Deposit successful. The balance : " + bankAccount.getBalance());
        } catch (ZeroDepositException e) {
            System.out.println("Error : " + e.getMessage());
        }

        //Transfer money
        try {
            bankAccount.transfer(transferAccount, 200);
            System.out.println("Transfer successful");
            System.out.println("Account 1 get balance : " + bankAccount.getBalance());
            System.out.println("Account 2 get balance : " + transferAccount.getBalance());
        } catch (InsufficientFundsException | ZeroDepositException e) {
            System.out.println("Error : " + e.getMessage());
        }

        //Reactivate the recipient account and retry transfer
        try {
            transferAccount.setActive(true);
            bankAccount.transfer(transferAccount, 100);
            System.out.println("Transfer successful");
            System.out.println("Account 1 get balance : " + bankAccount.getBalance());
            System.out.println("Account 2 get balance : " + bankAccount.getBalance());
        } catch (IllegalArgumentException | InsufficientFundsException | ZeroDepositException exception) {
            System.out.println("Error : " + exception.getMessage());
        }
    }
}
