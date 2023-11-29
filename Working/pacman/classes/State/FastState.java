package pacman.classes.State;

import pacman.classes.Pacman;
import pacman.classes.Adapter.SpeedPowerUp;

public class FastState extends PacmanState {
    private final SpeedPowerUp speedAdapter = new SpeedPowerUp();

    public FastState(Pacman pacman) {
        super(pacman);
        pacman.setPowerUp(speedAdapter);
    }

    @Override
    public void setSpeed() {
        pacman.applyPowerUp();
    }

    @Override
    public void setInvincible() {
        pacman.setInvincible(false);
    }
}
