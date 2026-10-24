import java.util.List;

public interface TableRepository {
    void save(Table table);

    Table findByNumber(int number) throws RestaurantException;

    List<Table> findAll();
}
