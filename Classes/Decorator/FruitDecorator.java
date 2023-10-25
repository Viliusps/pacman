package Decorator;

public abstract class FruitDecorator implements Fruit
{
	private Prototype.Fruit decoratedFruit;
	
	public int getPoints( )
	{
		return 0;
	}
	
	
}
