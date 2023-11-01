package pacman;

import javax.swing.JFrame;

public class Client extends JFrame{
	public Client() {
		add(new Model());
	}
	
	public static void main(String[] args) {
		Client pac = new Client();
		pac.setVisible(true);
		pac.setTitle("Pacman");
		pac.setSize(380,420);
		pac.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pac.setLocationRelativeTo(null);
		
	}

}
