package pacman.classes.AbstractFactory;

import pacman.classes.Pinky;
import pacman.classes.Prototype.Prototype;

public class SlowPinky extends Pinky {
    @Override
    public SlowPinky deepClone() {
        SlowPinky ghost = new SlowPinky();
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
