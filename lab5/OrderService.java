import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private TableRepository tables;
    private DishRepository dishes;
    private List<Order> orders;
    private int nextOrderNumber;

    public OrderService(TableRepository tables, DishRepository dishes) {
        this.tables = tables;
        this.dishes = dishes;
        this.orders = new ArrayList<>();
        this.nextOrderNumber = 1;
    }

    public Order createOrder(int tableNumber, int guests, Waiter waiter)
            throws RestaurantException {
        Table table = tables.findByNumber(tableNumber);
        table.occupy(guests);
        Order order = new Order(nextOrderNumber, table, waiter);
        nextOrderNumber++;
        orders.add(order);
        waiter.addOrder(order);
        return order;
    }

    public void addDish(Order order, String dishName)
            throws RestaurantException {
        order.addDish(dishes.findByName(dishName));
    }

    public void nextStatus(Order order) throws RestaurantException {
        order.nextStatus();
        if (order.getStatus() == OrderStatus.PAID) {
            order.getTable().release();
        }
    }

    public List<Order> getOrders() {
        return orders;
    }

    public double getRevenue() {
        double sum = 0;
        for (Order order : orders) {
            if (order.getStatus() == OrderStatus.PAID) {
                sum += order.getTotalPrice();
            }
        }
        return sum;
    }
}
