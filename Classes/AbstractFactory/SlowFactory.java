package AbstractFactory;

import Builder.BlinkyBuilder;
import Builder.ClydeBuilder;
import Builder.InkyBuilder;
import Builder.PinkyBuilder;
import Factory.Ghost;

public class SlowFactory implements AbstractGhostFactory {

    @Override
    public Ghost createInky() {
        var builder = new InkyBuilder();
        return director.constructInky(builder);
    }

    @Override
    public Ghost createPinky() {
        var builder = new PinkyBuilder();
        return director.constructPinky(builder);
    }

    @Override
    public Ghost createBlinky() {
        var builder = new BlinkyBuilder();
        return director.constructBlinky(builder);
    }

    @Override
    public Ghost createClyde() {
        var builder = new ClydeBuilder();
        return director.constructClyde(builder);
    }
}
