package pacman.classes.AbstractFactory;

import pacman.classes.Clyde;
import pacman.classes.Prototype.Prototype;

public class SlowClyde extends Clyde {
    @Override
    public SlowClyde deepClone() {
        SlowClyde ghost = new SlowClyde();
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
