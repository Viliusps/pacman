package pacman.classes.Decorator;

import java.util.List;

import pacman.classes.Ghost;
import javax.swing.Timer;

public class GhostFrightenedDecorator extends FruitDecorator
{
	public GhostFrightenedDecorator(Fruit decoratedFruit){
		super(decoratedFruit);
	}

	@Override
	public int getPoints( )
	{
		return super.getPoints() / 2;
	}

	private Timer frightenedTimer;
	public void setGhostsFrightened(List<Ghost> ghosts)
	{
		for (Ghost ghost : ghosts) {
			ghost.setFrightened(true);
		}
        int delay = 3000;

        if (frightenedTimer != null && frightenedTimer.isRunning()) {
            frightenedTimer.stop();
        }

        frightenedTimer = new Timer(delay, e -> {
            for (Ghost ghost : ghosts) {
                ghost.setFrightened(false);
            }
        });

        frightenedTimer.setRepeats(false);
        frightenedTimer.start();
	}
}
