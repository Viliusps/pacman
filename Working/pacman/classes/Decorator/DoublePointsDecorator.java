package pacman.classes.Decorator;

public class DoublePointsDecorator extends FruitDecorator
{
	public DoublePointsDecorator(Fruit decoratedFruit) {
		super(decoratedFruit);
	}

	@Override
	public int getPoints( )
	{
		return 0;
	}
	
	
}
