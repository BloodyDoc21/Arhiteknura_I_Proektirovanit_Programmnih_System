public abstract class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        setName(name);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(
                    "Название не может быть пустым");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(
                    "Цена должна быть больше нуля");
        }
        this.price = price;
    }

    public abstract String getInfo();
}
