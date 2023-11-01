/**
 * @(#) Pacman.java
 */

package Facade;

import Observer.GameSubject;
import Adapter.PowerUpAdapter;

public class Pacman extends GameSubject
{
	private int X;
	
	private int Y;
	
	private int pelletsEaten;
	
	private String direction;
	
	private boolean hasPower;
	
	private PowerUpAdapter powerUp;
	
	public int getX( )
	{
		return 0;
	}
	
	public int getY( )
	{
		return 0;
	}
	
	public void setX( int x )
	{
		
	}
	
	public void setY( int y )
	{
		
	}
	
	
}
