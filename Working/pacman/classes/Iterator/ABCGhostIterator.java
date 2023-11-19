package pacman.classes.Iterator;

import java.util.Comparator;
import java.util.List;

import pacman.classes.Ghost;

public class ABCGhostIterator implements Iterator<Ghost>{
    
    private List<Ghost> ghosts;
    private int index;

    public ABCGhostIterator(List<Ghost> ghosts){
        this.ghosts = ghosts;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < ghosts.size();
    }

    @Override
    public Ghost getNext() {
        ghosts.sort(ghostClassNameComparator());
        if(hasNext())
            return ghosts.get(index++);
        return null;
    }

    private static Comparator<Ghost> ghostClassNameComparator() {
        return Comparator.comparing(ghost -> ghost.getClass().getSuperclass().getSimpleName());
    }
}
