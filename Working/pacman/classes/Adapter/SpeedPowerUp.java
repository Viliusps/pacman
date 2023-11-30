package pacman.classes.Adapter;

import pacman.classes.Pacman;
import pacman.classes.State.DefaultState;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class SpeedPowerUp implements PowerUpAdapter
{

	public SpeedPowerUp(){
	}
	
	public void apply(Pacman pacman )
	{
        pacman.setSpeed(6);

        Timer speedTimer = new Timer(5 * 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pacman.changeState(new DefaultState(pacman));
                pacman.setSpeed();
                ((Timer) e.getSource()).stop();
            }
        });
        speedTimer.setRepeats(false);
        speedTimer.start();
	}
	
}
