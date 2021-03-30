import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concert implements Comparable<Concert>{
    private List<Act> acts = new ArrayList<>();
    private String city;
    private String country;
    private String date;
    private int number_ticket = 0;
    public Concert(String city, String country, String date){
        this.city = city;
        this.country = country;
        this.date = date;
    }
    public String getCity(){
        return this.city;
    }
    public String getCountry(){
        return this.country;
    }
    public String getDate(){
        return this.date;
    }
    public void addAct(Act a){
        this.acts.add(a);
    }
    public List<Act> getActs(){
        return this.acts;
    }
    @Override
    public int compareTo(Concert c){
        if(getCity().compareTo(c.getCity()) + getCountry().compareTo(c.getCountry()) + getDate().compareTo(c.getDate())==0) {
            return 0;
        }
        return 1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(acts, city, country, date);
    }

    @Override
    public boolean equals(Object o){
        Concert c = (Concert) o;
        return getCity().equals(c.getCity()) && getCountry().equals(c.getCountry()) && getDate().equals(c.getDate());
    }

    public boolean isValid(Ticket t){
        return t.getConcert().equals(this);
    }

    public boolean participates(Artist a){
        for(Act act : acts) {
            if (act.getClass() == Band.class) {
                Band art = (Band) act;
                if(art.containsArtist(a))
                    return true;
            }
            else{
                if(a.equals(act))
                    return true;
            }
        }
        return false;
    }

    public int UpNumber_ticket(){
        number_ticket++;
        return number_ticket;
    }
}
