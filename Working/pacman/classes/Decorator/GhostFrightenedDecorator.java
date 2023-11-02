package pacman.classes.Decorator;

public class GhostFrightenedDecorator extends FruitDecorator
{
	public GhostFrightenedDecorator(Fruit decoratedFruit){
		super(decoratedFruit);
	}
	public int getPoints( )
	{
		return 0;
	}
	
	
}
