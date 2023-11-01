/**
 * @(#) InkyConfigurator.java
 */

package CombinedAbstractFactoryAndBuilder;

public class InkyConfigurator
{
	private Inky inky;

	public InkyConfigurator(Inky inky) {
		this.inky = inky;
	}

	public InkyConfigurator addX( )
	{
		return this;
	}
	
	public InkyConfigurator addY( )
	{
		return this;
	}
	
	public InkyConfigurator addColor( )
	{
		return this;
	}
	
	public InkyConfigurator addSpeed( )
	{
		return this;
	}
	
	public Inky build( )
	{
		return inky;
	}
	
	
}
