public class Task3 {
    public static void main(String[] args) {
        final double START_POPULATION = 9870;
        final double LIMIT = 30000;
        final double GROWTH = 1.10;

        double population;
        int count_years;

        population = START_POPULATION;
        count_years = 0;
        System.out.println("Год " + count_years + ": "
                + (int) population + " чел.");

        while (population <= LIMIT) {
            population *= GROWTH;
            count_years++;
            System.out.println("Год " + count_years + ": "
                    + (int) population + " чел.");
        }

        System.out.println("Население превысит " + (int) LIMIT
                + " человек через " + count_years + " лет.");
    }
}
