package Adapter;

public class AdapterSpeed implements PowerUpAdapter
{
	private SpeedPowerUp adaptee;

	public AdapterSpeed(SpeedPowerUp adaptee){
		this.adaptee = adaptee;
	}

	public void addPoints( )
	{
		
	}
	
	public void apply( )
	{
		adaptee.addSpeed();
		addPoints();
	}
	
}
