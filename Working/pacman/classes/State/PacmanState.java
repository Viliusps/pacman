package pacman.classes.State;

import pacman.classes.Pacman;

public abstract class PacmanState {
    protected Pacman pacman;
    public PacmanState(Pacman pacman) {
        this.pacman = pacman;
    }
    
    public abstract void setSpeed();
    public abstract void setInvincible();
}
