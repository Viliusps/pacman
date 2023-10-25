package Observer;

public class Pacman extends GameSubject {
  public void eatPellet() {
    notifyObservers(new GameEvent(GameEvent.EventType.PELLET_EATEN));
  }
}