public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(10000.0);
        try {
            bankAccount.withDraw(15000);
        } catch (InsufficientFundsException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
