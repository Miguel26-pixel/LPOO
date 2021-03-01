import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Element {
    private Position position;
    public Element(int x, int y) {
        position = new Position(x,y);
    }
    public Position getPosition(){
        return position;
    }
    public void draw(TextGraphics graphics){};
}
