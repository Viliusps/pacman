package pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsMenu extends JFrame implements ActionListener {
    private final MainMenu mainMenu;
    private final JButton backButton;
    private static JToggleButton toggleButton;
    private static JLabel messageLabel;

    public SettingsMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
        setTitle("Settings");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 1));
        setLocationRelativeTo(null);

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        add(backButton);

        toggleButton = new JToggleButton("Toggle Switch");
        toggleButton.addActionListener(e -> {
            if (toggleButton.isSelected()) {
                messageLabel.setText("Epilepsy mode is on");
                mainMenu.setEpilepsy(true);
            } else {
                messageLabel.setText("Epilepsy mode is off");
                mainMenu.setEpilepsy(false);
            }
        });

        messageLabel = new JLabel("Epilepsy mode is off");
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        add(toggleButton);
        add(messageLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            setVisible(false);
            mainMenu.setVisibility(true);
        }
    }
}
