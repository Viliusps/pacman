package pacman.classes.Flyweight;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import pacman.classes.Factory.Pellet;

public class PelletFactory {
    private static Map<Color, Pellet> map = new HashMap<>();

    public PelletFactory(){

	}
	public static Pellet getItem(Color color){
        Pellet pellet = map.get(color);

        if(pellet == null) {
            pellet = new Pellet(color);
            map.put(color, pellet);
        }
		return pellet;
	}
}