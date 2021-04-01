import java.util.ArrayList;
import java.util.List;

public class Icecream {
    private List<Flavor> flavors = new ArrayList<>();
    public Icecream(){}
    public void addScoop(Flavor flavor){
        flavors.add(flavor);
    }
    public int getScoopCount(){
        return flavors.size();
    }
    public boolean contains(String flavor){
        return flavors.contains(new Flavor(flavor));
    }
}
