package pacman.classes.AbstractFactory;

import pacman.classes.Blinky;
import pacman.classes.Prototype.Prototype;

public class FastBlinky extends Blinky {
    @Override
    public FastBlinky deepClone() {
        FastBlinky ghost = new FastBlinky();
        ghost.setX(this.getX());
        ghost.setY(this.getY());
        ghost.setDx(this.getDx());
        ghost.setDy(this.getDy());
        ghost.setSpeed(this.getSpeed());
        ghost.setColor(this.getColor());
        ghost.setFrightened(this.getFrightened());
        ghost.setStrategy(this.getStrategy());
        return ghost;
    }

}
