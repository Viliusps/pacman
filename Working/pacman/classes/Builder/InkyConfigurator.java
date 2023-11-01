package pacman.classes.Builder;

import pacman.classes.Inky;
import java.awt.*;

public class InkyConfigurator {
	private final Inky inky;

	public InkyConfigurator(Inky inky) {
		this.inky = inky;
	}

	public InkyConfigurator addX(int x) {
		this.inky.setX(x);
		return this;
	}
	
	public InkyConfigurator addY(int y) {
		this.inky.setY(y);
		return this;
	}

	public InkyConfigurator addDx(int dx) {
		this.inky.setDx(dx);
		return this;
	}

	public InkyConfigurator addDy(int dy) {
		this.inky.setDy(dy);
		return this;
	}
	
	public InkyConfigurator addSpeed(int speed) {
		this.inky.setSpeed(speed);
		return this;
	}

	public InkyConfigurator addColor(Image color) {
		this.inky.setColor(color);
		return this;
	}
	
	public Inky build()	{
		return inky;
	}
}
