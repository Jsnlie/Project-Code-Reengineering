package cr;

import java.text.DecimalFormat;

public class Account {
    // Constants for account types
    private static final String CHECKINGS = "Checkings";
    private static final String SAVINGS = "Savings";

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public Account(int customerNumber, int pinNumber) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
    }

    public Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void deposit(String accountType, double amount) {
        if (accountType.equals(CHECKINGS)) {
            checkingBalance += amount;
        } else if (accountType.equals(SAVINGS)) {
            savingBalance += amount;
        }
    }

    public void withdraw(String accountType, double amount) {
        if (accountType.equals(CHECKINGS)) {
            checkingBalance -= amount;
        } else if (accountType.equals(SAVINGS)) {
            savingBalance -= amount;
        }
    }

    public void transfer(String fromAccount, String toAccount, double amount) {
        if (fromAccount.equals(CHECKINGS) && toAccount.equals(SAVINGS)) {
            withdraw(CHECKINGS, amount);
            deposit(SAVINGS, amount);
        } else if (fromAccount.equals(SAVINGS) && toAccount.equals(CHECKINGS)) {
            withdraw(SAVINGS, amount);
            deposit(CHECKINGS, amount);
        }
    }
}

