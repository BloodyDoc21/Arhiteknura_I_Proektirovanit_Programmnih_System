public class HotDish extends Dish {
    private boolean spicy;

    public HotDish(String name, double price, int cookingTime,
            boolean spicy) {
        super(name, price, "Горячее", cookingTime);
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
