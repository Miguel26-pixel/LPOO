import java.util.Objects;

public abstract class Act {
    private String name;
    private String country;
    public Act(String name, String country){
        this.name = name;
        this.country = country;
    }
    public String getName(){
        return this.name;
    }
    public String getCountry(){
        return this.country;
    }

    @Override
    public boolean equals(Object o){
        Act c = (Act) o;
        return getName().equals(c.getName()) && getCountry().equals(c.getCountry());
    }
}
