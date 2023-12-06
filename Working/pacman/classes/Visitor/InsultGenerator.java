package pacman.classes.Visitor;

import pacman.classes.Blinky;
import pacman.classes.Clyde;
import pacman.classes.Inky;
import pacman.classes.Pinky;

public class InsultGenerator implements Visitor {

    @Override
    public void visit(Pinky pinky) {
        System.out.println("Pinky says: Your life will end today");
    }

    @Override
    public void visit(Blinky blinky) {
        System.out.println("Blinky says: I will destroy you");
    }

    @Override
    public void visit(Inky inky) {
        System.out.println("Inky says: I will be scraping you off my boots!");
    }

    @Override
    public void visit(Clyde clyde) {
        System.out.println("Clyde says: You will be amazed how good I am!");
    }
    
}
