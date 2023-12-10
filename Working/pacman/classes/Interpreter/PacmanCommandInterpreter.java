package pacman.classes.Interpreter;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import pacman.Model;

public class PacmanCommandInterpreter {
    private Model model;
    private Timer commandTimer;
    private int currentIndex;
    private List<String> commandList;

    public PacmanCommandInterpreter(Model model) {
        this.model = model;
        this.commandTimer = new Timer(1000, new CommandTimerListener());
    }

    public void interpretCommand(String commands) {
        this.commandList = Arrays.asList(commands.toUpperCase().split("\\s+"));
        this.currentIndex = 0;
        commandTimer.start();
    }

    private class CommandTimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentIndex < commandList.size()) {
                String command = commandList.get(currentIndex);
                CommandExpression commandExpression = switch (command) {
                    case "UP" -> new MoveUpExpression();
                    case "DOWN" -> new MoveDownExpression();
                    case "LEFT" -> new MoveLeftExpression();
                    case "RIGHT" -> new MoveRightExpression();
                    default -> null;
                };

                if (commandExpression != null) {
                    commandExpression.interpret(model);
                } else {
                    System.out.println("Invalid command: " + command);
                }

                currentIndex++;
            } else {
                commandTimer.stop();
            }
        }
    }
}
