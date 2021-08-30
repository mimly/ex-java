import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Frame4 extends JFrame {

    private final JButton button = new JButton("Click me!");

    public Frame4() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640, 480);
        this.setVisible(true);

        this.button.addActionListener(e -> JOptionPane.showMessageDialog(null, "Hello!"));

        this.add(button);
    }

    public static void main(String[] args) {
        new Frame4();
    }
}
