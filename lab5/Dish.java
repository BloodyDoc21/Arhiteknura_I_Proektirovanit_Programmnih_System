public class Dish extends MenuItem {
    private Category category;
    private int cookingTime;

    public Dish(String name, double price, Category category,
            int cookingTime) {
        super(name, price);
        this.category = category;
        setCookingTime(cookingTime);
    }

    public Category getCategory() {
        return category;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        if (cookingTime <= 0) {
            throw new IllegalArgumentException(
                    "Время приготовления должно быть больше нуля");
        }
        this.cookingTime = cookingTime;
    }

    @Override
    public String getInfo() {
        return getName() + " - " + getPrice() + " руб., "
                + cookingTime + " мин.";
    }
}
