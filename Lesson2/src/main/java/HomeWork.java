public class HomeWork {
    public static void main(String[] args) {
        //вывод на консоль
        printLiterals();
        //Некоторые тесты для проверки задач.
        System.out.println(sum(100, 200));
        System.out.println(sum(Integer.MAX_VALUE, Integer.MAX_VALUE));
        System.out.println(max(56, 349));
        System.out.println(calculateHypotenuse(3, 4));
    }

    private static void printLiterals() {
//        вывести на консоль литералы следующих видов:
//        логический
        boolean b1 = true;
        boolean b2 = false;
        System.out.println("Логические " + b1 + " и " + b2);
//        строковый
        String str = "Stroka";
        System.out.println("Строковый " + str);
//        символьный
        char ch = 'c';
        System.out.println("Символьный " + ch);
//        целочисленный 2-й
        int i2 = 0b1101;
        System.out.println("Целочисленный 2-й " + i2);
//        целочисленный 8-й
        int i8 = 001;
        System.out.println("Целочисленный 8-й " + i8);
//        целочисленный 10-й
        int i10 = 10;
        System.out.println("Целочисленный 10-й " + i10);
//        целочисленный 16-й
        int i16 = 0x16F;
        System.out.println("Целочисленный 16-й " + i16);
//        литерал типа float
        float f = 2.1f;
        System.out.println("Float " + f);
//        литерал типа double.
        double d = 1.232323;
        System.out.println("Double " + d);
    }

    /**
     * 1. Метод должен вернуть сумму двух чисел a и b
     * 2. Дополнительно: сделать проверку если сумма a и b больше чем максимальное значение int то вернуть -1
     **/
    public static long sum(long a, long b) {
        long sum = a + b;
        if (sum > Integer.MAX_VALUE) {
            return -1;
        } else {
            return sum;
        }
    }

    /**
     * Метод должен вернуть максимальное значение из двух чисел
     *
     * <p>
     * Example1:
     * a = 4,
     * b = 5
     * <p>
     * Метод должен вернуть 5
     * Example2:
     * a = 10,
     * b = 10
     * <p>
     * Метод должен вернуть 10
     */
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    /**
     * Используя теорему Пифагора, вычислите значение гипотенузы. Квадрат гипотенузы = сумме квадратов катетов
     * <p>
     * Example1:
     * 3
     * 4
     * return 5
     * <p>
     * Example2:
     * 12
     * 16
     * return 20
     */
    public static double calculateHypotenuse(int a, int b) {
        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        return c;
    }
}