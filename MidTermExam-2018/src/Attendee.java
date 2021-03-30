import java.io.*;
import java.lang.*;

public class Attendee extends User{
    private boolean paid;
    public Attendee(String name){
        super(name);
        this.paid = false;
    }
    public Attendee(String name, int age){
        super(name,age);
        this.paid = false;
    }
    public Attendee(String name, int age, boolean paid){
        super(name,age);
        this.paid = paid;
    }
    public boolean hasPaid(){
        return this.paid;
    }
    @Override
    public String toString() {
        return String.format("Attendee " + this.getName() + (this.hasPaid() ? " has" : " hasn't") + " paid its registration.");
    }
}
