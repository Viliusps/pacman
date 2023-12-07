package pacman.classes;

import pacman.classes.Bridge.IColor;
import pacman.classes.Visitor.Visitor;
public abstract class Inky extends Ghost {
    

    public Inky(IColor color) {
        super(color);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
