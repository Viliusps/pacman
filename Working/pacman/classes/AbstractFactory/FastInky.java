package pacman.classes.AbstractFactory;

import pacman.classes.Blinky;
import pacman.classes.Inky;
import pacman.classes.Prototype.Prototype;

public class FastInky extends Inky {
    @Override
    public FastInky deepClone() {
        FastInky ghost = new FastInky();
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
