public class MargueritaCertifier extends PizzaCertifier{
    public MargueritaCertifier(){
        super();
    }
    @Override
    public boolean isCertified(Pizza pizza){
        if(pizza.getIngredientCount()<3)return false;
        return pizza.contains(new Ingredient("Tomato")) && pizza.contains(new Ingredient("Mozzarella")) && pizza.contains(new Ingredient("Basil")) && pizza.getIngredientCount()==3;
    }

}
