/**
 * @(#) GhostFactory.java
 */

package CombinedAbstractFactoryAndBuilder;

public abstract class GhostFactory
{
	private ClydeBuilder clydeBuilder;
	
	private InkyBuilder inkyBuilder;
	
	private BlinkyBuilder blinkyBuilder;
	
	private PinkyBuilder pinkyBuilder;
	
	public abstract Clyde getClyde( );
	
	public abstract Inky getInky( );
	
	public abstract Pinky getPinky( );
	
	public abstract Blinky getBlinky( );
	
	
}
