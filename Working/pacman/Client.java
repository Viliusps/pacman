package pacman;

import pacman.classes.Facade.Facade;

import javax.swing.*;

public class Client extends JFrame {
	private final Facade facade;
	public Client(boolean epilepsy) {
		facade = new Facade(3, epilepsy);
		add(facade.getModel());
		setTitle("Pacman");
		setSize(380, 420);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		play();
	}

	public void play() {
		facade.startGame();
		setVisible(true);
	}
	
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(() -> {
//			Client pac = new Client();
//			pac.play();
//		});
//	}
}
