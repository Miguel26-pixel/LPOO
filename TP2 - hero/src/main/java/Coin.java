import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Element{
    //private Position position;
    public Coin(int x, int y) {
        super(x,y);
    }


    @Override
    public void draw(TextGraphics graphics){
        graphics.putString(new TerminalPosition(this.getPosition().getPositionX() * 2, this.getPosition().getPositionY() * 2), "\\/");
    }
}