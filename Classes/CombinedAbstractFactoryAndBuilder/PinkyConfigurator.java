/**
 * @(#) PinkyConfigurator.java
 */

package CombinedAbstractFactoryAndBuilder;

public class PinkyConfigurator
{
	private Pinky pinky;

	public PinkyConfigurator(Pinky pinky) {
		this.pinky = pinky;
	}

	public PinkyConfigurator addX( )
	{
		return this;
	}
	
	public PinkyConfigurator addY( )
	{
		return this;
	}
	
	public PinkyConfigurator addColor( )
	{
		return this;
	}
	
	public PinkyConfigurator addSpeed( )
	{
		return this;
	}
	
	public Pinky build( )
	{
		return pinky;
	}
	
	
}
