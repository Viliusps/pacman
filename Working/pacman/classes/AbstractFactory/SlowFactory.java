/**
 * @(#) SlowFactory.java
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

public class SlowFactory extends GhostFactory
{
	public Clyde getClyde( )
	{
		return new ClydeBuilder().startSlowClyde();
	}
	
	public Inky getInky( )
	{
		return new InkyBuilder().startSlowInky();
	}
	
	public Pinky getPinky( )
	{
		return new PinkyBuilder().startSlowPinky();
	}
	
	public Blinky getBlinky( )
	{
		return new BlinkyBuilder().startSlowBlinky();
	}
	
	
}
