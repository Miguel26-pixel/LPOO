import java.util.Objects;

public class Ingredient {
    private String name;
    public Ingredient(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public boolean equals(Object o){
        Ingredient ing = (Ingredient) o;
        return this.getName().equals(ing.getName());
    }
}
