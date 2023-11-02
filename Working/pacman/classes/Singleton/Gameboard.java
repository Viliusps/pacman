package pacman.classes.Singleton;

import Facade.GameBoard;
import pacman.classes.Ghost;
import pacman.classes.Pacman;
import pacman.classes.AbstractFactory.FastFactory;
import pacman.classes.AbstractFactory.SlowFactory;
import pacman.classes.Adapter.AdapterInvincibility;
import pacman.classes.Adapter.AdapterSpeed;
import pacman.classes.Decorator.BasicFruit;
import pacman.classes.Decorator.Fruit;
import pacman.classes.Decorator.GhostFrightenedDecorator;
import pacman.classes.Factory.ItemFactory;
import pacman.classes.Factory.PowerPellet;
import pacman.classes.Observer.GameSubject;
import pacman.classes.Observer.Scoreboard;
import pacman.classes.Observer.ScoringSystem;

import pacman.classes.Command.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.List;
import javax.swing.Timer;

public class Gameboard {
    private static Gameboard instance = new Gameboard();

    private final FastFactory fastFactory = new FastFactory();
    private final SlowFactory slowFactory = new SlowFactory();
	private Dimension d;
    private final Font smallFont = new Font("Arial", Font.BOLD, 14);
    private boolean inGame = false;

    private final int BLOCK_SIZE = 24;
    private final int N_BLOCKS = 15;
    private final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;

    private int N_GHOSTS = 4;
    private int[] dx, dy;

    private List<Ghost> ghosts;

    private Image heart, frightened;
    private Image powerUp;

    private ItemFactory itemFactory = new ItemFactory();
    private PowerPellet powerPellet = (PowerPellet) itemFactory.getItem("PowerPellet");
    private BasicFruit fruit = (BasicFruit) itemFactory.getItem("Fruit");
    private Fruit ghostFrightenedFruit = new GhostFrightenedDecorator(fruit);

    private AdapterInvincibility invincibilityAdapter = new AdapterInvincibility();
    private AdapterSpeed speedAdapter = new AdapterSpeed();

    private Pacman pacman;

    private Invoker invoker = new Invoker();

    private final GameSubject scoringSystem = new ScoringSystem();

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
    private Timer timer;

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

    public FastFactory getFastFactory() {
        return fastFactory;
    }
    
    public SlowFactory getSlowFactory() {
        return slowFactory;
    }
    
    public Dimension getD() {
        return d;
    }

    public Font getSmallFont() {
        return smallFont;
    }

    public boolean isInGame() {
        return inGame;
    }

    public int getBLOCK_SIZE() {
        return BLOCK_SIZE;
    }

    public int getN_BLOCKS() {
        return N_BLOCKS;
    }

    public int getSCREEN_SIZE() {
        return SCREEN_SIZE;
    }

    public int getN_GHOSTS() {
        return N_GHOSTS;
    }

    public int[] getDx() {
        return dx;
    }

    public int[] getDy() {
        return dy;
    }

    public List<Ghost> getGhosts() {
        return ghosts;
    }

    public Image getHeart() {
        return heart;
    }

    public Image getFrightened() {
        return frightened;
    }

    public Image getPowerUp() {
        return powerUp;
    }

    public ItemFactory getItemFactory() {
        return itemFactory;
    }

    public PowerPellet getPowerPellet() {
        return powerPellet;
    }

    public BasicFruit getFruit() {
        return fruit;
    }

    public Fruit getGhostFrightenedFruit() {
        return ghostFrightenedFruit;
    }

    public AdapterInvincibility getInvincibilityAdapter() {
        return invincibilityAdapter;
    }

    public AdapterSpeed getSpeedAdapter() {
        return speedAdapter;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public Invoker getInvoker() {
        return invoker;
    }

    public GameSubject getScoringSystem() {
        return scoringSystem;
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

    public Timer getTimer() {
        return timer;
    }

}
