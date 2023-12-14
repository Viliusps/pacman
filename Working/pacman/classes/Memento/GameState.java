package pacman.classes.Memento;

import pacman.classes.Ghost;
import pacman.classes.Observer.Scoreboard;
import pacman.classes.Pacman;

import java.util.List;

public class GameState {
    private short[] screenData;
    private Pacman pacman;
    private List<Ghost> ghosts;
    private Scoreboard scoreboard;

    public short[] getScreenData() {
        return screenData;
    }

    public void setScreenData(short[] screenData) {
        this.screenData = screenData;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
    }

    public List<Ghost> getGhosts() {
        return ghosts;
    }

    public void setGhosts(List<Ghost> ghosts) {
        this.ghosts = ghosts;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public void setScoreboard(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

}
