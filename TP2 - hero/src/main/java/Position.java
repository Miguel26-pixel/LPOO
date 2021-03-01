public class Position {
    private int x;
    private int y;
    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public int getPositionX()
    {
        return x;
    }
    public int getPositionY()
    {
        return y;
    }
    public void setPositionX(int x)
    {
        this.x = x;
    }
    public void setPositionY(int y)
    {
        this.y = y;
    }

    @Override
    public boolean equals(Object pos) {
        if (this == pos) return true;

        if (pos == null) return false;

        if (getClass() != pos.getClass()) return false;


        Position position = (Position) pos;
        return x==position.getPositionX() && y==position.getPositionY();
    }
}
