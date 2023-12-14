package pacman;

import pacman.classes.Facade.Facade;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame implements IClient {
	private final Facade facade;
	private Timer timer;
	private Timer timer2;


	public Client(boolean epilepsy) {
		facade = new Facade(3, epilepsy);
		add(facade.getModel());
		setTitle("Pacman");
		setSize(380, 420);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public void takeSnapshot() {
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				facade.takeSnapshot();
			}
		};

		// Create a Timer with a 10-second delay
		timer2 = new Timer(10000, taskPerformer);

		// Start the timer
		timer2.start();
	}

	public void resetGame() {
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				facade.restoreSnapshot();
				System.out.println("Game reset");
			}
		};

		// Create a Timer with a 10-second delay
		timer = new Timer(15000, taskPerformer);

		// Start the timer
		timer.start();
	}

	public void play(boolean epilepsy) {
		facade.startGame();
		setVisible(true);
		takeSnapshot();
		resetGame();
	}
	
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(() -> {
//			Client pac = new Client();
//			pac.play();
//		});
//	}
}
