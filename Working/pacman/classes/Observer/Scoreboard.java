package pacman.classes.Observer;

import pacman.classes.Factory.Fruit;
import pacman.classes.Factory.Pellet;
import pacman.classes.Factory.PowerPellet;

public class Scoreboard implements GameObserver {
    private int score = 0;

    @Override
    public void update(GameEvent event) {
        if (event.getType().equals(GameEvent.EventType.GHOST_EATEN)) {
            handleScore(25);
        } else if (event.getType().equals(GameEvent.EventType.PELLET_EATEN)) {
            handleScore(new Pellet().getPoints());
        } else if (event.getType().equals(GameEvent.EventType.POWER_PELLET_EATEN)) {
            handleScore(new PowerPellet().getPoints());
        } else if (event.getType().equals(GameEvent.EventType.FRUIT_EATEN)) {
            handleScore(new Fruit().getPoints());
        } else if (event.getType().equals(GameEvent.EventType.GAME_FINISHED)) {
            handleScore(50);
        } else if (event.getType().equals(GameEvent.EventType.RESET)) {
            handleScore(-this.score);
        }
    }

    public void handleScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return this.score;
    }
}
