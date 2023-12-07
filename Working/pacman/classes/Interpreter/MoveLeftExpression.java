package pacman.classes.Interpreter;

import pacman.Model;

import java.awt.event.KeyEvent;

public class MoveLeftExpression implements CommandExpression{
    @Override
    public void interpret(Model model) {
        model.handleInput(KeyEvent.VK_LEFT);
    }
}
