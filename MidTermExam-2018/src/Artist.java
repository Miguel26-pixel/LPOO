import java.io.*;
import java.lang.*;

public class Artist extends User {
    private boolean paid;
    public Artist(String name){
        super(name);
        this.paid = false;
    }
    public Artist(String name, int age){
        super(name,age);
        this.paid = false;
    }
    public Artist(String name, int age, boolean paid){
        super(name,age);
        this.paid = paid;
    }
    public boolean hasPaid(){
        return this.paid;
    }
    @Override
    public String toString() {
        return String.format("Artist " + this.getName() + (this.hasPaid() ? " has" : " hasn't") + " paid its registration.");
    }
}
