import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int n;
        int i;
        int sum;
        int formula;

        Scanner input = new Scanner(System.in);

        System.out.print("Введите целое число n: ");
        n = input.nextInt();

        sum = 0;
        for (i = 1; i <= n; i++) {
            sum += i;
        }

        formula = (n * (n + 1)) / 2;

        System.out.println("Сумма, вычисленная циклом: " + sum);
        System.out.println("Сумма по формуле n * (n + 1) / 2: " + formula);

        if (sum == formula)
            System.out.println("Выражения эквивалентны");
        else
            System.out.println("Выражения не эквивалентны");
    }
}
