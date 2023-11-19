package pacman.classes.AbstractFactory;

import pacman.classes.Bridge.IColor;
import pacman.classes.Clyde;

public class SlowClyde extends Clyde {
    public SlowClyde(IColor color) {
        super(color);
    }

    @Override
    public SlowClyde deepClone() {
        SlowClyde ghost = new SlowClyde(this.getImageColor());
        ghost.setX(this.getX());
        ghost.setY(this.getY());
        ghost.setDx(this.getDx());
        ghost.setDy(this.getDy());
        ghost.setSpeed(this.getSpeed());
        ghost.setColor();
        ghost.setFrightened(this.getFrightened());
        ghost.setStrategy(this.getStrategy());
        ghost.setAlgorithm(this.getAlgorithm());
        return ghost;
    }
}
