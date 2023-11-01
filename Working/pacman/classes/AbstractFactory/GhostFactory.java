package pacman.classes.AbstractFactory;

import pacman.classes.Blinky;
import pacman.classes.Clyde;
import pacman.classes.Inky;
import pacman.classes.Pinky;

public abstract class GhostFactory
{
	public abstract Clyde getClyde();
	public abstract Inky getInky();
	public abstract Pinky getPinky();
	public abstract Blinky getBlinky();
}
