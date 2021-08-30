import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Frame3 extends JFrame {

    private final JButton button = new JButton("Click me!");

    public Frame3() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640, 480);
        this.setVisible(true);

        this.button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        JOptionPane.showMessageDialog(null, "Hello!");
                    }
                });

        this.add(button);
    }

    public static void main(String[] args) {
        new Frame3();
    }
}
