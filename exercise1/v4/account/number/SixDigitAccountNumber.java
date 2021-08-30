package bank.v4.account.number;

import java.util.Random;

import bank.v4.BankAccountNumber;

public class SixDigitAccountNumber implements BankAccountNumber {

    private static final String CLEARING_NUMBER = "1234";
    private final String accountNumber;

    public SixDigitAccountNumber() {
        this.accountNumber = generateAccountNumber();
    }

    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; ++i) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return SixDigitAccountNumber.CLEARING_NUMBER + "-" + this.accountNumber;
    }

    @Override
    public String getClearingNumber() {
        return SixDigitAccountNumber.CLEARING_NUMBER;
    }

    @Override
    public String getAccountNumber() {
        return this.accountNumber;
    }

}
