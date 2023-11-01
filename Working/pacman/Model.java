package pacman;

import pacman.classes.AbstractFactory.FastFactory;
import pacman.classes.AbstractFactory.SlowFactory;
import pacman.classes.Ghost;

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
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import pacman.classes.Pacman;

public class Model extends JPanel implements ActionListener {

	private Dimension d;
    private final Font smallFont = new Font("Arial", Font.BOLD, 14);
    private boolean inGame = false;

    private final int BLOCK_SIZE = 24;
    private final int N_BLOCKS = 15;
    private final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;
    private final int MAX_GHOSTS = 12;

    private int N_GHOSTS = 4;
    private int[] dx, dy;

    private List<Ghost> ghosts;

    private Image heart;
    private Image up, down, left, right;

    private Pacman pacman;

    private int req_dx, req_dy;

    private final short[] levelData = {
    	19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
        17, 16, 16, 16, 16, 24, 16, 16, 16, 16, 16, 16, 16, 16, 20,
        25, 24, 24, 24, 28, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
        0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
        19, 18, 18, 18, 18, 18, 16, 16, 16, 16, 24, 24, 24, 24, 20,
        17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
        17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
        17, 16, 16, 16, 24, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
        17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 18, 18, 18, 18, 20,
        17, 24, 24, 28, 0, 25, 24, 24, 16, 16, 16, 16, 16, 16, 20,
        21, 0,  0,  0,  0,  0,  0,   0, 17, 16, 16, 16, 16, 16, 20,
        17, 18, 18, 22, 0, 19, 18, 18, 16, 16, 16, 16, 16, 16, 20,
        17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
        17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
        25, 24, 24, 24, 26, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28
    };

    private final int maxSpeed = 6;

    private int currentSpeed = 3;
    private short[] screenData;
    private Timer timer;

    public Model() {

        loadImages();
        initVariables();
        addKeyListener(new TAdapter());
        setFocusable(true);
        initGame();
    }
    
    
    private void loadImages() {
    	down = new ImageIcon("./Working/images/down.gif").getImage();
    	up = new ImageIcon("./Working/images/up.gif").getImage();
    	left = new ImageIcon("./Working/images/left.gif").getImage();
    	right = new ImageIcon("./Working/images/right.gif").getImage();
        heart = new ImageIcon("./Working/images/heart.png").getImage();
    }
    private void initVariables() {
        screenData = new short[N_BLOCKS * N_BLOCKS];
        d = new Dimension(400, 400);
        ghosts = new ArrayList<>();
        pacman = new Pacman();
        dx = new int[4];
        dy = new int[4];
        
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
    }

    private void drawScore(Graphics2D g) {
        g.setFont(smallFont);
        g.setColor(new Color(5, 181, 79));
        String s = "Score: " + pacman.getScore();
        g.drawString(s, SCREEN_SIZE / 2 + 96, SCREEN_SIZE + 16);

        for (int i = 0; i < pacman.getLives(); i++) {
            g.drawImage(heart, i * 28 + 8, SCREEN_SIZE + 1, this);
        }
    }

    private void checkMaze() {

        int i = 0;
        boolean finished = true;

        while (i < N_BLOCKS * N_BLOCKS && finished) {

            if ((screenData[i]) != 0) {
                finished = false;
            }

            i++;
        }

        if (finished) {

            pacman.addScore(50);

            if (N_GHOSTS < MAX_GHOSTS) {
                N_GHOSTS++;
            }

            if (currentSpeed < maxSpeed) {
                currentSpeed++;
            }

            initLevel();
        }
    }

    private void death() {

        pacman.setLives(pacman.getLives() - 1);

        if (pacman.getLives() == 0) {
            inGame = false;
        }

        continueLevel();
    }

