public class Dessert extends Dish {
    private int calories;

    public Dessert(String name, double price, int cookingTime,
            int calories) {
        super(name, price, "Десерт", cookingTime);
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " (" + calories + " ккал)";
    }
}
