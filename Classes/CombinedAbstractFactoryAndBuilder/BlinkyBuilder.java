/**
 * @(#) BlinkyBuilder.java
 */

package CombinedAbstractFactoryAndBuilder;

public class BlinkyBuilder
{
	public Blinky startFastBlinky( )
	{
		return new BlinkyConfigurator(new FastBlinky()).addX().addY().addColor().addSpeed().build();
	}
	
	public Blinky startSlowBlinky( )
	{
		return new BlinkyConfigurator(new SlowBlinky()).addX().addY().addColor().addSpeed().build();
	}
	
	
}
