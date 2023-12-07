package pacman.classes.Interpreter;

import pacman.Model;

public class PacmanCommandInterpreter {
    private Model model;
    public PacmanCommandInterpreter(Model model) {
        this.model = model;
    }
    public void interpretCommand(String command) {
        CommandExpression commandExpression = switch (command.toUpperCase()) {
            case "UP" -> new MoveUpExpression();
            case "DOWN" -> new MoveDownExpression();
            case "LEFT" -> new MoveLeftExpression();
            case "RIGHT" -> new MoveRightExpression();
            default -> null;
        };
        if (commandExpression != null)
            commandExpression.interpret(model);
        else {
            System.out.println("Invalid command");
        }
    }
}
