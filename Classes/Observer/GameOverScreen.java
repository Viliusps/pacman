package Observer;

public class GameOverScreen implements GameObserver {
    @Override
    public void update(GameEvent event) {
        if (event.getType() == GameEvent.EventType.PACMAN_EATEN || event.getType() == GameEvent.EventType.GHOST_EATEN) {
            // Show game over screen when Pac-Man or a ghost is eaten
        }
    }
}

