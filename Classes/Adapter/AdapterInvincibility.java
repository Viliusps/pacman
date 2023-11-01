package Adapter;

public class AdapterInvincibility implements PowerUpAdapter
{

	private InvincibilityPowerUp adaptee;

	public AdapterInvincibility(InvincibilityPowerUp adaptee){
		this.adaptee = adaptee;
	}
	
	public void apply( )
	{
		adaptee.addInvincibility();
	}
	
	
}
