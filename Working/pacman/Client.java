package pacman;

import pacman.classes.Facade.Facade;

import javax.swing.*;

public class Client extends JFrame{
	private Facade facade;
	public Client() {
		facade = new Facade();
		add(facade);
		setTitle("Pacman");
		setSize(380, 420);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public void play() {
		facade.startGame();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Client pac = new Client();
			pac.play();
		});
	}

}
