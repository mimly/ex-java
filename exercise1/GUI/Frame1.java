import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Frame1 extends JFrame implements ActionListener {

    private final JButton button = new JButton("Click me!");

    public Frame1() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640, 480);
        this.setVisible(true);

        this.button.addActionListener(this);

        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null, "Hello!");
    }

    public static void main(String[] args) {
        new Frame1();
    }
}
