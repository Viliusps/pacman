package pacman.classes.Observer;

import pacman.classes.Decorator.BasicFruit;
import pacman.classes.Decorator.DoublePointsDecorator;
import pacman.classes.Decorator.Fruit;
import pacman.classes.Decorator.GhostFrightenedDecorator;
import pacman.classes.Factory.ItemFactory;
import pacman.classes.Factory.Pellet;
import pacman.classes.Factory.PowerPellet;

public class Scoreboard implements GameObserver {
    private final ItemFactory itemFactory = new ItemFactory();
    private final PowerPellet powerPellet = (PowerPellet) itemFactory.getItem("PowerPellet");
    private final BasicFruit fruit = (BasicFruit) itemFactory.getItem("Fruit");
    private final Pellet pellet = (Pellet) itemFactory.getItem("Pellet");

    private Fruit doublePointsFruit = new DoublePointsDecorator(fruit);
    private Fruit frightenedFruit = new GhostFrightenedDecorator(fruit);

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
        } else if(event.getType().equals(GameEvent.EventType.DOUBLE_POINTS_FRUIT_EATEN)) {
            handleScore(doublePointsFruit.getPoints());
        } else if(event.getType().equals(GameEvent.EventType.GHOST_FRIGHTENED_FRUIT_EATEN)) {
            handleScore(frightenedFruit.getPoints());
        }
    }

    public void handleScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return this.score;
    }
}
