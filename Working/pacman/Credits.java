package pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Credits extends MenuItem {
    private final Menu mainMenu;
    private final JButton backButton;

    public Credits(Menu mainMenu) {
        this.mainMenu = mainMenu;
        setTitle("Credits");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
        setLocationRelativeTo(null);

        JTextArea creditsText = new JTextArea();
        creditsText.setText("Credits:\n\nAugustinas Jukna\nVilius Paševeckas\nSimonas Švelnys");
        creditsText.setEditable(false);
        creditsText.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(creditsText);
        add(scrollPane, BorderLayout.CENTER);


        backButton = new JButton("Back");
        backButton.addActionListener(this);
        add(backButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            setVisible(false);
            mainMenu.setVisibility(true);
        }
    }

    @Override
    public void setVisibility(boolean visible) {
        setVisible(visible);
    }
}
