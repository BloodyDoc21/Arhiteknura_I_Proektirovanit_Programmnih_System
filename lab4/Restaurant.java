import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Restaurant {
    private String name;
    private Map<String, Dish> menu;
    private Set<String> categories;
    private Map<Integer, Table> tables;
    private List<Order> orders;
    private int nextOrderNumber;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new LinkedHashMap<>();
        this.categories = new TreeSet<>();
        this.tables = new LinkedHashMap<>();
        this.orders = new ArrayList<>();
        this.nextOrderNumber = 1;
    }

    public String getName() {
        return name;
    }

    public void addDish(Dish dish) {
        menu.put(dish.getName(), dish);
        categories.add(dish.getCategory());
    }

    public void addTable(Table table) {
        tables.put(table.getNumber(), table);
    }

    public Dish findDish(String dishName) throws RestaurantException {
        Dish dish = menu.get(dishName);
        if (dish == null) {
            throw new RestaurantException("Блюда \"" + dishName
                    + "\" нет в меню");
        }
        return dish;
    }

    public Table findTable(int number) throws RestaurantException {
        Table table = tables.get(number);
        if (table == null) {
            throw new RestaurantException("Столика " + number
                    + " не существует");
        }
        return table;
    }

    public Order createOrder(int tableNumber, int guests)
            throws RestaurantException {
        Table table = findTable(tableNumber);
        table.occupy(guests);
        Order order = new Order(nextOrderNumber, table);
        nextOrderNumber++;
        orders.add(order);
        System.out.println("Создан заказ " + order.getNumber()
                + " за столиком " + tableNumber);
        return order;
    }

    public void printMenu() {
        System.out.println("Меню ресторана \"" + name + "\":");
        for (String category : categories) {
            System.out.println(category + ":");
            for (Dish dish : menu.values()) {
                if (dish.getCategory().equals(category)) {
                    System.out.println("  " + dish.getInfo());
                }
            }
        }
    }

    public void printTables() {
        System.out.println("Столики:");
        for (Table table : tables.values()) {
            System.out.println("  Столик " + table.getNumber() + " (мест: "
                    + table.getSeats() + ") - " + table.getStatus());
        }
    }

    public double getRevenue() {
        double sum = 0;
        for (Order order : orders) {
            if (order.getStatus().equals("Оплачен")) {
                sum += order.getTotalPrice();
            }
        }
        return sum;
    }
}
