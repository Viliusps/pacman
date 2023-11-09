package pacman.classes.AbstractFactory;

import pacman.classes.Bridge.IColor;
import pacman.classes.Pinky;

public class FastPinky extends Pinky {
    public FastPinky(IColor color) {
        super(color);
    }
    @Override
    public FastPinky deepClone() {
        FastPinky ghost = new FastPinky(this.getImageColor());
        ghost.setX(this.getX());
        ghost.setY(this.getY());
        ghost.setDx(this.getDx());
        ghost.setDy(this.getDy());
        ghost.setSpeed(this.getSpeed());
        ghost.setColor();
        ghost.setFrightened(this.getFrightened());
        ghost.setStrategy(this.getStrategy());
        return ghost;
    }

}
