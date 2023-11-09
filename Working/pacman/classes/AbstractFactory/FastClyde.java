package pacman.classes.AbstractFactory;

import pacman.classes.Bridge.IColor;
import pacman.classes.Clyde;

public class FastClyde extends Clyde {
    public FastClyde(IColor color) {
        super(color);
    }

    @Override
    public FastClyde deepClone() {
        FastClyde ghost = new FastClyde(this.getImageColor());
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
