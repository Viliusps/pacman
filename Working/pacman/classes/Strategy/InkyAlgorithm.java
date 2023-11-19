package pacman.classes.Strategy;

import pacman.classes.Blinky;
import pacman.classes.Ghost;
import pacman.classes.Pacman;
import pacman.classes.TemplateMethod.AbstractAlgorithm;

import java.util.List;

public class InkyAlgorithm extends AbstractAlgorithm implements MoveAlgorithm {
    public InkyAlgorithm(){

    }

    public int getTargetX(Pacman pac, List<Ghost> ghosts) {
        int referenceX = pac.getX() + pac.getDX() * 2 * 24;
        int blinkyX = 0;
        for (int i = 0; i < ghosts.size(); i++) {
            if (ghosts.get(i) instanceof Blinky) {
                blinkyX = ghosts.get(i).getX();
                break;
            }
        }

        int vectorX = referenceX - blinkyX;
        return referenceX + vectorX;
    }

    public int getTargetY(Pacman pac, List<Ghost> ghosts) {
        int referenceY = pac.getY() + pac.getDY() * 2 * 24;
        int blinkyY = 0;
        for (int i = 0; i < ghosts.size(); i++) {
            if (ghosts.get(i) instanceof Blinky) {
                blinkyY = ghosts.get(i).getY();
                break;
            }
        }

        int vectorY = referenceY - blinkyY;
        return referenceY + vectorY;
    }

    //reference based chasing algorithm
    @Override
    public void execute(Ghost ghost, Pacman pac, short[] screenData, int pos, List<Ghost> ghosts) {
        int referenceX = pac.getX() + pac.getDX() * 2 * 24;
        int referenceY = pac.getY() + pac.getDY() * 2 * 24;
        int blinkyX = 0, blinkyY = 0;
        for (int i = 0; i < ghosts.size(); i++) {
            if (ghosts.get(i) instanceof Blinky) {
                blinkyX = ghosts.get(i).getX();
                blinkyY = ghosts.get(i).getY();
                break;
            }
        }

        int vectorX = referenceX - blinkyX;
        int vectorY = referenceY - blinkyY;

        int targetX = referenceX + vectorX;
        int targetY = referenceY + vectorY;

        int distanceX = targetX - ghost.getX();
        int distanceY = targetY - ghost.getY();

        boolean executed = false;

        if (Math.abs(distanceX) > Math.abs(distanceY)) {
            if (distanceX < 0 && (screenData[pos] & 1) == 0 && ghost.getDx() != 1) {
                ghost.setDx(-1);
                ghost.setDy(0);
                executed = true;
            }
            else if (distanceX > 0 && (screenData[pos] & 4) == 0 && ghost.getDx() != -1)
            {
                ghost.setDx(1);
                ghost.setDy(0);
                executed = true;
            }
        }
        else if (Math.abs(distanceX) < Math.abs(distanceY)) {
            if (distanceY < 0 && (screenData[pos] & 2) == 0 && ghost.getDy() != 1) {
                ghost.setDx(0);
                ghost.setDy(-1);
                executed = true;
            }

            else if (distanceY > 0 && (screenData[pos] & 8) == 0 && ghost.getDy() != -1) {
                ghost.setDx(0);
                ghost.setDy(1);
                executed = true;
            }
        }

        if (!executed) {
            int count = 0;
            int[] dx = new int[4];
            int[] dy = new int[4];
            if ((screenData[pos] & 1) == 0 && ghost.getDx() != 1) {
                dx[count] = -1;
                dy[count] = 0;
                count++;
            }

            if ((screenData[pos] & 2) == 0 && ghost.getDy() != 1) {
                dx[count] = 0;
                dy[count] = -1;
                count++;
            }

            if ((screenData[pos] & 4) == 0 && ghost.getDx() != -1) {
                dx[count] = 1;
                dy[count] = 0;
                count++;
            }

            if ((screenData[pos] & 8) == 0 && ghost.getDy() != -1) {
                dx[count] = 0;
                dy[count] = 1;
                count++;
            }
            if (count == 0) {
                if ((screenData[pos] & 15) == 15) {
                    ghost.setDx(0);
                    ghost.setDy(0);
                } else {
                    ghost.setDx(-ghost.getDx());
                    ghost.setDy(-ghost.getDy());
                }

            } else {
                count = (int) (Math.random() * count);
                if (count > 3) {
                    count = 3;
                }
                ghost.setDx(dx[count]);
                ghost.setDy(dy[count]);
            }
        }
    }
}
