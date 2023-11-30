package pacman.classes.ChainOfResponsibility;


public class PelletHandler extends BaseHandler {
    @Override
    public void handle(Request request) {
            if ((request.ch & 16) != 0) {
                request.screenData[request.pos] = (short) (request.ch & 15);
                request.pacman.eatPellet(request.scoringSystem);
            }
            else {
                super.getNext().handle(request);
            }
    }
}
