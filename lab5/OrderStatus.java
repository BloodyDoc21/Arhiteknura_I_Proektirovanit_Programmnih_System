public enum OrderStatus {
    ACCEPTED("Принят"),
    COOKING("Готовится"),
    SERVED("Подан"),
    PAID("Оплачен");

    private String title;

    OrderStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public OrderStatus next() {
        if (this == ACCEPTED) {
            return COOKING;
        }
        if (this == COOKING) {
            return SERVED;
        }
        return PAID;
    }
}
