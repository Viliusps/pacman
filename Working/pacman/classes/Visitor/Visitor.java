package pacman.classes.Visitor;

import pacman.classes.Blinky;
import pacman.classes.Clyde;
import pacman.classes.Inky;
import pacman.classes.Pinky;

public interface Visitor {
    public void visit(Pinky pinky);
    public void visit(Blinky blinky);
    public void visit(Inky inky);
    public void visit(Clyde clyde);
}
