import java.util.Random;

public class AdditionalTask {
    public static void main(String[] args) {
        summThreeNummbers();
    }

    private static void summThreeNummbers() {
        Random random = new Random();
        int[][] array = new int[10][10];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = random.nextInt(1000);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        int max = 0;
        int indexMaxI = 0;
        int indexMaxJ = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (j + 2 <= array.length - 1) {
                    if (max < array[i][j] + array[i][j + 1] + array[i][j + 2]) {
                        max = array[i][j] + array[i][j + 1] + array[i][j + 2];
                        indexMaxJ = j;
                        indexMaxI = i;
                    }
                }
            }
            System.out.println(max + " (" + indexMaxI + " " + indexMaxJ + ")");
            max = 0;
        }
    }

}
