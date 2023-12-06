package pacman.classes.Visitor;

import pacman.classes.Blinky;
import pacman.classes.Clyde;
import pacman.classes.Inky;
import pacman.classes.Pinky;

public class SpeedUpdater implements Visitor {

    @Override
    public void visit(Pinky pinky) {
        int speed = (Math.abs(pinky.getX()) + Math.abs(pinky.getY())) % 4 + 1;
        System.out.println(speed);
        pinky.setSpeed(speed);
    }

    @Override
    public void visit(Blinky blinky) {
        int speed = (int) (Math.pow(blinky.getX(), 2) + Math.pow(blinky.getY(), 2)) % 4 + 1;
        System.out.println(speed);
        blinky.setSpeed(speed);
    }

    @Override
    public void visit(Inky inky) {
        int distance = Math.abs(inky.getX()) + Math.abs(inky.getY());
        int speed = (distance > 20) ? 4 : (20 - distance) / 5 + 1;
        System.out.println(speed);
        inky.setSpeed(Math.min(4, speed));
    }

    @Override
    public void visit(Clyde clyde) {
        int speed = (int) (Math.sqrt(Math.pow(clyde.getX(), 2) + Math.pow(clyde.getY(), 2))) % 4 + 1;
        System.out.println(speed);
        clyde.setSpeed(speed);
    }
}