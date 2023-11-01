/**
 * @(#) Player1.java
 */

package Facade;

public class Player1
{
	private GameFacade facade;
	
	public void play()
	{
		this.facade.startGame();
	}
	
}