    private void moveGhosts(Graphics2D g2d) {
        int pos;
        int count;

        for (int i = 0; i < N_GHOSTS; i++) {
            var ghost = ghosts.get(i);
            if (ghost.getX() % BLOCK_SIZE == 0 && ghost.getY() % BLOCK_SIZE == 0) {
                pos = ghost.getX() / BLOCK_SIZE + N_BLOCKS * (ghost.getY() / BLOCK_SIZE);

                count = 0;

                if ((screenData[pos] & 1) == 0 && ghost.getDx() != 1) {
                    dx[count] = -1;
                    dy[count] = 0;
                    count++;
                }

                if ((screenData[pos] & 2) == 0 && ghost.getDy() != 1) {
                    dx[count] = 0;
                    dy[count] = -1;
                    count++;
                }

                if ((screenData[pos] & 4) == 0 && ghost.getDx() != -1) {
                    dx[count] = 1;
                    dy[count] = 0;
                    count++;
                }

                if ((screenData[pos] & 8) == 0 && ghost.getDy() != -1) {
                    dx[count] = 0;
                    dy[count] = 1;
                    count++;
                }

                if (count == 0) {

                    if ((screenData[pos] & 15) == 15) {
                        ghost.setDx(0);
                        ghost.setDy(0);
                    } else {
                        ghost.setDx(-ghost.getDx());
                        ghost.setDy(-ghost.getDy());
                    }

                } else {

                    count = (int) (Math.random() * count);

                    if (count > 3) {
                        count = 3;
                    }
                    ghost.setDx(dx[count]);
                    ghost.setDy(dy[count]);
                }

            }

            ghost.setX(ghost.getX()+(ghost.getDx()) * ghost.getSpeed());
            ghost.setY(ghost.getY()+(ghost.getDy()) * ghost.getSpeed());

            drawGhost(g2d, ghost.getColor(),  ghost.getX() + 1, ghost.getY() + 1);

            if (pacman.getX() > (ghost.getX() - 12) && pacman.getX() < (ghost.getX() + 12)
                    && pacman.getY() > (ghost.getY() - 12) && pacman.getY() < (ghost.getY() + 12)
                    && inGame) {

                pacman.setDying(true);
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

            if ((ch & 16) != 0) {
                screenData[pos] = (short) (ch & 15);
                pacman.addScore(1);
            }

            if (req_dx != 0 || req_dy != 0) {
                if (!((req_dx == -1 && req_dy == 0 && (ch & 1) != 0)
                        || (req_dx == 1 && req_dy == 0 && (ch & 4) != 0)
                        || (req_dx == 0 && req_dy == -1 && (ch & 2) != 0)
                        || (req_dx == 0 && req_dy == 1 && (ch & 8) != 0))) {
                    pacman.setDX(req_dx);
                    pacman.setDY(req_dy);
                }
            }

            // Check for standstill
            if ((pacman.getDX()== -1 && pacman.getDY() == 0 && (ch & 1) != 0)
                    || (pacman.getDX() == 1 && pacman.getDY() == 0 && (ch & 4) != 0)
                    || (pacman.getDX() == 0 && pacman.getDY() == -1 && (ch & 2) != 0)
                    || (pacman.getDX() == 0 && pacman.getDY() == 1 && (ch & 8) != 0)) {
                pacman.setDX(0);
                pacman.setDY(0);
            }
        } 
        pacman.setX(pacman.getX() + pacman.getSpeed() * pacman.getDX());
        pacman.setY(pacman.getY() + pacman.getSpeed() * pacman.getDY());
    }

    private void drawPacman(Graphics2D g2d) {

        if (req_dx == -1) {
        	g2d.drawImage(left, pacman.getX() + 1, pacman.getY() + 1, this);
        } else if (req_dx == 1) {
        	g2d.drawImage(right, pacman.getX() + 1, pacman.getY() + 1, this);
        } else if (req_dy == -1) {
        	g2d.drawImage(up, pacman.getX() + 1, pacman.getY() + 1, this);
        } else {
        	g2d.drawImage(down, pacman.getX() + 1, pacman.getY() + 1, this);
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

                if ((screenData[i] & 16) != 0) { 
                    g2d.setColor(new Color(255,255,255));
                    g2d.fillOval(x + 10, y + 10, 6, 6);
               }

                i++;
            }
        }
    }

    private void initGame() {
        pacman.setLives(3);
        pacman.setScore(0);
        initLevel();
        N_GHOSTS=4;
        currentSpeed = 3;
    }

    private void initLevel() {

        int i;
        for (i = 0; i < N_BLOCKS * N_BLOCKS; i++) {
            screenData[i] = levelData[i];
        }

        continueLevel();
    }

    private void continueLevel() {
        var fastFactory = new FastFactory();
        var slowFactory = new SlowFactory();

        ghosts.add(fastFactory.getBlinky());
        ghosts.add(fastFactory.getClyde());
        ghosts.add(slowFactory.getInky());
        ghosts.add(slowFactory.getPinky());

        pacman.setX(7 * BLOCK_SIZE);  //start position
        pacman.setY(11 * BLOCK_SIZE);
        pacman.setDX(0);//reset direction move
        pacman.setDY(0);
        req_dx = 0;		// reset direction controls
        req_dy = 0;
        pacman.setDying(false);
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


    //controls
    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (inGame) {
                if (key == KeyEvent.VK_LEFT) {
                    req_dx = -1;
                    req_dy = 0;
                } else if (key == KeyEvent.VK_RIGHT) {
                    req_dx = 1;
                    req_dy = 0;
                } else if (key == KeyEvent.VK_UP) {
                    req_dx = 0;
                    req_dy = -1;
                } else if (key == KeyEvent.VK_DOWN) {
                    req_dx = 0;
                    req_dy = 1;
                } else if (key == KeyEvent.VK_ESCAPE && timer.isRunning()) {
                    inGame = false;
                } 
            } else {
                if (key == KeyEvent.VK_SPACE) {
                    inGame = true;
                    initGame();
                }
            }
        }
}

	
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
		
	}
