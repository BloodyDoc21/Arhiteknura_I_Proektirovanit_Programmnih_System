import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите значение a: ");
        double a = input.nextDouble();

        System.out.print("Введите значение x: ");
        double x = input.nextDouble();

        System.out.print("Введите значение b: ");
        double b = input.nextDouble();

        System.out.print("Введите значение c: ");
        double c = input.nextDouble();

        double qNumerator = Math.log(3) + x;
        double qDenominator = 1 - Math.exp(5);
        double Q = qNumerator / qDenominator;

        double fLeft = 2 * a * Math.exp(2 * x);
        double sinX = Math.sin(x);
        double fRoot = Math.sqrt(1 - 1.5 * Math.pow(sinX, 2));
        double fDenominator = 0.3 * a * b - x;
        
        double F = 0;
        if (fDenominator != 0) {
            F = fLeft - (fRoot / fDenominator);
        } else {
            System.out.println("Ошибка: деление на ноль в знаменателе F!");
        }

        double zNumerator = (a + Math.sqrt(Math.pow(c, 3))) * Math.sin(x) + Math.pow(c, 3);
        double zDenominator = (Math.pow(a, 3) - Math.pow(c, 3)) * (a - 4);
        
        double Z = 0;
        if (zDenominator != 0) {
            Z = zNumerator / zDenominator;
        } else {
            System.out.println("Ошибка: деление на ноль в знаменателе Z!");
        }

        System.out.println("\n Результаты вычислений (Вариант 3) ");
        System.out.println("Значение Q = " + Q);
        System.out.println("Значение F = " + F);
        System.out.println("Значение Z = " + Z);

        input.close();
    }
}