package pacman.classes.State;

import pacman.classes.Pacman;
import pacman.classes.Adapter.AdapterInvincibility;

public class InvincibleState extends PacmanState{
    private final AdapterInvincibility invincibilityAdapter = new AdapterInvincibility();

    public InvincibleState(Pacman pacman) {
        super(pacman);
        pacman.setPowerUp(invincibilityAdapter);
                        
    }

    @Override
    public void setSpeed() {
        pacman.setSpeed(3);
    }

    @Override
    public void setInvincible() {
        pacman.applyPowerUp();
    }
}
