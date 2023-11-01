/**
 * @(#) PinkyBuilder.java
 */

package CombinedAbstractFactoryAndBuilder;

public class PinkyBuilder
{
	
	public Pinky startFastPinky( )
	{
		return new PinkyConfigurator(new FastPinky()).addX().addY().addColor().addSpeed().build();
	}
	
	public Pinky startSlowPinky( )
	{
		return new PinkyConfigurator(new SlowPinky()).addX().addY().addColor().addSpeed().build();
	}
	
	
}
