package bank.v2.account;

import bank.v2.BankAccount;
import bank.v2.BankAccountNumber;
import bank.v2.BankAccountHolder;
import bank.v2.account.number.SixDigitAccountNumber;

public class CustomBankAccount implements BankAccount {

    private final BankAccountNumber accountNumber;
    private BankAccountHolder accountHolder;
    private double balance = 0.0;
    public static double interestRate = 8.0;

    public CustomBankAccount(BankAccountHolder accountHolder) {
        this.accountNumber = new SixDigitAccountNumber(); // tight coupling
        this.accountHolder = accountHolder;
        this.accountHolder.addAccount(this);
    }

    public CustomBankAccount(BankAccountNumber accountNumber, BankAccountHolder accountHolder) {
        this.accountNumber = accountNumber; // DI -> loose coupling
        this.accountHolder = accountHolder;
        this.accountHolder.addAccount(this);
    }

    public CustomBankAccount(BankAccountHolder accountHolder, double balance) {
        this(accountHolder);
        this.balance = balance;
    }

    public CustomBankAccount(BankAccountNumber accountNumber, BankAccountHolder accountHolder, double balance) {
        this(accountNumber, accountHolder);
        this.balance = balance;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("CustomBankAccount{");
        stringBuilder.append("ACCOUNT NUMBER = ").append(this.accountNumber);
        stringBuilder.append(", ACCOUNT HOLDER = ").append(this.accountHolder);
        stringBuilder.append(", BALANCE = ").append(this.balance);
        stringBuilder.append(", INTEREST RATE = ").append(CustomBankAccount.interestRate);
        return stringBuilder.append("}").toString();
    }

    @Override
    public BankAccountNumber getAccountNumber() {
        return accountNumber;
    }

    @Override
    public BankAccountHolder getAccountHolder() {
        return accountHolder;
    }

    @Override
    public void setAccountHolder(BankAccountHolder accountHolder) {
        this.accountHolder = accountHolder;
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
