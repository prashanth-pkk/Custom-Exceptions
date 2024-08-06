package service;

import model.AccountType;
import model.BankAccount;

import java.util.Scanner;

public class BankAccountManager {
    private Scanner scanner = new Scanner(System.in);

    public BankAccount createBankAccount() {
        System.out.println("Enter the account holder name");
        String name = scanner.nextLine();
        System.out.println("Enter the account number");
        String accountNumber = scanner.nextLine();
        AccountType accountType = null;
        while (accountType == null) {
            System.out.println("Enter account type (CURRENT_ACCOUNT, FIXED_ACCOUNT, SALARY_ACCOUNT, SAVING_ACCOUNT)");
            String type = scanner.nextLine().toUpperCase();

            try {
                accountType = AccountType.valueOf(type);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid account type. Default is SAVINGS");
            }
        }
        return new BankAccount(name, accountNumber, accountType);
    }

    //Method to perform operations on Bank account
    public void manageAccount(BankAccount account) {
        while (true) {
            System.out.println("choose an option: ");
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Exit");
            System.out.println("enter the number");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter deposit amount : ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("The deposit is successful. Balance: " + account.getBalance());
                    break;

                case 2:
                    System.out.println("Enter withdrawal amount");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withDraw(withdrawalAmount);
                    System.out.println("The withdrawal successful. Balance : " + account.getBalance());
                    break;

                case 3:
                    System.out.println("Enter recipient account number: ");
                    String recipientAccountNumber = scanner.nextLine();
                    BankAccount recipient = createBankAccount();
                    System.out.println("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    account.transfer(recipient, transferAmount);
                    System.out.println("Your balance: " + account.getBalance());
                    System.out.println("Recipient balance: " + recipient.getBalance());
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option");

            }

        }
    }
}