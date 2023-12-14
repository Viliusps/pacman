package pacman.classes.ChainOfResponsibility;

import pacman.classes.Decorator.GhostFrightenedDecorator;
import pacman.classes.State.InvincibleState;
import java.util.Random;

public class FruitHandler extends BaseHandler {

    @Override
    public void handle(Request request) {
        if ((request.ch & 64) != 0  && !request.ignorePowerup) {
            request.screenData[request.pos] = (short) (request.ch & 15);

            Random random = new Random();
            int randomChoice = random.nextInt(3);

            switch (randomChoice) {
                case 0 -> {
                    request.pacman.eatFruit(request.scoringSystem);
                    request.pacman.changeState(new InvincibleState(request.pacman));
                    request.pacman.setSpeed();
                    request.pacman.setInvincible();
                }
                case 1 -> request.pacman.eatDoublePointsFruit(request.scoringSystem);
                case 2 -> {
                    request.pacman.eatGhostFrightenedFruit(request.scoringSystem);
                    ((GhostFrightenedDecorator) request.ghostFrightenedFruit).setGhostsFrightened(request.ghosts);
                }
            }
        }
        else {
            super.getNext().handle(request);
        }
    }
}