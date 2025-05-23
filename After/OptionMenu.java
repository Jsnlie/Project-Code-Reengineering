package cr;

import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OptionMenu {
    private static final int DEFAULT_CUSTOMER_NUMBER_1 = 952141;
    private static final int DEFAULT_PIN_1 = 191904;
    private static final int DEFAULT_CUSTOMER_NUMBER_2 = 123;
    private static final int DEFAULT_PIN_2 = 123;

    private Scanner menuInput = new Scanner(System.in);
    private HashMap<Integer, Account> data = new HashMap<>();

    public OptionMenu() {
        data.put(DEFAULT_CUSTOMER_NUMBER_1, new Account(DEFAULT_CUSTOMER_NUMBER_1, DEFAULT_PIN_1, 1000, 5000));
        data.put(DEFAULT_CUSTOMER_NUMBER_2, new Account(DEFAULT_CUSTOMER_NUMBER_2, DEFAULT_PIN_2, 20000, 50000));
    }

    public void getLogin() throws IOException {
        boolean end = false;
        int customerNumber = 0;
        int pinNumber = 0;
        while (!end) {
            try {
                System.out.print("\nEnter your customer number: ");
                customerNumber = menuInput.nextInt();
                System.out.print("\nEnter your PIN number: ");
                pinNumber = menuInput.nextInt();
                if (data.containsKey(customerNumber) && pinNumber == data.get(customerNumber).getPinNumber()) {
                    getAccountType(data.get(customerNumber));
                    end = true;
                } else {
                    System.out.println("\nWrong Customer Number or Pin Number");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Character(s). Only Numbers.");
                menuInput.next();
            }
        }
    }

    public void getAccountType(Account acc) {
        AccountManager accountManager = new AccountManager(acc);
        UserInterface userInterface = new UserInterface(accountManager);
        userInterface.displayAccountMenu();
    }

    public void createAccount() throws IOException {
        int cst_no = 0;
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nEnter your customer number ");
                cst_no = menuInput.nextInt();
                if (!data.containsKey(cst_no)) {
                    end = true;
                } else {
                    System.out.println("\nThis customer number is already registered");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                menuInput.next();
            }
        }
        System.out.println("\nEnter PIN to be registered");
        int pin = menuInput.nextInt();
        data.put(cst_no, new Account(cst_no, pin));
        System.out.println("\nYour new account has been successfully registered!");
        System.out.println("\nRedirecting to login.............");
        getLogin();
    }

    public void mainMenu() throws IOException {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\n Type 1 - Login");
                System.out.println(" Type 2 - Create Account");
                System.out.print("\nChoice: ");
                int choice = menuInput.nextInt();
                switch (choice) {
                    case 1:
                        getLogin();
                        end = true;
                        break;
                    case 2:
                        createAccount();
                        end = true;
                        break;
                    default:
                        System.out.println("\nInvalid Choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                menuInput.next();
            }
        }
        System.out.println("\nThank You for using this ATM.\n");
        menuInput.close();
        System.exit(0);
    }
}

