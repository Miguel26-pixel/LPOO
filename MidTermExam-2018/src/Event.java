import java.io.*;
import java.lang.*;
import java.util.List;
import java.util.TreeSet;

public class Event {
    private String title;
    private String date;
    private String description;
    private TreeSet<Person> people = new TreeSet<>();
    public Event(String title){
        this.title = title;
        this.date = "";
        this.description = "";
    }
    public Event(String title, String date){
        this.title = title;
        this.date = date;
        this.description = "";
    }
    public Event(String title, String date, String description){
        this.title = title;
        this.date = date;
        this.description = description;

    }
    public Event(Event event){
        this.title = event.title;
        this.date = event.date;
        this.description = event.description;
        this.people = event.people;
    }
    public String getTitle(){
        return this.title;
    }
    public String getDate(){
        return this.date;
    }
    public String getDescription(){
        return this.description;
    }
    public TreeSet<Person> getPeople(){ return this.people; }
    public void setTitle(String newTitle){
        this.title = newTitle;
    }
    public void setDate(String newDate){
        this.date = newDate;
    }
    public void setDescription(String newDescription){
        this.description = newDescription;
    }

    @Override
    public String toString() {
        return String.format(this.title + " is a "+ this.description + " and will be held at "+ this.date + ".");
    }

    @Override
    public boolean equals(Object o) {
        if(this== o)return true;
        if(o ==null)return false;
        if(getClass() != o.getClass())return false;
        Event e = (Event) o;
        return this.title == e.getTitle() && this.date == e.getDate() && this.description == e.getDescription();
    }
    public void addPerson(Person p){
        if(!people.contains(p))
            people.add(p);
    }
    public int getAudienceCount(){
        return people.size();

    }

    public int compareTo(Event event){
        return getTitle().compareTo(event.getTitle());
    }

}
