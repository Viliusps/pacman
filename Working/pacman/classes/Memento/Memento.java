package pacman.classes.Memento;

import pacman.classes.Ghost;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    private GameState state;
    public Memento(GameState state) {
        this.state = new GameState();
        this.state.setScreenData(new short[state.getScreenData().length]);
        for (int i = 0; i < state.getScreenData().length; i++) {
            this.state.getScreenData()[i] = state.getScreenData()[i];
        }
        this.state.setPacman(state.getPacman().deepClone());
        List<Ghost> ghosts = new ArrayList<>();
        for (Ghost ghost : state.getGhosts()) {
            ghosts.add(ghost.deepClone());
        }
        this.state.setGhosts(ghosts);
        this.state.setScoreboard(state.getScoreboard().deepClone());
    }
    public GameState getState() {
        return state;
    }


}
