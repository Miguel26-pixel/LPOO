import java.util.ArrayList;
import java.util.List;

public class SlicedPizza implements Pizza{
    private Pizza pizza;
    private int slices;

    public SlicedPizza(Pizza pizza, int slices){
        this.pizza = pizza;
        this.slices = slices;
    }

    @Override
    public boolean addIngredient(Ingredient ing){
        return pizza.addIngredient(ing);
    }
    @Override
    public int getIngredientCount(){
        return pizza.getIngredientCount();
    }
    @Override
    public boolean contains(Ingredient ing){
        return pizza.contains(ing);
    }

    @Override
    public void setPrice(double price) {
        pizza.setPrice(price);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice()+2;
    }

    public int getSlices(){
        return this.slices;
    }
}
