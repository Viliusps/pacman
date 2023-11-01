package pacman.classes.Command;

import pacman.classes.Pacman;

public class Invoker {
	private ICommand command;
	
	public void runCommand(Pacman pacman) {
		this.command.execute(pacman);
	}

	public Boolean isCommandSet() {
		return command != null;
	}

	public void setCommand(ICommand command) {
		this.command = command;
	}

	public String getCommandName() {
		return this.command.getClass().getSimpleName();
	}
	
	public void undo(Pacman pacman) {
		this.command.undo(pacman);
	}
}
