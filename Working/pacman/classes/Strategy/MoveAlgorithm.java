package pacman.classes.Strategy;

import pacman.classes.Ghost;
import pacman.classes.Pacman;

import java.util.List;

public interface MoveAlgorithm {
    void execute(Ghost ghost, Pacman pac, short[] screenData, int pos, List<Ghost> ghosts);
}
