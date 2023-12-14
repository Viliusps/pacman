package pacman.classes.Mediator;

public interface Mediator {
    void activatePowerUp();
    void deactivatePowerUp();
    void registerElement(PowerUpListener element);
    void unregisterElement(PowerUpListener element);
}