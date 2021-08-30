package state;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class State {

    public static void main (String[] args) {
        MusicPlayerState initialState = new Stopped();
        MusicPlayer musicPlayer = new MusicPlayer(initialState);
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Music Player");
            JButton playAndPause = new JButton("PLAY/PAUSE");
            JButton stop = new JButton("STOP");
            ActionListener actionListener = ev -> {
                String src = ((JButton) ev.getSource()).getText();
                musicPlayer.changeState(src);
                musicPlayer.perform();
            };
            playAndPause.addActionListener(actionListener);
            stop.addActionListener(actionListener);
            frame.setLayout(new FlowLayout());
            frame.add(playAndPause);
            frame.add(stop);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class MusicPlayer {
    private MusicPlayerState state;

    public MusicPlayer(MusicPlayerState state) {
        this.state = state;
        this.state.setMusicPlayer(this);
    }

    public void setState(MusicPlayerState state) {
        this.state = state;
        this.state.setMusicPlayer(this);
    }

    /**
     * The context should delegate all state-specific tasks to the state object.
     */
    public void changeState(String src) {
        this.state.changeState(src);
    }

    public void perform() {
        this.state.perform();
    }
}

/**
 * State design pattern - allows an object to alter its behavior when its internal state changes.
 * The object will appear to change its class. (related to the concept of a Finite-State Machine)
 */
abstract class MusicPlayerState {
    protected MusicPlayer musicPlayer;

    public void setMusicPlayer(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    public abstract void changeState(String src);

    public abstract void perform();
    // ...
}

/**
 * Due to OCP (the open-closed principle), software entities should be open for extension
 * and closed for modification. New states can be introduced withouth needing to modify
 * the context or the client code.
 */
class Playing extends MusicPlayerState {

    @Override
    public void changeState(String src) {
        MusicPlayerState state;
        if (src.equals("PLAY/PAUSE")) {
            state = new Paused();
        } else {
            state = new Stopped();
        }
        this.musicPlayer.setState(state);
    }

    @Override
    public void perform() {
        System.out.println("\033[1;38;5;040mPLAYING\033[0m");
    }
}

class Paused extends MusicPlayerState {

    @Override
    public void changeState(String src) {
        MusicPlayerState state;
        if (src.equals("PLAY/PAUSE")) {
            state = new Playing();
        } else {
            state = new Stopped();
        }
        this.musicPlayer.setState(state);
    }

    @Override
    public void perform() {
        System.out.println("\033[1;38;5;208mPAUSED\033[0m");
    }
}

class Stopped extends MusicPlayerState {

    @Override
    public void changeState(String src) {
        MusicPlayerState state;
        if (src.equals("PLAY/PAUSE")) {
            state = new Playing();
        } else {
            state = new Stopped();
        }
        this.musicPlayer.setState(state);
    }

    @Override
    public void perform() {
        System.out.println("\033[1;38;5;196mSTOPPED\033[0m");
    }
}
