package pacman.classes.Decorator;

public abstract class FruitDecorator implements Fruit
{
	private Fruit decoratedFruit;

	public FruitDecorator(Fruit decoratedFruit){
		this.decoratedFruit = decoratedFruit;
	}
	
	@Override
	public int getPoints( )
	{
		return this.decoratedFruit.getPoints();
	}
	
	
}
