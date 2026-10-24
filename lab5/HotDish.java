public class HotDish extends Dish {
    private boolean spicy;

    public HotDish(String name, double price, Category category,
            int cookingTime, boolean spicy) {
        super(name, price, category, cookingTime);
        this.spicy = spicy;
    }

    public boolean isSpicy() {
        return spicy;
    }

    @Override
    public String getInfo() {
        if (spicy) {
            return super.getInfo() + " (острое)";
        }
        return super.getInfo();
    }
}
