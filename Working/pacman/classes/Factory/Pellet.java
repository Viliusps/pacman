package pacman.classes.Factory;

import pacman.classes.TemplateMethod.AbstractItem;

public class Pellet extends AbstractItem implements Item
{
    private int points;

    public Pellet(){
        this.points = 1;
    }

    @Override
    public int getPoints(){
        return this.points;
    }

    @Override
    public void setPoints(int points){
        this.points = points;
    }
}
