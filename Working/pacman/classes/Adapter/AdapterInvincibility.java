package pacman.classes.Adapter;

import pacman.classes.Pacman;

public class AdapterInvincibility implements PowerUpAdapter
{
	private InvincibilityPowerUp adaptee;

	public AdapterInvincibility(){
		this.adaptee = new InvincibilityPowerUp();
	}
	
	public void apply(Pacman pacman)
	{
		adaptee.addInvincibility(pacman);
	}
}
