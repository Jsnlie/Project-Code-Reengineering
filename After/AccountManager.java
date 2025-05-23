package cr;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountManager {
    private Account account;
    private Scanner input = new Scanner(System.in);
    private DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public AccountManager(Account account) {
        this.account = account;
    }

    public void getWithdrawInput(String accountType) {
        double amount = getInputAmount(accountType);
        if (isValidWithdrawal(amount, accountType)) {
            account.withdraw(accountType, amount);
            displayBalance(accountType);
        }
    }

    public void getDepositInput(String accountType) {
        double amount = getInputAmount(accountType);
        if (isValidDeposit(amount, accountType)) {
            account.deposit(accountType, amount);
            displayBalance(accountType);
        }
    }

    public void getTransferInput(String fromAccount) {
        System.out.println("\nSelect an account you wish to transfer funds to:");
        System.out.println("1. Savings");
        System.out.println("2. Checkings");
        System.out.print("\nChoice: ");
        int choice = input.nextInt();
        String toAccount = (choice == 1) ? "Savings" : "Checkings";
        double amount = getInputAmount(fromAccount);
        if (isValidTransfer(amount, fromAccount)) {
            account.transfer(fromAccount, toAccount, amount);
            displayBalance(fromAccount);
            displayBalance(toAccount);
        }
    }

    public void displayBalance(String accountType) { 
        double balance = accountType.equals("Checkings") ? account.getCheckingBalance() : account.getSavingBalance();
        System.out.println("\nCurrent " + accountType + " Account Balance: " + moneyFormat.format(balance));
    }

    private double getInputAmount(String accountType) {
        double amount = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("\nCurrent " + accountType + " Account Balance: " + moneyFormat.format(account.getCheckingBalance()));
                System.out.print("\nAmount you want to input for " + accountType + " Account: ");
                amount = input.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }
        return amount;
    }

    private boolean isValidWithdrawal(double amount, String accountType) {
        double balance = accountType.equals("Checkings") ? account.getCheckingBalance() : account.getSavingBalance();
        if ((balance - amount) < 0 || amount < 0) {
            System.out.println("\nBalance Cannot be Negative.");
            return false;
        }
        return true;
    }

    private boolean isValidDeposit(double amount, String accountType) {
        if (amount < 0) {
            System.out.println("\nBalance Cannot Be Negative.");
            return false;
        }
        return true;
    }

    private boolean isValidTransfer(double amount, String fromAccount) {
        double balance = fromAccount.equals("Checkings") ? account.getCheckingBalance() : account.getSavingBalance();
        if ((balance - amount) < 0 || amount < 0) {
            System.out.println("\nBalance Cannot Be Negative.");
            return false;
        }
        return true;
    }
}
