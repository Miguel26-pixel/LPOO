public class MargueritaRecipe extends Recipe{
    public MargueritaRecipe(){
        super();
    }
    @Override
    public Pizza makeMediumPizza(){
        MediumPizza medium = new MediumPizza();
        medium.addIngredient(new Ingredient("Tomato"));
        medium.addIngredient(new Ingredient("Mozzarella"));
        medium.addIngredient(new Ingredient("Basil"));
        return medium;
    }
}
