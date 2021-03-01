import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    public Arena(int width, int height){
        hero = new Hero(width/2, height/2);
        this.width = width;
        this.height = height;
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
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
        for (Coin coin : coins)
            coin.draw(graphics);
        for (Monster monster : monsters)
            monster.draw(graphics);


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


    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }


    private List<Monster> createMonsters(){
        Random random = new Random();
        List<Monster> monsters = new ArrayList<>();
        for(int i=0; i<5; i++){
            int x, y;
            boolean overlap;
            do {
                x = random.nextInt(width - 2) + 1;
                y = random.nextInt(height - 2) + 1;

                //Check collision with other coins
                overlap = false;
                for(Monster monster : monsters){
                    if(monster.getPosition().equals(new Position(x, y))) overlap = true;
                }

            } while(overlap || !canHeroMove(new Position(x, y)));
            monsters.add(new Monster(x, y));
        }
        return monsters;
    }

    public void retrieveCoins(){
        Coin selectedCoin = null;
        for (Coin coin : coins) {
            if(coin.getPosition().equals(hero.getPosition())) {
                selectedCoin = coin;
                break;
            }
        }
        if(selectedCoin != null)
            coins.remove(selectedCoin);
    }

    public boolean verifyMonsterCollisions(){
        for(Monster monster : monsters){
            if(monster.getPosition().equals(hero.getPosition()))
                return false;
        }
        return true;
    }

    public void moveMonsters(){
        for (Monster monster : monsters){
            monster.getPosition().setPositionX(monster.move().getPositionX());
            monster.getPosition().setPositionY(monster.move().getPositionY());
        }

    }
}
