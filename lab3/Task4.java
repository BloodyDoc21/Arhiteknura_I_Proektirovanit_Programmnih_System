import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        final double SENTINEL = 0;

        double number;
        int count_positive;
        int count_negative;

        Scanner input = new Scanner(System.in);

        count_positive = 0;
        count_negative = 0;

        System.out.print("Введите число или " + (int) SENTINEL
                + " для выхода: ");
        number = input.nextDouble();

        while (number != SENTINEL) {
            if (number > 0)
                count_positive++;
            else
                count_negative++;

            System.out.print("Введите число или " + (int) SENTINEL
                    + " для выхода: ");
            number = input.nextDouble();
        }

        System.out.println("Положительных чисел: " + count_positive);
        System.out.println("Отрицательных чисел: " + count_negative);
    }
}
