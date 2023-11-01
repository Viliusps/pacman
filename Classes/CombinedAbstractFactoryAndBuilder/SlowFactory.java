/**
 * @(#) SlowFactory.java
 */

package CombinedAbstractFactoryAndBuilder;

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
