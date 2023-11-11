package pacman.classes.AbstractFactory;

import pacman.classes.Bridge.IColor;
import pacman.classes.Pinky;
import pacman.classes.Prototype.Prototype;
import pacman.classes.Strategy.PinkyAlgorithm;

public class SlowPinky extends Pinky {
    public SlowPinky(IColor color) {
        super(color);
    }
    @Override
    public SlowPinky deepClone() {
        SlowPinky ghost = new SlowPinky(this.getImageColor());
        ghost.setX(this.getX());
        ghost.setY(this.getY());
        ghost.setDx(this.getDx());
        ghost.setDy(this.getDy());
        ghost.setSpeed(this.getSpeed());
        ghost.setColor();
        ghost.setFrightened(this.getFrightened());
        ghost.setStrategy(new PinkyAlgorithm());
        return ghost;
    }
}
