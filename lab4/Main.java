public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Уют");

        restaurant.addDish(new Dish("Цезарь", 450, "Салат", 10));
        restaurant.addDish(new Dish("Греческий", 380, "Салат", 8));
        restaurant.addDish(new HotDish("Борщ", 350, 15, false));
        restaurant.addDish(new HotDish("Стейк", 1200, 25, false));
        restaurant.addDish(new HotDish("Том ям", 550, 20, true));
        restaurant.addDish(new Dessert("Чизкейк", 320, 5, 410));
        restaurant.addDish(new Dish("Морс", 150, "Напиток", 2));

        restaurant.addTable(new Table(1, 2));
        restaurant.addTable(new Table(2, 4));
        restaurant.addTable(new Table(3, 6));

        restaurant.printMenu();
        System.out.println();
        restaurant.printTables();

        System.out.println("\n=== Обычный заказ ===");
        try {
            Order order = restaurant.createOrder(2, 3);
            order.addDish(restaurant.findDish("Борщ"));
            order.addDish(restaurant.findDish("Стейк"));
            order.addDish(restaurant.findDish("Чизкейк"));
            order.addDish(restaurant.findDish("Морс"));
            order.setDiscount(10);
            order.printCheck();
            order.nextStatus();
            order.nextStatus();
            order.nextStatus();
        } catch (RestaurantException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== Ошибочные ситуации ===");
        try {
            restaurant.createOrder(1, 5);
        } catch (RestaurantException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            restaurant.createOrder(3, 4);
            restaurant.createOrder(3, 2);
        } catch (RestaurantException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            restaurant.createOrder(7, 2);
        } catch (RestaurantException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            restaurant.findDish("Пицца");
        } catch (RestaurantException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Order order = restaurant.createOrder(1, 2);
            order.addDish(restaurant.findDish("Том ям"));
            order.nextStatus();
            order.addDish(restaurant.findDish("Морс"));
        } catch (RestaurantException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Order order = new Order(100, new Table(10, 2));
            order.setDiscount(70);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            restaurant.addDish(new Dish("Хлеб", -20, "Закуска", 1));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println();
        restaurant.printTables();
        System.out.println("Выручка: " + restaurant.getRevenue()
                + " руб.");
    }
}
