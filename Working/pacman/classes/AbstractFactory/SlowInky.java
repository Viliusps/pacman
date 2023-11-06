package pacman.classes.AbstractFactory;

import pacman.classes.Inky;
import pacman.classes.Prototype.Prototype;

public class SlowInky extends Inky {
    @Override
    public SlowInky deepClone() {
        SlowInky ghost = new SlowInky();
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
