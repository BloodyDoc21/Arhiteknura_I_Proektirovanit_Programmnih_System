import java.util.ArrayList;
import java.util.List;

public class Order {
    private int number;
    private Table table;
    private List<Dish> dishes;
    private String status;
    private int discount;

    public Order(int number, Table table) {
        this.number = number;
        this.table = table;
        this.dishes = new ArrayList<>();
        this.status = "Принят";
        this.discount = 0;
    }

    public int getNumber() {
        return number;
    }

    public Table getTable() {
        return table;
    }

    public String getStatus() {
        return status;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        if (discount < 0 || discount > 50) {
            throw new IllegalArgumentException(
                    "Скидка должна быть от 0 до 50%");
        }
        this.discount = discount;
    }

    public void addDish(Dish dish) throws RestaurantException {
        if (!status.equals("Принят")) {
            throw new RestaurantException("В заказ " + number
                    + " нельзя добавить блюдо, статус: " + status);
        }
        dishes.add(dish);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Dish dish : dishes) {
            total += dish.getPrice();
        }
        return total - total * discount / 100;
    }

    public int getCookingTime() {
        int max = 0;
        for (Dish dish : dishes) {
            if (dish.getCookingTime() > max) {
                max = dish.getCookingTime();
            }
        }
        return max;
    }

    public void nextStatus() throws RestaurantException {
        if (status.equals("Принят")) {
            if (dishes.isEmpty()) {
                throw new RestaurantException("Заказ " + number + " пуст");
            }
            status = "Готовится";
        } else if (status.equals("Готовится")) {
            status = "Подан";
        } else if (status.equals("Подан")) {
            status = "Оплачен";
            table.release();
        } else {
            throw new RestaurantException("Заказ " + number
                    + " уже оплачен");
        }
        System.out.println("Заказ " + number + ": статус изменен на \""
                + status + "\"");
    }

    public void printCheck() {
        System.out.println("Заказ " + number + ", столик "
                + table.getNumber() + ", статус: " + status);
        for (Dish dish : dishes) {
            System.out.println("  " + dish.getInfo());
        }
        if (discount > 0) {
            System.out.println("  Скидка: " + discount + "%");
        }
        System.out.println("  Время ожидания: " + getCookingTime()
                + " мин.");
        System.out.println("  Итого: " + getTotalPrice() + " руб.");
    }
}
