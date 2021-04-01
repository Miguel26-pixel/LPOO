import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MediumPizza implements Pizza {
    private List<Ingredient> ingredients = new ArrayList<>();
    private double price= 0.0;
    public MediumPizza(){}
    @Override
    public boolean addIngredient(Ingredient ing){
        if(!ingredients.contains(ing)){
            ingredients.add(ing);
            return true;
        }
        return false;
    }
    @Override
    public int getIngredientCount(){
        return this.ingredients.size();
    }
    public List<Ingredient> getIngredients(){
        return this.ingredients;
    }
    @Override
    public boolean contains(Ingredient ing){
        return this.ingredients.contains(ing);
    }
    @Override
    public void setPrice(double price){
        this.price = price;
    }
    @Override
    public double getPrice(){
        return this.price;
    }

}
