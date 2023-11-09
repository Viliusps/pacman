package pacman.classes.Builder;

import pacman.classes.Blinky;
import pacman.classes.Strategy.MoveAlgorithm;

import java.awt.*;

public class BlinkyConfigurator {
	private final Blinky blinky;

	public BlinkyConfigurator(Blinky blinky) {
		this.blinky = blinky;
	}

	public BlinkyConfigurator addX(int x) {
		this.blinky.setX(x);
		return this;
	}
	
	public BlinkyConfigurator addY(int y) {
		this.blinky.setY(y);
		return this;
	}

	public BlinkyConfigurator addDx(int dx) {
		this.blinky.setDx(dx);
		return this;
	}

	public BlinkyConfigurator addDy(int dy) {
		this.blinky.setDy(dy);
		return this;
	}
	
	public BlinkyConfigurator addSpeed(int speed) {
		this.blinky.setSpeed(speed);
		return this;
	}

	public BlinkyConfigurator addColor() {
		this.blinky.setColor();
		return this;
	}

	public BlinkyConfigurator addFrightened(Boolean frightened) {
		this.blinky.setFrightened(frightened);
		return this;
	}

	public BlinkyConfigurator addStrategy(MoveAlgorithm strategy) {
		this.blinky.setStrategy(strategy);
		return this;
	}
	
	public Blinky build() {
		return blinky;
	}
}
