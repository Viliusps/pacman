/**
 * @(#) BlinkyConfigurator.java
 */

package CombinedAbstractFactoryAndBuilder;

public class BlinkyConfigurator
{
	private Blinky blinky;

	public BlinkyConfigurator(Blinky blinky) {
		this.blinky = blinky;
	}

	public BlinkyConfigurator addX( )
	{
		return this;
	}
	
	public BlinkyConfigurator addY( )
	{
		return this;
	}
	
	public BlinkyConfigurator addColor( )
	{
		return this;
	}
	
	public BlinkyConfigurator addSpeed( )
	{
		return this;
	}
	
	public Blinky build( )
	{
		return blinky;
	}
	
	
}
