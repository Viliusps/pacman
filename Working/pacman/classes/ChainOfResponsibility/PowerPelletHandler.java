package pacman.classes.ChainOfResponsibility;

import pacman.classes.Ghost;
import pacman.classes.Iterator.ABCGhostIterator;
import pacman.classes.Iterator.GhostIterator;

import javax.swing.Timer;

public class PowerPelletHandler extends BaseHandler {

    private Timer frightenedTimer;
    private void frightenedDurationCounter(Request request) {
        int delay = 3000;

        if (frightenedTimer != null && frightenedTimer.isRunning()) {
            frightenedTimer.stop();
        }

        frightenedTimer = new Timer(delay, e -> {
            GhostIterator ghostIterator = new GhostIterator(request.ghosts);
            while(ghostIterator.hasNext()) {
                Ghost ghost = ghostIterator.getNext();
                ghost.setFrightened(false);
            }
        });

        frightenedTimer.setRepeats(false);
        frightenedTimer.start();
    }

    @Override
    public void handle(Request request) {
            if ((request.ch & 32) != 0) {
                request.screenData[request.pos] = (short) (request.ch & 15);
                request.pacman.eatPowerPellet(request.scoringSystem);
                GhostIterator ghostIterator = new GhostIterator(request.ghosts);
                while(ghostIterator.hasNext()) {
                    Ghost ghost = ghostIterator.getNext();
                    ghost.setFrightened(true);
                }

                ABCGhostIterator ghostIterator2 = new ABCGhostIterator(request.ghosts);
                while(ghostIterator2.hasNext()) {
                    Ghost ghost = ghostIterator2.getNext();
                }
                frightenedDurationCounter(request);
            }
            else {
                super.getNext().handle(request);
            }
    }
}
