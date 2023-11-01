package pacman.classes.Factory;

//Add random appearing feature, with temporary time
public class ItemFactory
{
	public ItemFactory(){

	}

	public Item getItem(String type){
		switch (type) {
			case "Pellet":
				return new Pellet();
			case "Fruit":
				return new Fruit();
			case "PowerPellet":
				return new PowerPellet();
		}
		return null;
	}
}
