package pacman;

import pacman.classes.AbstractFactory.FastFactory;
import pacman.classes.AbstractFactory.SlowFactory;
import pacman.classes.ChainOfResponsibility.FruitHandler;
import pacman.classes.ChainOfResponsibility.Handler;
import pacman.classes.ChainOfResponsibility.PelletHandler;
import pacman.classes.ChainOfResponsibility.PowerPelletHandler;
import pacman.classes.ChainOfResponsibility.Request;
import pacman.classes.ChainOfResponsibility.SpeedHandler;
import pacman.classes.Factory.ItemFactory;
import pacman.classes.Factory.Pellet;
import pacman.classes.Factory.PowerPellet;
import pacman.classes.Flyweight.PelletFactory;
import pacman.classes.Iterator.GhostIterator;
import pacman.classes.Command.*;
import pacman.classes.Decorator.BasicFruit;
import pacman.classes.Decorator.Fruit;
import pacman.classes.Decorator.GhostFrightenedDecorator;
import pacman.classes.Ghost;
import pacman.classes.Observer.*;
import pacman.classes.Singleton.Gameboard;
import pacman.classes.Visitor.InsultGenerator;
import pacman.classes.Visitor.SpeedUpdater;
import pacman.classes.Visitor.Visitor;
import pacman.classes.Pacman;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Model extends JPanel implements ActionListener, GameObserver {
    Gameboard gameboard = Gameboard.getInstance();
    private final Font smallFont = gameboard.getSmallFont();
    private final int SCREEN_SIZE = gameboard.getScreenSize();
    private final short[] levelData = gameboard.getLevelData();
    private short[] screenData = gameboard.getScreenData();
    private final Scoreboard scoreboard = gameboard.getScoreboard();
    private final int BLOCK_SIZE = gameboard.getBlockSize();
    private final int N_BLOCKS = gameboard.getNBlocks();

    static List<Color> pelletColors = new ArrayList<>(Arrays.asList(
                Color.RED,
                Color.GREEN,
                Color.BLUE,
                Color.YELLOW,
                Color.CYAN,
                Color.MAGENTA,
                Color.ORANGE,
                Color.PINK,
                Color.GRAY,
                Color.LIGHT_GRAY,
                Color.DARK_GRAY,
                Color.BLACK,
                Color.WHITE
        ));

    private final FastFactory fastFactory = new FastFactory();
    private final SlowFactory slowFactory = new SlowFactory();
	private Dimension d;
    private boolean inGame = false;

    private int N_GHOSTS = 4;

    private int GAMES_PLAYED = 0;

    private List<Ghost> ghosts;

    private Image heart, frightened;
    private Image powerUp;

    private final ItemFactory itemFactory = new ItemFactory();
    private final PowerPellet powerPellet = (PowerPellet) itemFactory.getItem("PowerPellet");
    private final BasicFruit fruit = (BasicFruit) itemFactory.getItem("Fruit");
    private final Fruit ghostFrightenedFruit = new GhostFrightenedDecorator(fruit);

    private Handler fruitHandler = new FruitHandler();
    private Handler pelletHandler = new PelletHandler();
    private Handler powerPelletHandler = new PowerPelletHandler();
    private Handler speedHandler = new SpeedHandler();

    private Pacman pacman;

    private Invoker invoker = new Invoker();

    private GameSubject scoringSystem = new GameEventSystem();

    private Timer timer;

    private int pelletEatenCount = 0;

    private Visitor insultGenerator = new InsultGenerator();
    private Visitor speedUpdater = new SpeedUpdater();


    public Model(KeyAdapter adapter) {
        loadImages();
        initVariables();
        addKeyListener(adapter);
        setFocusable(true);
    }


    public void loadImages() {
        heart = new ImageIcon("./Working/images/heart.png").getImage();
        powerUp = new ImageIcon("./Working/images/powerUp.gif").getImage();
        frightened = new ImageIcon("./Working/images/frightened.gif").getImage();
    }

    public void initVariables() {
        pelletHandler = pelletHandler.setNext(powerPelletHandler.setNext(fruitHandler.setNext(speedHandler.setNext(null))));
        screenData = new short[N_BLOCKS * N_BLOCKS];
        d = new Dimension(400, 400);
        pacman = new Pacman();
        scoringSystem.addObserver(scoreboard);
        scoringSystem.addObserver(this);
        
        timer = new Timer(40, this);
        timer.start();
    }

    private void playGame(Graphics2D g2d) {
        if (pacman.getDying()) {
            death();
        } else {
            movePacman();
            drawPacman(g2d);
            moveGhosts(g2d);
            checkMaze();
        }
    }

    private void showIntroScreen(Graphics2D g2d) {
    	String start = "Press SPACE to start";
        g2d.setColor(Color.yellow);
        g2d.drawString(start, (SCREEN_SIZE)/4, 150);
        if (scoreboard.getScore() != 0) {
            String score = "Final score: " + scoreboard.getScore();
            g2d.setColor(Color.yellow);
            g2d.drawString(score, (SCREEN_SIZE)/4, 170);
        }
    }

    private void drawScore(Graphics2D g) {
        g.setFont(smallFont);
        g.setColor(new Color(5, 181, 79));
        String s = "Score: " + scoreboard.getScore();
        g.drawString(s, SCREEN_SIZE / 2 + 96, SCREEN_SIZE + 16);

        for (int i = 0; i < pacman.getLives(); i++) {
            g.drawImage(heart, i * 28 + 8, SCREEN_SIZE + 1, this);
        }
    }

    private void checkMaze() {

        int i = 0;
        boolean finished = true;
        while (i < N_BLOCKS * N_BLOCKS && finished) {
            if ((screenData[i] & 16) != 0
                    || (screenData[i] & 32) != 0
                    || (screenData[i] & 64) != 0
                    || (screenData[i] & 128) != 0) {
                finished = false;
            }
            i++;
        }

        if (finished) {
            scoringSystem.notifyObservers(new GameEvent(GameEvent.EventType.GAME_FINISHED));
            GAMES_PLAYED++;
            initLevel();
        }
    }

    private void death() {
        pacman.setLives(pacman.getLives() - 1);
        GhostIterator ghostIterator = new GhostIterator(ghosts);
        while(ghostIterator.hasNext()) {
            Ghost ghost = ghostIterator.getNext();
            ghost.setFrightened(Boolean.FALSE);
            ghost.setX(96);
            ghost.setY(96);
        }
        if (pacman.getLives() == 0) {
            inGame = false;
        }

        continueLevel();
    }

    private void moveGhosts(Graphics2D g2d) {
        for (int i = 0; i < N_GHOSTS; i++) {
            var ghost = ghosts.get(i);
            ghost.move(pacman, screenData, BLOCK_SIZE, N_BLOCKS, ghosts, speedUpdater, pelletEatenCount);

            if (ghost.getFrightened()) {
                drawGhost(g2d, frightened,  ghost.getX() + 1, ghost.getY() + 1);
            } else {
                drawGhost(g2d, ghost.getColor(),  ghost.getX() + 1, ghost.getY() + 1);
            }

            if (pacman.getX() > (ghost.getX() - 12) && pacman.getX() < (ghost.getX() + 12)
                    && pacman.getY() > (ghost.getY() - 12) && pacman.getY() < (ghost.getY() + 12)
                    && inGame) {
                if (ghost.getFrightened()) {
                    pacman.eatGhost(scoringSystem);
                    ghosts.remove(i);
                    N_GHOSTS--;
                } else if(!pacman.getInvincible()) {
                    pacman.setDying(true);
                }
            }
        }
    }

    private void drawGhost(Graphics2D g2d, Image color, int x, int y) {
    	g2d.drawImage(color, x, y, this);
    }

    private void movePacman() {

        int pos;
        short ch;

        if (pacman.getX() % BLOCK_SIZE == 0 && pacman.getY() % BLOCK_SIZE == 0) {
            pos = pacman.getX() / BLOCK_SIZE + N_BLOCKS * (pacman.getY() / BLOCK_SIZE);
            ch = screenData[pos];

            pelletHandler.handle(new Request(ch, screenData, pacman, pos, ghosts, scoringSystem, ghostFrightenedFruit));


            if (invoker.isCommandSet()) {
                if(!((invoker.getCommandName().equals("LeftMove") && (ch & 1) != 0)
                        || (invoker.getCommandName().equals("RightMove") && (ch & 4) != 0)
                        || (invoker.getCommandName().equals("UpMove") && (ch & 2) != 0)
                        || (invoker.getCommandName().equals("DownMove") && (ch & 8) != 0))) {
                    invoker.runCommand(pacman);
                }
            }

            if(invoker.isCommandSet()) {
                if ((invoker.getCommandName().equals("LeftMove") && (ch & 1) != 0)
                        || (invoker.getCommandName().equals("RightMove") && (ch & 4) != 0)
                        || (invoker.getCommandName().equals("UpMove") && (ch & 2) != 0)
                        || (invoker.getCommandName().equals("DownMove") && (ch & 8) != 0)) {
                    pacman.setDX(0);
                    pacman.setDY(0);
                }
            }


        } 
        pacman.setX(pacman.getX() + pacman.getSpeed() * pacman.getDX());
        pacman.setY(pacman.getY() + pacman.getSpeed() * pacman.getDY());
    }

    private void drawPacman(Graphics2D g2d) {
        if (invoker.isCommandSet() && invoker.getCommandName().equals("LeftMove")) {
        	g2d.drawImage(pacman.getLeft(), pacman.getX() + 1, pacman.getY() + 1, this);
        } else if (invoker.isCommandSet() && invoker.getCommandName().equals("RightMove")) {
        	g2d.drawImage(pacman.getRight(), pacman.getX() + 1, pacman.getY() + 1, this);
        } else if (invoker.isCommandSet() && invoker.getCommandName().equals("UpMove")) {
        	g2d.drawImage(pacman.getUp(), pacman.getX() + 1, pacman.getY() + 1, this);
        } else {
        	g2d.drawImage(pacman.getDown(), pacman.getX() + 1, pacman.getY() + 1, this);
        }
    }

    private void drawMaze(Graphics2D g2d) {

        short i = 0;
        int x, y;

        for (y = 0; y < SCREEN_SIZE; y += BLOCK_SIZE) {
            for (x = 0; x < SCREEN_SIZE; x += BLOCK_SIZE) {

                g2d.setColor(new Color(0,72,251));
                g2d.setStroke(new BasicStroke(5));
                if ((levelData[i] == 0)) { 
                    g2d.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
                }

                if ((screenData[i] & 1) != 0) { 
                    g2d.drawLine(x, y, x, y + BLOCK_SIZE - 1);
                } 

                if ((screenData[i] & 2) != 0) { 
                    g2d.drawLine(x, y, x + BLOCK_SIZE - 1, y);
                }

                if ((screenData[i] & 4) != 0) { 
                    g2d.drawLine(x + BLOCK_SIZE - 1, y, x + BLOCK_SIZE - 1,
                            y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 8) != 0) { 
                    g2d.drawLine(x, y + BLOCK_SIZE - 1, x + BLOCK_SIZE - 1,
                            y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 32) != 0) {
                    g2d.drawImage(powerPellet.getImage(), x - 5, y - 5, 30, 30, this);
                }
                else if ((screenData[i] & 64) != 0) {
                    g2d.drawImage(fruit.getImage(), x - 5, y - 5, 35, 35, this);
                }
                else if ((screenData[i] & 16) != 0) {
                    if (epilepsy) {
                        Pellet pellet = PelletFactory.getItem(getRandomColor());
                        pellet.draw(g2d);
                    } else {
                        g2d.setColor(new Color(255,255,255));
                    }
                    g2d.fillOval(x + 10, y + 10, 6, 6);
                }
                else if ((screenData[i] & 128) != 0) {
                    g2d.drawImage(powerUp, x - 5, y - 5, 35, 35, this);
                }
                i++;
            }
        }
    }

    public void initializeGame() {
        GAMES_PLAYED = 0;
        pacman.setLives(3);
        scoringSystem.notifyObservers(new GameEvent(GameEvent.EventType.RESET));
        initLevel();
        N_GHOSTS = ghosts.size();
    }

    public Pacman getPacman() {
    	return this.pacman;
    }


    public GameSubject getScoringSystem() {
    	return this.scoringSystem;
    }

    public void setPacmanLives(int lives) {
    	this.pacman.setLives(lives);
    }

    private boolean epilepsy;

    public void setEpilepsy(boolean epilepsy) {
        this.epilepsy = epilepsy;
    }

    public void setScoringSystem(GameSubject scoringSystem) {
        this.scoringSystem = scoringSystem;
    }


    public void initLevel() {
        ghosts = new ArrayList<>();
        Ghost ghost = slowFactory.getBlinky();
        ghosts.add(ghost);
        ghost = fastFactory.getClyde();
        ghosts.add(ghost);
        ghost = slowFactory.getInky();
        ghosts.add(ghost);
        ghost = fastFactory.getPinky();
        ghosts.add(ghost);
        pelletEatenCount = 0;
        Random rnd = new Random();
        for (int i = 0; i < GAMES_PLAYED; i++) {
            ghost = ghosts.get(rnd.nextInt(0, ghosts.size()));
            ghosts.add(ghost.deepClone());
        }
        N_GHOSTS = ghosts.size();
        int i;
        for (i = 0; i < N_BLOCKS * N_BLOCKS; i++) {
            screenData[i] = levelData[i];
        }
        continueLevel();
    }

    private void continueLevel() {
        pacman.setX(7 * BLOCK_SIZE);  //start position
        pacman.setY(11 * BLOCK_SIZE);
        pacman.setDX(0);//reset direction move
        pacman.setDY(0);
        invoker = new Invoker();
        pacman.setDying(false);
    }

    private static Color getRandomColor() {
        return pelletColors.get((int)(Math.random()*pelletColors.size()));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, d.width, d.height);

        drawMaze(g2d);
        drawScore(g2d);

        if (inGame) {
            playGame(g2d);
        } else {
            showIntroScreen(g2d);
        }

        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }

    private final AtomicBoolean flag = new AtomicBoolean(false);
    @Override
    public void update(GameEvent event) {
        if (event.getType().equals(GameEvent.EventType.PELLET_EATEN)) {
            pelletEatenCount++;
        }

        if (flag.compareAndSet(false, true)) {
            if (pelletEatenCount == 30) {
                updateRandomPelletToPowerUp();
            }
            if(pelletEatenCount != 0 && pelletEatenCount % 20 == 0) {
                GhostIterator ghostIterator = new GhostIterator(ghosts);
                while(ghostIterator.hasNext()) {
                    Ghost ghost = ghostIterator.getNext();
                    ghost.accept(insultGenerator);
                }
            }
            flag.set(false);
        }
    }

    private void updateRandomPelletToPowerUp() {
        int[] validIndices = new int[screenData.length];
        int validCount = 0;

        for (int i = 0; i < screenData.length; i++) {
            if (screenData[i] == 16) {
                validIndices[validCount] = i;
                validCount++;
            }
        }

        if (validCount > 0) {
            int randomIndex = validIndices[(int) (Math.random() * validCount)];
            screenData[randomIndex] = 128;
        }
    }


    //controls
    public void handleInput(int key) {
        if (inGame) {
            if (key == KeyEvent.VK_LEFT) {
                this.invoker.setCommand(new LeftMove());
            } else if (key == KeyEvent.VK_RIGHT) {
                this.invoker.setCommand(new RightMove());
            } else if (key == KeyEvent.VK_UP) {
                this.invoker.setCommand(new UpMove());
            } else if (key == KeyEvent.VK_DOWN) {
                this.invoker.setCommand(new DownMove());
            } else if (key == KeyEvent.VK_ESCAPE && this.timer.isRunning()) {
                this.inGame = false;
            }
        } else {
            if (key == KeyEvent.VK_SPACE) {
                this.inGame = true;
                initializeGame();
            }
        }
    }
	
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}
