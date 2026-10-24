import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InMemoryDishRepository implements DishRepository {
    private Map<String, Dish> dishes = new LinkedHashMap<>();

    @Override
    public void save(Dish dish) {
        dishes.put(dish.getName(), dish);
    }

    @Override
    public Dish findByName(String name) throws RestaurantException {
        Dish dish = dishes.get(name);
        if (dish == null) {
            throw new RestaurantException("Блюда \"" + name
                    + "\" нет в меню");
        }
        return dish;
    }

    @Override
    public List<Dish> findAll() {
        return new ArrayList<>(dishes.values());
    }
}
