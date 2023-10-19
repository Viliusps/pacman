package Builder;

import Factory.Ghost;

public class Director {
    public Ghost constructClyde(Builder builder) {
        builder.setX(0);
        builder.setY(0);
        builder.setDirection("RIGHT");
        builder.setColor("CYAN");

        return builder.build();
    }

    public Ghost constructPinky(Builder builder) {
        builder.setX(0);
        builder.setY(0);
        builder.setDirection("RIGHT");
        builder.setColor("PINK");

        return builder.build();
    }

    public Ghost constructBlinky(Builder builder) {
        builder.setX(0);
        builder.setY(0);
        builder.setDirection("RIGHT");
        builder.setColor("RED");

        return builder.build();
    }

    public Ghost constructInky(Builder builder) {
        builder.setX(0);
        builder.setY(0);
        builder.setDirection("RIGHT");
        builder.setColor("ORANGE");

        return builder.build();
    }
}
