package pacman.classes.Strategy;

import pacman.classes.Ghost;
import pacman.classes.Pacman;

import java.util.List;

public class ClydeAlgorithm extends MoveAlgorithm {

    public ClydeAlgorithm(){
        
    }
    @Override
    public void execute(Ghost ghost, Pacman pac, short[] screenData, int pos, List<Ghost> ghosts) {
        int targetX = pac.getX();
        int targetY = pac.getY();

        int distanceX = targetX - ghost.getX();
        int distanceY = targetY - ghost.getY();

        boolean activated = false;

        int minimumDistance = Math.min(Math.abs(distanceX), Math.abs(distanceY));
        if(minimumDistance > 8 * 24) {
            if (Math.abs(distanceX) > Math.abs(distanceY)) {
                if (distanceX < 0 && (screenData[pos] & 1) == 0 && ghost.getDx() != 1) {
                    ghost.setDx(-1);
                    ghost.setDy(0);
                    activated = true;
                } else if (distanceX > 0 && (screenData[pos] & 4) == 0 && ghost.getDx() != -1) {
                    ghost.setDx(1);
                    ghost.setDy(0);
                    activated = true;
                }
            } else if (Math.abs(distanceX) < Math.abs(distanceY)) {
                if (distanceY < 0 && (screenData[pos] & 2) == 0 && ghost.getDy() != 1) {
                    ghost.setDx(0);
                    ghost.setDy(-1);
                    activated = true;
                } else if (distanceY > 0 && (screenData[pos] & 8) == 0 && ghost.getDy() != -1) {
                    ghost.setDx(0);
                    ghost.setDy(1);
                    activated = true;
                }
            }
        }

        if (!activated) {
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
