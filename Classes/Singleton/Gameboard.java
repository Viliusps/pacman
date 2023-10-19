package Singleton;

public class Gameboard {
    private static final Gameboard instance = new Gameboard();
    private Gameboard() {
        System.out.println("Gameboard initialized");
    }

    public static Gameboard getInstance() {
        System.out.println("Returning instance");
        return instance;
    }
}
