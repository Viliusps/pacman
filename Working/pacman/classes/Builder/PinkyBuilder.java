package pacman.classes.Builder;

import pacman.classes.AbstractFactory.FastPinky;
import pacman.classes.AbstractFactory.SlowPinky;
import pacman.classes.Pinky;
import javax.swing.*;
import java.awt.*;

public class PinkyBuilder {
	private final Image pinkColor = new ImageIcon("./Working/images/pink.gif").getImage();
	
	public Pinky startFastPinky() {
		return new PinkyConfigurator(new FastPinky()).addX(96).addY(96).addDx(-1).addDy(0).addSpeed(4).addColor(pinkColor).addFrightened(Boolean.FALSE).build();
	}
	
	public Pinky startSlowPinky() {
		return new PinkyConfigurator(new SlowPinky()).addX(96).addY(96).addDx(-1).addDy(0).addSpeed(2).addColor(pinkColor).addFrightened(Boolean.FALSE).build();
	}
}
