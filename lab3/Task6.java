public class Task6 {
    public static void main(String[] args) {
        int row;
        int col;

        for (row = 0; row <= 5; row++) {
            for (col = 0; col <= row; col++) {
                System.out.print(col + "  ");
            }
            System.out.println();
        }

        for (row = 4; row >= 0; row--) {
            for (col = 0; col <= row; col++) {
                System.out.print(col + "  ");
            }
            System.out.println();
        }
    }
}
