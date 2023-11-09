package pacman.classes.AbstractFactory;

import pacman.classes.Blinky;
import pacman.classes.Bridge.IColor;

public class FastBlinky extends Blinky {

    public FastBlinky(IColor color) {
        super(color);
    }

    @Override
    public FastBlinky deepClone() {
        FastBlinky ghost = new FastBlinky(this.getImageColor());
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
