public class Category {
    private String name;
    private String description;

    public Category(String name, String description) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(
                    "Название категории не может быть пустым");
        }
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
