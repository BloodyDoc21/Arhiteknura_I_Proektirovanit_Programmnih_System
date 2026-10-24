import java.util.List;

public interface DishRepository {
    void save(Dish dish);

    Dish findByName(String name) throws RestaurantException;

    List<Dish> findAll();
}
