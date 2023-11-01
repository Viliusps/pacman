package pacman.classes.Adapter;

import pacman.classes.Pacman;

public class AdapterSpeed implements PowerUpAdapter
{
	private SpeedPowerUp adaptee;

	public AdapterSpeed(){
		this.adaptee = new SpeedPowerUp();
	}
	
	public void apply(Pacman pacman )
	{
		adaptee.addSpeed(pacman);
	}
	
}
