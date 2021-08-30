package bank.v1;

public interface BankAccount {
    double getBalance();
    double calculateBalanceAfter(double years);
    void deposit(double amount);
    void withdraw(double amount);
}
