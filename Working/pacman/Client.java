package pacman;

import pacman.classes.Facade.GameFacade;

import javax.swing.*;

public class Client extends JFrame{
	private GameFacade gameFacade;
	public Client() {
		gameFacade = new GameFacade();
		add(gameFacade.getModel());
		setTitle("Pacman");
		setSize(380, 420);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public void play() {
		gameFacade.startGame();
		setVisible(true);
	}


	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Client pac = new Client();
			pac.play();
		});


	}

}
