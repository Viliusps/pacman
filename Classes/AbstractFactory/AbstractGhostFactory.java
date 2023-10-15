package AbstractFactory;

import Builder.Director;

public interface AbstractGhostFactory {
    public Director director = new Director();
    public abstract void createInky();
    public abstract void createPinky();
    public abstract void createBlinky();
    public abstract void createClyde();

} 
