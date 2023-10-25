package Observer;

public class Ghost extends GameSubject {
  public void getEaten() {
    notifyObservers(new GameEvent(GameEvent.EventType.GHOST_EATEN));
  }
}