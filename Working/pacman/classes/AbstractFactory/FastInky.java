package pacman.classes.AbstractFactory;

import pacman.classes.Inky;
import pacman.classes.Prototype.Prototype;
import pacman.classes.Strategy.InkyAlgorithm;
import pacman.classes.Bridge.IColor;

public class FastInky extends Inky {
    public FastInky(IColor color) {
        super(color);
    }
    @Override
    public FastInky deepClone() {
        FastInky ghost = new FastInky(this.getImageColor());
        ghost.setX(this.getX());
        ghost.setY(this.getY());
        ghost.setDx(this.getDx());
        ghost.setDy(this.getDy());
        ghost.setSpeed(this.getSpeed());
        ghost.setColor();
        ghost.setFrightened(this.getFrightened());
        ghost.setStrategy(new InkyAlgorithm());
        return ghost;
    }

}
