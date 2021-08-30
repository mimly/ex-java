package bank.v3.client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BankClient extends JFrame {

    public BankClient() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(640, 480);
        this.setVisible(true);

        JComboBox<String> accounts = new JComboBox<>(new String[] {"Acount #1", "Acount #2", "Acount #3", "Acount #4"});
        JTextField depositAmount = new JTextField();
        JButton deposit = new JButton("DEPOSIT");
        JTextField withdrawAmount = new JTextField();
        JButton withdraw = new JButton("WITHDRAW");
        JLabel balance = new JLabel("BALANCE: 0.0");

        accounts.setBounds(20, 20, 600, 20);
        depositAmount.setBounds(100, 100, 200, 20);
        deposit.setBounds(340, 100, 200, 20);
        withdrawAmount.setBounds(100, 160, 200, 20);
        withdraw.setBounds(340, 160, 200, 20);
        balance.setBounds(100, 220, 240, 40);

        this.add(accounts);
        this.add(depositAmount);
        this.add(deposit);
        this.add(withdrawAmount);
        this.add(withdraw);
        this.add(balance);
    }

    public static void main (String[] args) {
        new BankClient();
    }

}
