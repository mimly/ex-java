package bank.v1;

import java.util.Random;

import bank.v1.BankAccount;


/**
 * JavaDoc for BankAccount.
 */
public class CustomBankAccount implements BankAccount {

    private static final String CLEARING_NUMBER = "1234";
    private final String accountNumber;
    private final String personalNumber;
    private String name;
    private double balance = 0.0;
    public static double interestRate = 8.0;

    public CustomBankAccount(String personalNumber, String name) {
        this.accountNumber = generateAccountNumber();
        this.personalNumber = personalNumber;
        this.name = name;
    }

    public CustomBankAccount(String personalNumber, String name, double balance) {
        this(personalNumber, name);
        this.balance = balance;
    }

    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < 6; ++i) {
            accountNumber.append(random.nextInt(10));
        }
        return accountNumber.toString();
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("BankAccount{");
        stringBuilder.append("ACCOUNT NUMBER = ").append(CustomBankAccount.CLEARING_NUMBER).append("-").append(this.accountNumber);
        stringBuilder.append(", PERSONAL NUMBER = ").append(this.personalNumber);
        stringBuilder.append(", NAME = ").append(this.name);
        stringBuilder.append(", BALANCE = ").append(this.balance);
        stringBuilder.append(", INTEREST RATE = ").append(CustomBankAccount.interestRate);
        return stringBuilder.append("}").toString();
    }

    public String getAccountNumber() {
        return CustomBankAccount.CLEARING_NUMBER + "-" + this.accountNumber;
    }

    public String getAccountOwner() {
        return this.personalNumber + " " + this.name;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public double calculateBalanceAfter(double years) {
        return this.balance * Math.pow(1.0 + (CustomBankAccount.interestRate / 100.0), years);
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0.0) {
            throw new IllegalArgumentException("Only positive values allowed.");
        }
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0.0) {
            throw new IllegalArgumentException("Only positive values allowed.");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient funds in the account.");

        }
        this.balance -= amount;
    }
}
