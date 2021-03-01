import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Arena arena;
    public Game() {
        arena = new Arena(40,40);
        TerminalSize terminalSize = new TerminalSize(40, 40);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        try {
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void Run(){

        try {
            Draw();
            KeyStroke key = screen.readInput();
            while(!(KeyType.Character == key.getKeyType() && key.getCharacter() == 'q')) {
                Draw();
                System.out.println(key.getKeyType());
                processKey(key);
                if (key.getKeyType() == KeyType.ArrowUp) {
                    arena.moveHero(arena.MoveUp(1));
                }
                else if (key.getKeyType() == KeyType.ArrowDown) {
                    arena.moveHero(arena.MoveDown(1));
                }
                else if (key.getKeyType() == KeyType.ArrowLeft) {
                    arena.moveHero(arena.MoveLeft(1));
                }
                else if (key.getKeyType() == KeyType.ArrowRight) {
                    arena.moveHero(arena.MoveRight(1));
                }
                key = screen.readInput();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Draw() {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processKey(KeyStroke key) {
        System.out.println(key);
    }

}
