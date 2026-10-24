import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ConsolePrinter {
    public void printMenu(List<Dish> dishes) {
        Set<Category> categories = new LinkedHashSet<>();
        for (Dish dish : dishes) {
            categories.add(dish.getCategory());
        }
        System.out.println("Меню:");
        for (Category category : categories) {
            System.out.println(category.getName() + " ("
                    + category.getDescription() + "):");
            for (Dish dish : dishes) {
                if (dish.getCategory() == category) {
                    System.out.println("  " + dish.getInfo());
                }
            }
        }
    }

    public void printTables(List<Table> tables) {
        System.out.println("Столики:");
        for (Table table : tables) {
            String status = "занят";
            if (table.isFree()) {
                status = "свободен";
            }
            System.out.println("  Столик " + table.getNumber() + " (мест: "
                    + table.getSeats() + ") - " + status);
        }
    }

    public void printOrder(Order order) {
        System.out.println("Заказ " + order.getNumber() + ", столик "
                + order.getTable().getNumber() + ", официант "
                + order.getWaiter().getName());
        for (Dish dish : order.getDishes()) {
            System.out.println("  " + dish.getInfo());
        }
        System.out.println("  Сумма: " + order.getSubtotal() + " руб.");
        if (order.getDiscount() != null) {
            System.out.println("  Применена "
                    + order.getDiscount().getDescription());
        }
        System.out.println("  Время ожидания: "
                + order.getCookingTime() + " мин.");
        System.out.println("  Итого: " + order.getTotalPrice() + " руб.");
    }

    public void printStatus(Order order) {
        System.out.println("Заказ " + order.getNumber()
                + ": статус \"" + order.getStatus().getTitle() + "\"");
    }

    public void printWaiters(List<Waiter> waiters) {
        System.out.println("Официанты:");
        for (Waiter waiter : waiters) {
            System.out.println("  " + waiter.getName() + " - заказов: "
                    + waiter.getOrders().size());
        }
    }
}
