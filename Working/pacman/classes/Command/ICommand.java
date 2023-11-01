package pacman.classes.Command;

import pacman.classes.Pacman;

public interface ICommand {
	void undo(Pacman pacman);
	void execute(Pacman pacman);
}
