package pacman.classes.Builder;

import pacman.classes.AbstractFactory.FastInky;
import pacman.classes.AbstractFactory.SlowInky;
import pacman.classes.Inky;
import javax.swing.*;
import java.awt.*;

public class InkyBuilder {
	private final Image blueColor = new ImageIcon("./Working/images/blue.gif").getImage();

	public Inky startFastInky() {
		return new InkyConfigurator(new FastInky()).addX(96).addY(96).addDx(-1).addDy(0).addSpeed(4).addColor(blueColor).addFrightened(Boolean.FALSE).build();
	}
	
	public Inky startSlowInky() {
		return new InkyConfigurator(new SlowInky()).addX(96).addY(96).addDx(-1).addDy(0).addSpeed(2).addColor(blueColor).addFrightened(Boolean.FALSE).build();
	}
}
