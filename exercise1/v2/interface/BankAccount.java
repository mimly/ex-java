package bank.v2;

import bank.v2.BankAccountNumber;
import bank.v2.BankAccountHolder;

public interface BankAccount {
    BankAccountNumber getAccountNumber();
    BankAccountHolder getAccountHolder();
    void setAccountHolder(BankAccountHolder accountHolder);
    double getBalance();
    double calculateBalanceAfter(double years);
    void deposit(double amount);
    void withdraw(double amount);
}
