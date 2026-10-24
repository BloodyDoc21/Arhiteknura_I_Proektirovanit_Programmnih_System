import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        int a, b;
        boolean isMultiple;

        Scanner input = new Scanner(System.in);

        do {
            System.out.print("Введите два целых числа через пробел: ");
            a = input.nextInt();
            b = input.nextInt();

            isMultiple = (b != 0 && a % b == 0) || (a != 0 && b % a == 0);

            if (!isMultiple)
                System.out.println("Числа не кратны друг другу. "
                        + "Попробуйте еще раз.");
        } while (!isMultiple);

        System.out.println("Пара " + a + " и " + b
                + ": одно число кратно другому.");
    }
}
