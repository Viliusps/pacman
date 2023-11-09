package pacman.classes.Builder;

import pacman.classes.AbstractFactory.FastPinky;
import pacman.classes.AbstractFactory.SlowPinky;
import pacman.classes.Bridge.PinkColor;
import pacman.classes.Pinky;
import pacman.classes.Strategy.InkyAlgorithm;
import pacman.classes.Strategy.PinkyAlgorithm;

import javax.swing.*;
import java.awt.*;

public class PinkyBuilder {
	private final Image pinkColor = new ImageIcon("./Working/images/pink.gif").getImage();
	
	public Pinky startFastPinky() {
		return new PinkyConfigurator(new FastPinky(new PinkColor())).addX(96).addY(96).addDx(-1).addDy(0).addSpeed(4).addColor().addFrightened(Boolean.FALSE).addStrategy(new PinkyAlgorithm()).build();
	}
	
	public Pinky startSlowPinky() {
		return new PinkyConfigurator(new SlowPinky(new PinkColor())).addX(96).addY(96).addDx(-1).addDy(0).addSpeed(2).addColor().addFrightened(Boolean.FALSE).addStrategy(new PinkyAlgorithm()).build();
	}
}
