package bank.v4.client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bank.v4.*;
import bank.v4.account.*;
import bank.v4.account.holder.*;

public class BankClient extends JFrame {

    private final JComboBox<BankAccount> accounts;
    private final JTextField depositAmount = new JTextField();
    private final JButton deposit = new JButton("DEPOSIT");
    private final JTextField withdrawAmount = new JTextField();
    private final JButton withdraw = new JButton("WITHDRAW");
    private final JLabel accountInfo = new JLabel();

    private BankAccount chosenAccount;

    public BankClient() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(640, 480);
        this.setVisible(true);

        BankAccountHolder studentA = new Student("abcdef", "Abcdef", "Fedcba");
        BankAccountHolder studentB = new Student("qwerty", "Qwerty", "Ytrewq");
        BankAccount account1 = new CustomBankAccount(studentA);
        BankAccount account2 = new CustomBankAccount(studentA, 100.0);
        BankAccount account3 = new CustomBankAccount(studentA);
        BankAccount account4 = new CustomBankAccount(studentB);
        BankAccount account5 = new CustomBankAccount(studentB, 2000000.0);

        this.accounts = new JComboBox<>(new BankAccount[] { account1, account2, account3, account4, account5 });
        this.accounts.addActionListener((e) -> {
            JComboBox cb = (JComboBox) e.getSource();
            chosenAccount = (BankAccount) cb.getSelectedItem();
            accountInfo.setText("<html>" + chosenAccount + "</html>");
        });

        this.deposit.addActionListener((e) -> {
            try {
                double amount = Double.parseDouble(depositAmount.getText());
                chosenAccount.deposit(amount);
                JOptionPane.showMessageDialog(this, amount + "$", "Success", JOptionPane.INFORMATION_MESSAGE);
                accounts.setSelectedItem(accounts.getSelectedItem());
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            } finally {
                depositAmount.setText("");
            }
        });

        this.withdraw.addActionListener((e) -> {
            try {
                double amount = Double.parseDouble(withdrawAmount.getText());
                chosenAccount.withdraw(amount);
                JOptionPane.showMessageDialog(this, "-" + amount + "$", "Success", JOptionPane.INFORMATION_MESSAGE);
                accounts.setSelectedItem(accounts.getSelectedItem());
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            } finally {
                withdrawAmount.setText("");
            }
        });

        this.accounts.setBounds(20, 20, 600, 20);
        this.depositAmount.setBounds(100, 100, 200, 20);
        this.deposit.setBounds(340, 100, 200, 20);
        this.withdrawAmount.setBounds(100, 160, 200, 20);
        this.withdraw.setBounds(340, 160, 200, 20);
        this.accountInfo.setBounds(100, 220, 440, 180);

        this.add(accounts);
        this.add(depositAmount);
        this.add(deposit);
        this.add(withdrawAmount);
        this.add(withdraw);
        this.add(accountInfo);
    }

    public static void main (String[] args) {
        new BankClient();
    }

}
