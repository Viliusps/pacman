/**
 * @(#) ClydeBuilder.java
 */

package CombinedAbstractFactoryAndBuilder;

public class ClydeBuilder
{
	public Clyde startFastClyde()
	{
		return new ClydeConfigurator(new FastClyde()).addX().addY().addColor().addSpeed().build();
	}
	
	public Clyde startSlowClyde()
	{
		return new ClydeConfigurator(new SlowClyde()).addX().addY().addColor().addSpeed().build();
	}
	
	
}
