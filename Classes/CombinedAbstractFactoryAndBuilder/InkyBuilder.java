/**
 * @(#) InkyBuilder.java
 */

package CombinedAbstractFactoryAndBuilder;

public class InkyBuilder
{
	public Inky startFastInky( )
	{
		return new InkyConfigurator(new FastInky()).addX().addY().addColor().addSpeed().build();
	}
	
	public Inky startSlowInky( )
	{
		return new InkyConfigurator(new SlowInky()).addX().addY().addColor().addSpeed().build();
	}
	
	
}
