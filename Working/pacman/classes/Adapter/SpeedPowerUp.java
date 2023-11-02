package pacman.classes.Adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import pacman.classes.Pacman;

public class SpeedPowerUp {
    public void addSpeed(Pacman pacman) {
        int originalSpeed = pacman.getSpeed();
        pacman.setSpeed(6);

        Timer speedTimer = new Timer(5 * 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pacman.setSpeed(originalSpeed);
                ((Timer) e.getSource()).stop();
            }
        });
        speedTimer.setRepeats(false);
        speedTimer.start();
    }
}
