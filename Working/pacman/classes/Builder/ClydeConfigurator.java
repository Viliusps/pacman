package pacman.classes.Builder;

import pacman.classes.Clyde;
import pacman.classes.Strategy.MoveAlgorithm;

import java.awt.*;

public class ClydeConfigurator {
	private final Clyde clyde;

	public ClydeConfigurator(Clyde clyde) {
		this.clyde = clyde;
	}

	public ClydeConfigurator addX(int x) {
		this.clyde.setX(x);
		return this;
	}
	
	public ClydeConfigurator addY(int y) {
		this.clyde.setY(y);
		return this;
	}

	public ClydeConfigurator addDx(int dx) {
		this.clyde.setDx(dx);
		return this;
	}

	public ClydeConfigurator addDy(int dy) {
		this.clyde.setDy(dy);
		return this;
	}
	
	public ClydeConfigurator addSpeed(int speed) {
		this.clyde.setSpeed(speed);
		return this;
	}

	public ClydeConfigurator addColor(Image color) {
		this.clyde.setColor(color);
		return this;
	}

	public ClydeConfigurator addFrightened(Boolean frightened) {
		this.clyde.setFrightened(frightened);
		return this;
	}

	public ClydeConfigurator addStrategy(MoveAlgorithm strategy) {
		this.clyde.setStrategy(strategy);
		return this;
	}
	
	public Clyde build() {
		return this.clyde;
	}
}
