package Singleton;

import Facade.GameBoard;

public class Gameboard {
    private static Gameboard instance = new Gameboard();
    private Gameboard() {
        System.out.println("Gameboard initialized");
    }

    public static Gameboard getInstance() {
        System.out.println("Returning instance");
        if(instance == null)
        {
            synchronized(GameBoard.class)
            {
                if(instance == null)
                {
                    instance = new Gameboard();
                }
            }
        }
        return instance;
    }
}
