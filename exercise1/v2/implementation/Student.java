package bank.v2.account.holder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import bank.v2.BankAccount;
import bank.v2.BankAccountHolder;

public class Student implements BankAccountHolder {

    public String kthId;
    protected String lastName;
    String firstName;
    // private List<BankAccount> accounts;
    private Set<BankAccount> accounts;

    public Student(String kthId, String lastName, String firstName) {
        this.kthId = kthId;
        this.lastName = lastName;
        this.firstName = firstName;
        // this.accounts = new ArrayList<>();
        this.accounts = new HashSet<>();
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Student{");
        stringBuilder.append(" KTH ID = ").append(this.kthId);
        stringBuilder.append(", LAST NAME = ").append(this.lastName);
        stringBuilder.append(", FIRST NAME = ").append(this.firstName);
        stringBuilder.append(", ACCOUNTS = ").append(this.accounts.stream()
                .map(account -> String.valueOf(account.getAccountNumber()))
                .collect(Collectors.joining(", ", "{", "}")));
        return stringBuilder.append("}").toString();
    }

    @Override
    public void addAccount(BankAccount account) {
        this.accounts.add(account);
        account.setAccountHolder(this);
    }

    @Override
    public void removeAccount(BankAccount account) {
        this.accounts.remove(account);
        account.setAccountHolder(null);
    }

}
