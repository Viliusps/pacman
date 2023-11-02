package pacman.classes.Singleton;

import pacman.classes.Observer.Scoreboard;
import java.awt.Font;

public class Gameboard {
    private static Gameboard instance = new Gameboard();

    private final Scoreboard scoreboard = new Scoreboard();

    private final short[] levelData = {
    	19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
        17, 16, 16, 16, 16, 24, 16, 16, 16, 16, 16, 32, 16, 16, 20,
        25, 24, 24, 24, 28, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
        0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
        19, 18, 18, 18, 18, 18, 16, 16, 16, 16, 24, 24, 24, 24, 20,
        17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
        17, 16, 64, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
        17, 16, 16, 16, 24, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
        17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 18, 18, 18, 18, 20,
        17, 24, 24, 28, 0, 25, 24, 24, 16, 16, 16, 16, 16, 16, 20,
        21, 0,  0,  0,  0,  0,  0,   0, 17, 16, 16, 16, 16, 16, 20,
        17, 18, 18, 22, 0, 19, 18, 18, 16, 16, 16, 16, 16, 16, 20,
        17, 16, 16, 20, 0, 17, 64, 16, 16, 16, 16, 16, 16, 16, 20,
        17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
        25, 24, 24, 24, 26, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28
    };

    private short[] screenData;

    private final Font smallFont = new Font("Arial", Font.BOLD, 14);
    private final int BLOCK_SIZE = 24;
    private final int N_BLOCKS = 15;
    private final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;

    private Gameboard() {
    }

    public static Gameboard getInstance() {
        if(instance == null)
        {
            synchronized(Gameboard.class)
            {
                if(instance == null)
                {
                    instance = new Gameboard();
                }
            }
        }
        return instance;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public short[] getLevelData() {
        return levelData;
    }

    public short[] getScreenData() {
        return screenData;
    }

    public Font getSmallFont() {
        return smallFont;
    }

    public int getScreenSize() {
        return SCREEN_SIZE;
    }

    public int getBlockSize() {
        return BLOCK_SIZE;
    }

    public int getNBlocks() {
        return N_BLOCKS;
    }

}
