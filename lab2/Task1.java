import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите координаты точки A1 (x1 y1):");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();

        System.out.println("Введите координаты точки A2 (x2 y2):");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        System.out.println("Введите координаты точки A3 (x3 y3):");
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();

        
        if (x1 == x2 && y1 == y2) {
            System.out.println("Результат: Точки A1 и A2 совпадают. Через них невозможно провести прямую!");
        } else {
            System.out.println("Результат: Через точку A3 можно провести прямую, перпендикулярную прямой A1A2 (так как точки A1 и А2 различны).");
        }

        input.close();
    }
}