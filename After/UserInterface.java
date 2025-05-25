package cr;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private AccountManager accountManager;
    private Scanner input = new Scanner(System.in);

    public UserInterface(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void displayAccountMenu() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nSelect the account you want to access: ");
                System.out.println(" Type 1 - Checkings Account");
                System.out.println(" Type 2 - Savings Account");
                System.out.println(" Type 3 - Exit");
                System.out.print("\nChoice: ");

                int selection = input.nextInt();

                switch (selection) {
                    case 1:
                        displayCheckingMenu();
                        break;
                    case 2:
                        displaySavingMenu();
                        break;
                    case 3:
                        end = true;
                        break;
                    default:
                        System.out.println("\nInvalid Choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }
    }

    private void displayCheckingMenu() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nCheckings Account: ");
                System.out.println(" Type 1 - View Balance");
                System.out.println(" Type 2 - Withdraw Funds");
                System.out.println(" Type 3 - Deposit Funds");
                System.out.println(" Type 4 - Transfer Funds");
                System.out.println(" Type 5 - Exit");
                System.out.print("\nChoice: ");

                int selection = input.nextInt();

                switch (selection) {
                    case 1:
                        accountManager.displayBalance("Checkings");
                        break;
                    case 2:
                        accountManager.getWithdrawInput("Checkings");
                        break;
                    case 3:
                        accountManager.getDepositInput("Checkings");
                        break;
                    case 4:
                        accountManager.getTransferInput("Checkings");
                        break;
                    case 5:
                        end = true;
                        break;
                    default:
                        System.out.println("\nInvalid Choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }
    }

    private void displaySavingMenu() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nSavings Account: ");
                System.out.println(" Type 1 - View Balance");
                System.out.println(" Type 2 - Withdraw Funds");
                System.out.println(" Type 3 - Deposit Funds");
                System.out.println(" Type 4 - Transfer Funds");
                System.out.println(" Type 5 - Exit");
                System.out.print("Choice: ");
                int selection = input.nextInt();
                switch (selection) {
                    case 1:
                        accountManager.displayBalance("Savings");
                        break;
                    case 2:
                        accountManager.getWithdrawInput("Savings");
                        break;
                    case 3:
                        accountManager.getDepositInput("Savings");
                        break;
                    case 4:
                        accountManager.getTransferInput("Savings");
                        break;
                    case 5:
                        end = true;
                        break;
                    default:
                        System.out.println("\nInvalid Choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }
    }
}

