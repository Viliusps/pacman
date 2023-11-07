package pacman.classes.AbstractFactory;

import pacman.classes.Clyde;

public class FastClyde extends Clyde {
    @Override
    public FastClyde deepClone() {
        FastClyde ghost = new FastClyde();
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
