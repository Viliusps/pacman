package Observer;

public class GameEvent{
  public enum EventType {
    PACMAN_EATEN,
    GHOST_EATEN,
    PELLET_EATEN
  }

  private final EventType type;

  public GameEvent(EventType type) {
    this.type = type;
  }

  public EventType getType() {
    return type;
  }
}