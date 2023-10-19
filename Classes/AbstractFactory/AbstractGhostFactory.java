package AbstractFactory;

import Builder.Director;
import Factory.Ghost;

public interface AbstractGhostFactory {
    Director director = new Director();
    Ghost createInky();
    Ghost createPinky();
    Ghost createBlinky();
    Ghost createClyde();

} 
