package Singleton;

import Facade.GameBoard;

public class Gameboard {
    private static Gameboard instance = new Gameboard();
    private Gameboard() {
    }

    public static Gameboard getInstance() {
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
