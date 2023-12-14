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
    boolean ignorePowerup;

    public Request(short ch, short[] screenData, Pacman pacman, int pos, List<Ghost> ghosts, GameSubject scoringSystem, Fruit ghostFrightenedFruit, boolean ignorePowerup) {
        this.ch = ch;
        this.screenData = screenData;
        this.pacman = pacman;
        this.pos = pos;
        this.ghosts = ghosts;
        this.scoringSystem = scoringSystem;
        this.ghostFrightenedFruit = ghostFrightenedFruit;
        this.ignorePowerup = ignorePowerup;
    }
}
