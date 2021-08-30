package bank.v4;

import bank.v4.BankAccount;

public interface BankAccountHolder {
    void addAccount(BankAccount account);
    void removeAccount(BankAccount account);
}
