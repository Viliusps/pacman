package pacman.classes.Factory;

import pacman.classes.Decorator.BasicFruit;
import pacman.classes.Mediator.GhostMediator;

//Add random appearing feature, with temporary time
public class ItemFactory
{
	public ItemFactory(){

	}

	public Item getItem(String type, GhostMediator mediator){
		switch (type) {
			case "Pellet":
				return new Pellet();
			case "Fruit":
				return new BasicFruit(mediator);
			case "PowerPellet":
				return new PowerPellet(mediator);
		}
		return null;
	}
}
