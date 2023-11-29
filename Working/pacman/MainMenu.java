package pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MainMenu extends JFrame implements ActionListener {
    private List<Menu> menus;
    private boolean epilepsy;

    public void setVisibility(boolean visibility) {
        setVisible(visibility);
    }

    public void setEpilepsy(boolean epilepsy) {
        this.epilepsy = epilepsy;
    }

    private final JButton playGameButton;
    private final JButton settingsButton;
    private final JButton creditsButton;
    private final JButton exitButton;

    public MainMenu() {
        setTitle("Main Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));
        setLocationRelativeTo(null);

        playGameButton = new JButton("Play Game");
        playGameButton.addActionListener(this);
        add(playGameButton);

        settingsButton = new JButton("Settings");
        settingsButton.addActionListener(this);
        add(settingsButton);

        creditsButton = new JButton("Credits");
        creditsButton.addActionListener(this);
        add(creditsButton);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        add(exitButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == settingsButton) {
            new SettingsMenu(this);
            setVisible(false);
        } else if (e.getSource() == playGameButton) {
            new Client(epilepsy);
            setVisible(false);
        } else if (e.getSource() == creditsButton) {
            new Credits(this);
            setVisible(false);
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
