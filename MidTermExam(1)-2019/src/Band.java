import java.util.ArrayList;
import java.util.List;

public class Band extends Act{
    private List<Artist> artists = new ArrayList<>();
    public Band(String name, String country)
    {
        super(name, country);
    }
    public void addArtist(Artist a){
        this.artists.add(a);
    }
    public List<Artist> getArtists(){
        return this.artists;
    }
    public boolean containsArtist(Artist a){
        return this.artists.contains(a);
    }
}
