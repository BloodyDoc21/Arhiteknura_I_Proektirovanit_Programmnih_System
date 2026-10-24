import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTableRepository implements TableRepository {
    private Map<Integer, Table> tables = new LinkedHashMap<>();

    @Override
    public void save(Table table) {
        tables.put(table.getNumber(), table);
    }

    @Override
    public Table findByNumber(int number) throws RestaurantException {
        Table table = tables.get(number);
        if (table == null) {
            throw new RestaurantException("Столика " + number
                    + " не существует");
        }
        return table;
    }

    @Override
    public List<Table> findAll() {
        return new ArrayList<>(tables.values());
    }
}
