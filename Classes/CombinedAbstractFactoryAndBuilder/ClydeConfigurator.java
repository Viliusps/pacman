/**
 * @(#) ClydeConfigurator.java
 */

package CombinedAbstractFactoryAndBuilder;

public class ClydeConfigurator
{
	private Clyde clyde;

	public ClydeConfigurator(Clyde clyde) {
		this.clyde = clyde;
	}

	public ClydeConfigurator addX( )
	{
		return this;
	}
	
	public ClydeConfigurator addY( )
	{
		return this;
	}
	
	public ClydeConfigurator addColor( )
	{
		return this;
	}
	
	public ClydeConfigurator addSpeed( )
	{
		return this;
	}
	
	public Clyde build( )
	{
		return this.clyde;
	}
	
	
}
