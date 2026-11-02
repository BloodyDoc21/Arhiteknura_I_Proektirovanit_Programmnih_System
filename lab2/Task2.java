import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите день рождения: ");
        if (!input.hasNextInt()) {
            System.out.println("Ошибка: день должен быть целым числом.");
            input.close();
            return;
        }
        int d = input.nextInt();

        System.out.print("Введите месяц рождения (от 1 до 12): ");
        if (!input.hasNextInt()) {
            System.out.println("Ошибка: месяц должен быть целым числом.");
            input.close();
            return;
        }
        int m = input.nextInt();

        int maxDays;

        switch (m) {
            case 2:
                maxDays = 29;
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                maxDays = 30;
                break;

            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                maxDays = 31;
                break;

            default:
                System.out.println("Ошибка: месяц должен быть от 1 до 12.");
                input.close();
                return;
        }

        if (d < 1 || d > maxDays) {
            System.out.println("Ошибка: в указанном месяце нет такого дня.");
            input.close();
            return;
        }

        String zodiac;

        switch (m) {
            case 1:
                if (d <= 21) {
                    zodiac = "Козерог";
                } else {
                    zodiac = "Водолей";
                }
                break;

            case 2:
                if (d <= 21) {
                    zodiac = "Водолей";
                } else {
                    zodiac = "Рыбы";
                }
                break;

            case 3:
                if (d <= 21) {
                    zodiac = "Рыбы";
                } else {
                    zodiac = "Овен";
                }
                break;

            case 4:
                if (d <= 21) {
                    zodiac = "Овен";
                } else {
                    zodiac = "Телец";
                }
                break;

            case 5:
                if (d <= 21) {
                    zodiac = "Телец";
                } else {
                    zodiac = "Близнецы";
                }
                break;

            case 6:
                if (d <= 21) {
                    zodiac = "Близнецы";
                } else {
                    zodiac = "Рак";
                }
                break;

            case 7:
                if (d <= 21) {
                    zodiac = "Рак";
                } else {
                    zodiac = "Лев";
                }
                break;

            case 8:
                if (d <= 21) {
                    zodiac = "Лев";
                } else {
                    zodiac = "Дева";
                }
                break;

            case 9:
                if (d <= 21) {
                    zodiac = "Дева";
                } else {
                    zodiac = "Весы";
                }
                break;

            case 10:
                if (d <= 21) {
                    zodiac = "Весы";
                } else {
                    zodiac = "Скорпион";
                }
                break;

            case 11:
                if (d <= 21) {
                    zodiac = "Скорпион";
                } else {
                    zodiac = "Стрелец";
                }
                break;

            case 12:
                if (d <= 21) {
                    zodiac = "Стрелец";
                } else {
                    zodiac = "Козерог";
                }
                break;

            default:
                input.close();
                return;
        }

        System.out.println("Ваш знак Зодиака: " + zodiac);

        input.close();
    }
}