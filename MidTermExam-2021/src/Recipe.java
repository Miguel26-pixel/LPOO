import java.util.List;

public abstract class Recipe {
    public Recipe(){}
    public Pizza makeMediumPizza(){
        return new MediumPizza();
    }
}
