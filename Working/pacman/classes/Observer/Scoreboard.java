package pacman.classes.Observer;

import pacman.classes.Factory.Fruit;
import pacman.classes.Factory.ItemFactory;
import pacman.classes.Factory.Pellet;
import pacman.classes.Factory.PowerPellet;

public class Scoreboard implements GameObserver {
    private final ItemFactory itemFactory = new ItemFactory();
    private final PowerPellet powerPellet = (PowerPellet) itemFactory.getItem("PowerPellet");
    private final Fruit fruit = (Fruit) itemFactory.getItem("Fruit");
    private final Pellet pellet = (Pellet) itemFactory.getItem("Pellet");

    private int score = 0;

    @Override
    public void update(GameEvent event) {
        if (event.getType().equals(GameEvent.EventType.GHOST_EATEN)) {
            handleScore(25);
        } else if (event.getType().equals(GameEvent.EventType.PELLET_EATEN)) {
            handleScore(pellet.getPoints());
        } else if (event.getType().equals(GameEvent.EventType.POWER_PELLET_EATEN)) {
            handleScore(powerPellet.getPoints());
        } else if (event.getType().equals(GameEvent.EventType.FRUIT_EATEN)) {
            handleScore(fruit.getPoints());
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
