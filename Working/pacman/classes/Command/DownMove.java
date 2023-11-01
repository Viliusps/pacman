package pacman.classes.Command;

import pacman.classes.Pacman;

public class DownMove implements ICommand {
	public void undo(Pacman pacman) {
		pacman.setDX(0);
		pacman.setDY(-1);
	}
	
	public void execute(Pacman pacman) {
		pacman.setDX(0);
		pacman.setDY(1);
	}
}
