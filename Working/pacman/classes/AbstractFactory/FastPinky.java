package pacman.classes.AbstractFactory;

import pacman.classes.Pinky;
import pacman.classes.Prototype.Prototype;
import pacman.classes.Strategy.PinkyAlgorithm;

public class FastPinky extends Pinky {
    @Override
    public FastPinky deepClone() {
        FastPinky ghost = new FastPinky();
        ghost.setX(this.getX());
        ghost.setY(this.getY());
        ghost.setDx(this.getDx());
        ghost.setDy(this.getDy());
        ghost.setSpeed(this.getSpeed());
        ghost.setColor(this.getColor());
        ghost.setFrightened(this.getFrightened());
        ghost.setStrategy(new PinkyAlgorithm());
        return ghost;
    }

}
