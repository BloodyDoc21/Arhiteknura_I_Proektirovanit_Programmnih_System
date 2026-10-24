import java.util.ArrayList;
import java.util.List;

public class Order {
    private int number;
    private Table table;
    private Waiter waiter;
    private List<Dish> dishes;
    private OrderStatus status;
    private Discount discount;

    public Order(int number, Table table, Waiter waiter) {
        this.number = number;
        this.table = table;
        this.waiter = waiter;
        this.dishes = new ArrayList<>();
        this.status = OrderStatus.ACCEPTED;
    }

    public int getNumber() {
        return number;
    }

    public Table getTable() {
        return table;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void addDish(Dish dish) throws RestaurantException {
        if (status != OrderStatus.ACCEPTED) {
            throw new RestaurantException("В заказ " + number
                    + " нельзя добавить блюдо, статус: "
                    + status.getTitle());
        }
        dishes.add(dish);
    }

    public double getSubtotal() {
        double total = 0;
        for (Dish dish : dishes) {
            total += dish.getPrice();
        }
        return total;
    }

    public double getTotalPrice() {
        if (discount == null) {
            return getSubtotal();
        }
        return discount.apply(getSubtotal());
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
        if (status == OrderStatus.PAID) {
            throw new RestaurantException("Заказ " + number
                    + " уже оплачен");
        }
        if (status == OrderStatus.ACCEPTED && dishes.isEmpty()) {
            throw new RestaurantException("Заказ " + number + " пуст");
        }
        status = status.next();
    }
}
