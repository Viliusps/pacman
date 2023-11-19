package pacman.classes.Builder;

import pacman.classes.AbstractFactory.FastClyde;
import pacman.classes.AbstractFactory.SlowClyde;
import pacman.classes.Bridge.OrangeColor;
import pacman.classes.Clyde;
import pacman.classes.Strategy.ClydeAlgorithm;

import javax.swing.*;
import java.awt.*;

public class ClydeBuilder {
	private final Image orangeColor = new ImageIcon("./Working/images/orange.gif").getImage();

	public Clyde startFastClyde() {
		return new ClydeConfigurator(new FastClyde(new OrangeColor())).addX(96).addY(96).addDx(1).addDy(0).addSpeed(4).addColor().addFrightened(Boolean.FALSE).addStrategy(new ClydeAlgorithm()).addAlgorithm(new ClydeAlgorithm()).build();
	}
	
	public Clyde startSlowClyde() {
		return new ClydeConfigurator(new SlowClyde(new OrangeColor())).addX(96).addY(96).addDx(1).addDy(0).addSpeed(2).addColor().addFrightened(Boolean.FALSE).addStrategy(new ClydeAlgorithm()).addAlgorithm(new ClydeAlgorithm()).build();
	}
}
