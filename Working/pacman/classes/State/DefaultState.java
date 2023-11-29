package pacman.classes.State;

import pacman.classes.Pacman;

public class DefaultState extends PacmanState {

    public DefaultState(Pacman pacman) {
        super(pacman);
    }

    @Override
    public void setSpeed() {
        pacman.setSpeed(3);
    }

    @Override
    public void setInvincible() {
        pacman.setInvincible(false);
    }
    
}
