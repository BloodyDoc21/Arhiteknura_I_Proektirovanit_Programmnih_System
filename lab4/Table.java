public class Table {
    private int number;
    private int seats;
    private boolean free;

    public Table(int number, int seats) {
        if (seats <= 0) {
            throw new IllegalArgumentException(
                    "Количество мест должно быть больше нуля");
        }
        this.number = number;
        this.seats = seats;
        this.free = true;
    }

    public int getNumber() {
        return number;
    }

    public int getSeats() {
        return seats;
    }

    public boolean isFree() {
        return free;
    }

    public String getStatus() {
        if (free) {
            return "свободен";
        }
        return "занят";
    }

    public void occupy(int guests) throws RestaurantException {
        if (!free) {
            throw new RestaurantException("Столик " + number
                    + " уже занят");
        }
        if (guests > seats) {
            throw new RestaurantException("За столиком " + number
                    + " не хватает мест для " + guests + " гостей");
        }
        free = false;
    }

    public void release() {
        free = true;
    }
}
