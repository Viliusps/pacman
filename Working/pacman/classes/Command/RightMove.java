package pacman.classes.Command;

import pacman.classes.Pacman;

public class RightMove implements ICommand {
	public void undo(Pacman pacman) {
		pacman.setDX(-1);
		pacman.setDY(0);
	}
	
	public void execute(Pacman pacman) {
		pacman.setDX(1);
		pacman.setDY(0);
	}
}
