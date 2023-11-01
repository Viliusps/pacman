/**
 * @(#) FastFactory.java
 */

package CombinedAbstractFactoryAndBuilder;

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
