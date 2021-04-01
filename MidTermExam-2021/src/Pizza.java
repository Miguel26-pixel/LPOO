import java.util.ArrayList;
import java.util.*;

public interface Pizza {
    boolean addIngredient(Ingredient ing);
    int getIngredientCount();
    boolean contains(Ingredient ing);
    void setPrice(double price);
    double getPrice();
}
