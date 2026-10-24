public class Drink extends Dish {
    private int volume;

    public Drink(String name, double price, Category category,
            int volume) {
        super(name, price, category, 2);
        if (volume <= 0) {
            throw new IllegalArgumentException(
                    "Объем должен быть больше нуля");
        }
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " (" + volume + " мл)";
    }
}
