package threads;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class BasicsSolutions extends JFrame {

    /*
     * There are two ways of defining and starting a thread.
     * By implementing the <code>Runnable</code> interface
     * or by extending the <code>Thread</code> class.
     * The former one is preferable.
     */

    /*
     * Implement synchronous setTimeoutSync(Runnable, long)
     */
    public static void setTimeoutSync(Runnable runnable, long ms) {
        try {
            Thread.sleep(ms);
            runnable.run();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    /*
     * Implement asynchronous setTimeoutAsync(Runnable, long)
     */
    public static void setTimeoutAsync(Runnable runnable, long ms) {
        new Thread(() -> {
            try {
                Thread.sleep(ms);
                runnable.run();
            } catch(InterruptedException ie) {
                ie.printStackTrace();
            }
        }).start();
    }

    /*
     * Implement synchronous setIntervalSync(Runnable, long)
     */
    public static void setIntervalSync(Runnable runnable, long ms) {
        try {
            Thread.sleep(ms);
            runnable.run();
            Basics.setIntervalSync(runnable, ms);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    /*
     * Implement asynchronous setIntervalAsync(Runnable, long)
     */
    public static void setIntervalAsync(Runnable runnable, long ms) {
        new Thread(() -> {
            try {
                Thread.sleep(ms);
                runnable.run();
                Basics.setIntervalAsync(runnable, ms);
            } catch(InterruptedException ie) {
                ie.printStackTrace();
            }
        }).start();
    }

    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();

            Runnable runnable = () -> {
                JOptionPane.showMessageDialog(frame, "Sync vs Async", "Sync vs Async", JOptionPane.INFORMATION_MESSAGE);
            };
            // setTimeoutSync(runnable, 3000);
            // setTimeoutAsync(runnable, 3000);
            // setIntervalSync(runnable, 3000);
            // setIntervalAsync(runnable, 3000);

            JOptionPane.showMessageDialog(frame, "How many threads in total are currently up and running?", "Tricky Question", JOptionPane.QUESTION_MESSAGE);

            frame.dispose();
        });
    }
}
