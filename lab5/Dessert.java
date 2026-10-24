public class Dessert extends Dish {
    private int calories;

    public Dessert(String name, double price, Category category,
            int cookingTime, int calories) {
        super(name, price, category, cookingTime);
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
