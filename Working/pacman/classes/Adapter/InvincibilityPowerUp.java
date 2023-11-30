package pacman.classes.Adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import pacman.classes.Pacman;
import pacman.classes.State.DefaultState;

public class InvincibilityPowerUp
{
	public void addInvincibility(Pacman pacman)
	{
        pacman.setInvincible(true);
		
        Timer speedTimer = new Timer(5 * 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pacman.changeState(new DefaultState(pacman));
                pacman.setInvincible();
                ((Timer) e.getSource()).stop(); 
            }
        });

        speedTimer.setRepeats(false);
        speedTimer.start();
	}
	
}