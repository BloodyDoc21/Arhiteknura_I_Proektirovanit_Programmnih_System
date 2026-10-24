import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DishRepository dishes = new InMemoryDishRepository();
        TableRepository tables = new InMemoryTableRepository();
        OrderService orderService = new OrderService(tables, dishes);
        ConsolePrinter printer = new ConsolePrinter();

        Category salads = new Category("Салаты", "холодные блюда");
        Category hot = new Category("Горячее", "основные блюда");
        Category desserts = new Category("Десерты", "сладкое");
        Category drinks = new Category("Напитки", "холодные и горячие");

        dishes.save(new Dish("Цезарь", 450, salads, 10));
        dishes.save(new Dish("Греческий", 380, salads, 8));
        dishes.save(new HotDish("Борщ", 350, hot, 15, false));
        dishes.save(new HotDish("Стейк", 1200, hot, 25, false));
        dishes.save(new HotDish("Том ям", 550, hot, 20, true));
        dishes.save(new Dessert("Чизкейк", 320, desserts, 5, 410));
        dishes.save(new Drink("Морс", 150, drinks, 300));
        dishes.save(new Drink("Капучино", 180, drinks, 250));

        tables.save(new Table(1, 2));
        tables.save(new Table(2, 4));
        tables.save(new Table(3, 6));

        List<Waiter> waiters = new ArrayList<>();
        Waiter anna = new Waiter(1, "Анна");
        Waiter igor = new Waiter(2, "Игорь");
        waiters.add(anna);
        waiters.add(igor);

        printer.printMenu(dishes.findAll());
        System.out.println();
        printer.printTables(tables.findAll());

        System.out.println("\n=== Заказ с процентной скидкой ===");
        try {
            Order order = orderService.createOrder(2, 3, anna);
            orderService.addDish(order, "Борщ");
            orderService.addDish(order, "Стейк");
            orderService.addDish(order, "Чизкейк");
            orderService.addDish(order, "Морс");
            order.setDiscount(new PercentDiscount(10));
            printer.printOrder(order);
            for (int i = 0; i < 3; i++) {
                orderService.nextStatus(order);
                printer.printStatus(order);
            }
        } catch (RestaurantException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== Заказ с фиксированной скидкой ===");
        try {
            Order order = orderService.createOrder(1, 2, igor);
            orderService.addDish(order, "Цезарь");
            orderService.addDish(order, "Капучино");
            order.setDiscount(new FixedDiscount(200));
            printer.printOrder(order);
            for (int i = 0; i < 3; i++) {
                orderService.nextStatus(order);
            }
            printer.printStatus(order);
        } catch (RestaurantException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== Ошибочные ситуации ===");
        try {
            orderService.createOrder(1, 5, anna);
        } catch (RestaurantException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            orderService.createOrder(3, 4, anna);
            orderService.createOrder(3, 2, igor);
        } catch (RestaurantException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Order order = orderService.createOrder(1, 2, igor);
            orderService.addDish(order, "Пицца");
        } catch (RestaurantException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Order order = orderService.getOrders().get(0);
            orderService.addDish(order, "Морс");
        } catch (RestaurantException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            orderService.nextStatus(orderService.getOrders().get(0));
        } catch (RestaurantException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            new PercentDiscount(70);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            dishes.save(new Drink("Вода", 50, drinks, -100));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println();
        printer.printTables(tables.findAll());
        printer.printWaiters(waiters);
        System.out.println("Выручка: " + orderService.getRevenue()
                + " руб.");
    }
}
