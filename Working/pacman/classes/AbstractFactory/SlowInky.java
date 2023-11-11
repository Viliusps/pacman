package pacman.classes.AbstractFactory;

import pacman.classes.Inky;
import pacman.classes.Prototype.Prototype;
import pacman.classes.Strategy.InkyAlgorithm;

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
        ghost.setStrategy(new InkyAlgorithm());
        return ghost;
    }

}
