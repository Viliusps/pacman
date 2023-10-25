package Observer;

public class Scoreboard implements GameObserver {

  @Override
  public void update(GameEvent event) {
    if (event.getType() == GameEvent.EventType.PELLET_EATEN) {
      //update score
    }
  }
}