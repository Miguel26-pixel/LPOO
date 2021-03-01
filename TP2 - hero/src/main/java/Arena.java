import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private List<Wall> walls;
    public Arena(int width, int height){
        hero = new Hero(width/2, height/2);
        this.width = width;
        this.height = height;
        this.walls = createWalls();
    }
    public boolean canHeroMove(Position pos)
    {
        for (Wall wall : walls) {
            if(wall.getPosition().equals(pos))
                return false;
        }
        return !(hero.getPosition().getPositionX() < 0 || hero.getPosition().getPositionX() >= width || hero.getPosition().getPositionY() < 0 || hero.getPosition().getPositionY() >= height);
    }
    public void moveHero(Position pos)
    {
        if(canHeroMove(pos)) {
            hero.getPosition().setPositionX(pos.getPositionX());
            hero.getPosition().setPositionY(pos.getPositionY());
        }
    }

    public Position MoveUp(int n)
    {
        return new Position(hero.getPosition().getPositionX(),hero.getPosition().getPositionY()-n);
    }
    public Position MoveDown(int n)
    {
        return new Position(hero.getPosition().getPositionX(),hero.getPosition().getPositionY()+n);
    }
    public Position MoveRight(int n)
    {
        return new Position(hero.getPosition().getPositionX()+n,hero.getPosition().getPositionY());
    }
    public Position MoveLeft(int n)
    {
        return new Position(hero.getPosition().getPositionX()-n,hero.getPosition().getPositionY());
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');


        for (Wall wall : walls)
            wall.draw(graphics);


        hero.draw(graphics);
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }
}
