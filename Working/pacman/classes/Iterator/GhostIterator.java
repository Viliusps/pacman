package pacman.classes.Iterator;

import java.util.List;

import pacman.classes.Ghost;

public class GhostIterator implements Iterator<Ghost>{

    private List<Ghost> ghosts;
    private int index;

    public GhostIterator(List<Ghost> ghosts){
        this.ghosts = ghosts;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < ghosts.size();
    }

    @Override
    public Ghost getNext() {
        if(hasNext())
            return ghosts.get(index++);
        return null;
    }
}
