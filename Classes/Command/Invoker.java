package Command;

public class Invoker
{
	private ICommand command;
	
	public void runCommand( )
	{
		this.command.execute();
	}

	public void setCommand(ICommand command)
	{
		this.command = command;
	}
	
	public void undo()
	{
		this.command.undo();
	}
	
	
}
