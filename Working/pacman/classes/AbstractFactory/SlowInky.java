package pacman.classes.AbstractFactory;

import pacman.classes.Bridge.IColor;
import pacman.classes.Inky;

public class SlowInky extends Inky {
    public SlowInky(IColor color) {
        super(color);
    }
    @Override
    public SlowInky deepClone() {
        SlowInky ghost = new SlowInky(this.getImageColor());
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
