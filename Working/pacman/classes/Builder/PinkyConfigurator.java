package pacman.classes.Builder;

import pacman.classes.Pinky;
import java.awt.*;

public class PinkyConfigurator {
	private final Pinky pinky;

	public PinkyConfigurator(Pinky pinky) {
		this.pinky = pinky;
	}

	public PinkyConfigurator addX(int x) {
		this.pinky.setX(x);
		return this;
	}
	
	public PinkyConfigurator addY(int y) {
		this.pinky.setY(y);
		return this;
	}

	public PinkyConfigurator addDx(int dx) {
		this.pinky.setDx(dx);
		return this;
	}

	public PinkyConfigurator addDy(int dy) {
		this.pinky.setDy(dy);
		return this;
	}
	
	public PinkyConfigurator addSpeed(int speed) {
		this.pinky.setSpeed(speed);
		return this;
	}

	public PinkyConfigurator addColor(Image color) {
		this.pinky.setColor(color);
		return this;
	}

	public PinkyConfigurator addFrightened(Boolean frightened) {
		this.pinky.setFrightened(frightened);
		return this;
	}
	
	public Pinky build() {
		return pinky;
	}
}
