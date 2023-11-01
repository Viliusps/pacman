/**
 * @(#) FastFactory.java
 */

package pacman.classes.AbstractFactory;

import pacman.classes.Blinky;
import pacman.classes.Builder.BlinkyBuilder;
import pacman.classes.Builder.ClydeBuilder;
import pacman.classes.Builder.InkyBuilder;
import pacman.classes.Builder.PinkyBuilder;
import pacman.classes.Clyde;
import pacman.classes.Inky;
import pacman.classes.Pinky;

public class FastFactory extends GhostFactory
{
	public Clyde getClyde( )
	{
		return new ClydeBuilder().startFastClyde();
	}
	
	public Inky getInky( )
	{
		return new InkyBuilder().startFastInky();
	}
	
	public Pinky getPinky( )
	{
		return new PinkyBuilder().startFastPinky();
	}
	
	public Blinky getBlinky( )
	{
		return new BlinkyBuilder().startFastBlinky();
	}
	
	
}
