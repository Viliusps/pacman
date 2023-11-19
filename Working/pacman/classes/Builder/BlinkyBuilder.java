package pacman.classes.Builder;

import pacman.classes.AbstractFactory.FastBlinky;
import pacman.classes.AbstractFactory.SlowBlinky;
import pacman.classes.Blinky;
import pacman.classes.Bridge.RedColor;
import pacman.classes.Strategy.BlinkyAlgorithm;

import javax.swing.*;
import java.awt.*;

public class BlinkyBuilder {
	private final Image redColor = new ImageIcon("./Working/images/red.gif").getImage();

	public Blinky startFastBlinky() {
		return new BlinkyConfigurator(new FastBlinky(new RedColor())).addX(96).addY(96).addDx(1).addDy(0).addSpeed(4).addColor().addFrightened(Boolean.FALSE).addStrategy(new BlinkyAlgorithm()).addAlgorithm(new BlinkyAlgorithm()).build();
	}
	
	public Blinky startSlowBlinky() {
		return new BlinkyConfigurator(new SlowBlinky(new RedColor())).addX(96).addY(96).addDx(1).addDy(0).addSpeed(2).addColor().addFrightened(Boolean.FALSE).addStrategy(new BlinkyAlgorithm()).addAlgorithm(new BlinkyAlgorithm()).build();
	}
}
