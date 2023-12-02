package pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class Menu extends JFrame implements ActionListener {
    private static final Map<JButton, MenuComponent> submenus = new HashMap<>();
    private boolean epilepsy;

    public void setVisibility(boolean visibility) {
        setVisible(visibility);
    }

    public void setEpilepsy(boolean epilepsy) {
        this.epilepsy = epilepsy;
    }

    private final JButton playGameButton;
    private static JButton settingsButton;
    private static JButton creditsButton;
    private final JButton exitButton;

    public Menu() {
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
        if (e.getSource() == playGameButton) {
            new Client(epilepsy);
            setVisible(false);
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        } else {
            submenus.get(e.getSource()).setVisibility(true);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        var mainMenu = new Menu();

        submenus.put(settingsButton, new SettingsMenu(mainMenu));
        submenus.put(creditsButton, new Credits(mainMenu));
    }
}
