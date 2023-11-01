package Decorator;

import java.util.ArrayList;

public abstract class FruitDecorator implements Fruit
{
	private ArrayList<Fruit> decoratedFruits;
	
	public int getPoints( )
	{
		return 0;
	}
	
	
}
