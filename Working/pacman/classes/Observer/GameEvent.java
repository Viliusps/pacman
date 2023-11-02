package pacman.classes.Observer;

public class GameEvent {
    public enum EventType {
        GHOST_EATEN,
        PELLET_EATEN,
        POWER_PELLET_EATEN,
        FRUIT_EATEN,
        GAME_FINISHED,
        RESET,
        DOUBLE_POINTS_FRUIT_EATEN,
        GHOST_FRIGHTENED_FRUIT_EATEN
    }

    private final EventType type;

    public GameEvent(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return type;
    }
}
