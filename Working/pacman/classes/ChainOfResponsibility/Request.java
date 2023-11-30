package pacman.classes.ChainOfResponsibility;

import pacman.classes.Pacman;
import pacman.classes.Decorator.Fruit;
import pacman.classes.Ghost;
import pacman.classes.Observer.GameSubject;
import java.util.List;

public class Request {
    short ch;
    short[] screenData;
    Pacman pacman;
    int pos;
    List<Ghost> ghosts;
    GameSubject scoringSystem;
    Fruit ghostFrightenedFruit;

    public Request(short ch, short[] screenData, Pacman pacman, int pos, List<Ghost> ghosts, GameSubject scoringSystem, Fruit ghostFrightenedFruit) {
        this.ch = ch;
        this.screenData = screenData;
        this.pacman = pacman;
        this.pos = pos;
        this.ghosts = ghosts;
        this.scoringSystem = scoringSystem;
        this.ghostFrightenedFruit = ghostFrightenedFruit;
    }

    public short getCh() {
        return this.ch;
    }

    public void setCh(short ch) {
        this.ch = ch;
    }

    public short[] getScreenData() {
        return this.screenData;
    }

    public void setScreenData(short[] screenData) {
        this.screenData = screenData;
    }

    public Pacman getPacman() {
        return this.pacman;
    }

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
    }

    public int getPos() {
        return this.pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public List<Ghost> getGhosts() {
        return this.ghosts;
    }

    public void setGhosts(List<Ghost> ghosts) {
        this.ghosts = ghosts;
    }

    public GameSubject getScoringSystem() {
        return this.scoringSystem;
    }

    public void setScoringSystem(GameSubject scoringSystem) {
        this.scoringSystem = scoringSystem;
    }
}
