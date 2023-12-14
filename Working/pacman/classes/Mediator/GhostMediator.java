package pacman.classes.Mediator;

import java.util.ArrayList;

import java.util.List;

public class GhostMediator implements Mediator {
    private List<PowerUpListener> listeners = new ArrayList<>();

    @Override
    public void activatePowerUp() {

        for (PowerUpListener listener : listeners) {
            listener.onPowerUpActivated();
        }
    }

    @Override
    public void deactivatePowerUp() {

        for (PowerUpListener listener : listeners) {
            listener.onPowerUpDeactivated();
        }
    }

    @Override
    public void registerElement(PowerUpListener element) {
        listeners.add(element);
    }

    @Override
    public void unregisterElement(PowerUpListener element) {
        listeners.remove(element);
    }
}