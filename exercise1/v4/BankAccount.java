package bank.v4;

import bank.v4.BankAccountNumber;
import bank.v4.BankAccountHolder;

public interface BankAccount {
    BankAccountNumber getAccountNumber();
    BankAccountHolder getAccountHolder();
    void setAccountHolder(BankAccountHolder accountHolder);
    double getBalance();
    double calculateBalanceAfter(double years);
    void deposit(double amount);
    void withdraw(double amount);
}
