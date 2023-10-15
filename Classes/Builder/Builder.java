package Builder;

import Factory.Ghost;

public interface Builder {

    abstract Ghost build();

    abstract void setX(int x);

    abstract void setY(int y);

    abstract void setColor(String color);

    abstract void setDirection(String direction);
}
