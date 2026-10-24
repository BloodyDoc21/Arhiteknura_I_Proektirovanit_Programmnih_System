import java.util.ArrayList;
import java.util.List;

public class Waiter {
    private int id;
    private String name;
    private List<Order> orders;

    public Waiter(int id, String name) {
        this.id = id;
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}
