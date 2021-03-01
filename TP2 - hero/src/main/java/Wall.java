import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element{
    //private Position position;
    public Wall(int x, int y) {
        super(x,y);
    }


    @Override
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BORDERED);
        graphics.putString(getPosition().getPositionX(), getPosition().getPositionY(), "#");
    }
}