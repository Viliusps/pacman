package pacman.classes.AbstractFactory;

import pacman.classes.Blinky;
import pacman.classes.Bridge.IColor;

public class SlowBlinky extends Blinky {

    public SlowBlinky(IColor imageColor) {
        super(imageColor);
    }
    @Override

    public SlowBlinky deepClone() {
        SlowBlinky ghost = new SlowBlinky(this.getImageColor());
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
