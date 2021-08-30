package bank.v2;

import bank.v2.BankAccount;

public interface BankAccountHolder {
    void addAccount(BankAccount account);
    void removeAccount(BankAccount account);
}
