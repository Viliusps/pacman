package pacman.classes.Interpreter;

import pacman.Model;
import pacman.classes.Pacman;

import java.awt.event.KeyEvent;

public class MoveUpExpression implements CommandExpression {
    @Override
    public void interpret(Model model) {
        model.handleInput(KeyEvent.VK_UP);
    }

}
