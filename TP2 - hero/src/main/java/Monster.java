import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element{
    //private Position position;
    public Monster(int x, int y) {
        super(x,y);
    }

    public Position move(){
        Random random = new Random();
        while(true){
            switch(random.nextInt(26)) {
                case 0:
                    return new Position(getPosition().getPositionX(), getPosition().getPositionY() - 1);
                case 1:
                    return new Position(getPosition().getPositionX(), getPosition   ().getPositionY() + 1);
                case 2:
                    return new Position(getPosition().getPositionX() - 1, getPosition().getPositionY());
                case 3:
                    return new Position(getPosition().getPositionX() + 1, getPosition().getPositionY());
            }
        }
    }

    @Override
    public void draw(TextGraphics graphics){
        graphics.putString(new TerminalPosition(this.getPosition().getPositionX() , this.getPosition().getPositionY()), "?");
    }
}