import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите день рождения (d): ");
        int d = input.nextInt();

        System.out.print("Введите месяц рождения (m от 1 до 12): ");
        int m = input.nextInt();

        String zodiac = "";

        if ((m == 3 && d >= 22) || (m == 4 && d <= 21)) {
            zodiac = "Овен";
        } else if ((m == 4 && d >= 22) || (m == 5 && d <= 21)) {
            zodiac = "Телец";
        } else if ((m == 5 && d >= 22) || (m == 6 && d <= 21)) {
            zodiac = "Близнецы";
        } else if ((m == 6 && d >= 22) || (m == 7 && d <= 21)) {
            zodiac = "Рак";
        } else if ((m == 7 && d >= 22) || (m == 8 && d <= 21)) {
            zodiac = "Лев";
        } else if ((m == 8 && d >= 22) || (m == 9 && d <= 21)) {
            zodiac = "Дева";
        } else if ((m == 9 && d >= 22) || (m == 10 && d <= 21)) {
            zodiac = "Весы";
        } else if ((m == 10 && d >= 22) || (m == 11 && d <= 21)) {
            zodiac = "Скорпион";
        } else if ((m == 11 && d >= 22) || (m == 12 && d <= 21)) {
            zodiac = "Стрелец";
        } else if ((m == 12 && d >= 22) || (m == 1 && d <= 21)) {
            zodiac = "Козерог";
        } else if ((m == 1 && d >= 22) || (m == 2 && d <= 21)) {
            zodiac = "Водолей";
        } else if ((m == 2 && d >= 22) || (m == 3 && d <= 21)) {
            zodiac = "Рыбы";
        } else {
            zodiac = "Введена некорректная дата!";
        }

        System.out.println("Ваш знак Зодиака: " + zodiac);

        input.close();
    }
}