package pacman.classes.ChainOfResponsibility;

import pacman.classes.State.FastState;

public class SpeedHandler extends BaseHandler {
    @Override
    public void handle(Request request) {
        if ((request.ch & 128) != 0) {
            request.screenData[request.pos] = (short) (request.ch & 15);
            request.pacman.changeState(new FastState(request.pacman));
            request.pacman.setSpeed();
            request.pacman.setInvincible();
        }
    }
}
