import java.util.ArrayList;
import java.util.List;

public class GenericRecipe extends Recipe{
    private List<Ingredient> ingredients = new ArrayList<>();
    public GenericRecipe(List<Ingredient> ingredients){
        super();
        this.ingredients = ingredients;
    }
    @Override
    public Pizza makeMediumPizza(){
        MediumPizza pizza = new MediumPizza();
        for (Ingredient ing : ingredients){
            pizza.addIngredient(ing);
        }
        return pizza;
    }
}
