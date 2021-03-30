import java.io.*;
import java.lang.*;

public class Speaker extends User{
    private int fee;
    public Speaker(String name){
        super(name);
        this.fee = 0;
    }
    public Speaker(String name, int age){
        super(name,age);
        this.fee = 0;
    }
    public Speaker(String name, int age, int fee){
        super(name,age);
        this.fee = fee;
    }
    public int getFee(){
        return this.fee;
    }
    @Override
    public String toString() {
        return String.format("Speaker " + this.getName() + " has a fee value of " + this.getFee() + ".");
    }
}