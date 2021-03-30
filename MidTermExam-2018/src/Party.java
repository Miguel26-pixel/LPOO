import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Party extends Event{
    private final List<Event> eventList = new ArrayList<>();
    public Party(String title){
        super(title);
    }
    public Party(String title, String date){
        super(title,date);
    }
    public Party(String title, String date, String description){
        super(title,date,description);
    }
    public void addEvent(Event event){
            eventList.add(event);
    }
    @Override
    public int getAudienceCount(){
        if(eventList.isEmpty())return getPeople().size();
        int count = 0;
        for(Event event : eventList){
            count += event.getAudienceCount();
        }
        return count + getPeople().size();
    }
}

