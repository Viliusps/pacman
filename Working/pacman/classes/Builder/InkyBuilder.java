package pacman.classes.Builder;

import pacman.classes.AbstractFactory.FastInky;
import pacman.classes.AbstractFactory.SlowInky;
import pacman.classes.Bridge.BlueColor;
import pacman.classes.Inky;
import pacman.classes.Strategy.InkyAlgorithm;

import javax.swing.*;
import java.awt.*;

public class InkyBuilder {
	private final Image blueColor = new ImageIcon("./Working/images/blue.gif").getImage();

	public Inky startFastInky() {
		return new InkyConfigurator(new FastInky(new BlueColor())).addX(96).addY(96).addDx(-1).addDy(0).addSpeed(4).addColor().addFrightened(Boolean.FALSE).addStrategy(new InkyAlgorithm()).addAlgorithm(new InkyAlgorithm()).build();
	}
	
	public Inky startSlowInky() {
		return new InkyConfigurator(new SlowInky(new BlueColor())).addX(96).addY(96).addDx(-1).addDy(0).addSpeed(2).addColor().addFrightened(Boolean.FALSE).addStrategy(new InkyAlgorithm()).addAlgorithm(new InkyAlgorithm()).build();
	}
}
