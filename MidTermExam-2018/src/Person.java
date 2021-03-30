import java.io.*;
import java.lang.*;
import java.util.*;

public abstract class Person implements Comparable<Person>{
    private String name;
    private int age;
    public Person(String name){
        this.name = name;
        this.age = 0;
    }
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }

    @Override
    public int compareTo(Person st){
        return getName().compareTo(st.getName());
    }
}
