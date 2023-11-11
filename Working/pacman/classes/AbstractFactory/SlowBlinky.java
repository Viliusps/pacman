package pacman.classes.AbstractFactory;

import pacman.classes.Blinky;
import pacman.classes.Prototype.Prototype;
import pacman.classes.Strategy.BlinkyAlgorithm;

public class SlowBlinky extends Blinky {
    @Override

    public SlowBlinky deepClone() {
        SlowBlinky ghost = new SlowBlinky();
        ghost.setX(this.getX());
        ghost.setY(this.getY());
        ghost.setDx(this.getDx());
        ghost.setDy(this.getDy());
        ghost.setSpeed(this.getSpeed());
        ghost.setColor(this.getColor());
        ghost.setFrightened(this.getFrightened());
        ghost.setStrategy(new BlinkyAlgorithm());
        return ghost;
    }
}
