package pacman.classes.Facade;

import pacman.Model;
import pacman.classes.Command.DownMove;
import pacman.classes.Command.LeftMove;
import pacman.classes.Command.RightMove;
import pacman.classes.Command.UpMove;

public class GameFacade {
    private Model model;

    public GameFacade() {
        this.model = new Model();
    }

    public void startGame() {
        model.initGame();
    }

    public void playGame() {

    }

    public Model getModel()
    {
        return this.model;
    }

    //Additional methods for potential future use
    public void movePacmanLeft() {
        model.getInvoker().setCommand(new LeftMove());
    }

    public void movePacmanRight() {
        model.getInvoker().setCommand(new RightMove());
    }

    public void movePacmanUp() {
        model.getInvoker().setCommand(new UpMove());
    }

    public void movePacmanDown() {
        model.getInvoker().setCommand(new DownMove());
    }

    public void moveGhosts() {
        model.moveGhosts();
    }

    public void endGame() {
        model.setTimerStop();
        model.setInGame(false);
    }


}
