import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork {


    public static void main(String[] args) {
        calculateSumOfDiagonalElements();
        printMatrix();
        System.out.println("Задача №1" + "\n" + summ(-1, -5));
        System.out.println("Задача №1" + "\n" + summ(-1, 5));
        System.out.println("Задача №1" + "\n" + summ(1, -5));
        System.out.println("Задача №1" + "\n" + summ(5, 1));
        triangles();
        reversOddNumbers();
        maxOfRandomNumbers();
        replaceOddIndexes();
        searchMaxNumberAndReplace(new int[]{4, 5, 0, 23, 77, 0, 8, 9, 101, 2});
        repeatingElement(new String[]{"0", "0", "46", "2", "0", "2", "2"});
        repeatingElement(new String[]{"3", "2", "46", "3", "2", "1", "2"});
        repeatingElement(new String[]{"1", "1", "1", "1", "1", "1", "1"});
        repeatingElement(new String[]{"1", "1", "1", "4", "5", "5"});
        transpositionMatrix();
        calculateSumOfDiagonalElements();
    }

//        Задачи:

//        1) Напишите реализацию метода summ(int a, int b), вычисляющий a*b, не пользуясь операцией
//        умножения, где a и b целые числа, вызовите метод summ  в методе main и распечатайте на консоль.

//        2) Дан двухмерный массив размерностью 4 на 4, необходимо нарисовать четыре треугольника вида

//        a)                  b)
//              *        *
//            * *        * *
//          * * *        * * *
//        * * * *        * * * *
//
//        c)                  d)
//        * * * *        * * * *
//          * * *        * * *
//            * *        * *
//              *        *


//        3) Создайте массив из всех нечётных чисел от 1 до 100, выведите его на экран в строку,
//        а затем этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 ... 7 5 3 1).

//        4) Создайте массив из int[] mass = new int[12]; Рандомно заполните его значениями от 0 до 15.
//        Определите какой элемент является в этом массиве максимальным и сообщите индекс его последнего вхождения в массив.
//        Пример: {3,4,5,62,7,8,4,-5,7,62,5,1} Максимальный элемент 62, индекс его последнего вхождения в массив = 10

//        5) Создайте массив размера 20, заполните его случайными целыми чиселами из отрезка от 0 до 20.
//        Выведите массив на экран в строку. Замените каждый элемент с нечётным индексом на ноль.
//        Снова выведете массив на экран на отдельной строке.

//        6) Найти максимальный элемент в массиве {4,5,0,23,77,0,8,9,101,2} и поменять его местами с нулевым элементом

//        7) Проверить, различны ли все элементы массива, если не различны то вывести элемент повторяющийся
//        Пример: {0,3,46,3,2,1,2}
//        Массив имеет повторяющиеся элементы 3, 2
//        Пример: {0,34,46,31,20,1,28}
//        Массив не имеет повторяющихся элементов

//        8) Создаём квадратную матрицу, размер вводим с клавиатуры.
//        Заполняем случайными числами в диапазоне от 0 до 50. И выводим на консоль(в виде матрицы).
//        Далее необходимо транспонировать матрицу(1 столбец станет 1-й строкой, 2-й столбец - 2-й строкой и т. д.)
//        Пример:
//          1 2 3 4      1 6 3 1
//          6 7 8 9      2 7 3 5
//          3 3 4 5      3 8 4 6
//          1 5 6 7      4 9 5 7


    /**
     * заполнить рандомно 2-х мерный массив и посчитать сумму элементов на диагонали
     */
    public static void calculateSumOfDiagonalElements() {
        Random random = new Random();
        System.out.println("Задание 9" + "\n" + "Получен массив:");
        int[][] diagonal = new int[5][5];
        int result = 1;
        for (int i = 0; i < diagonal.length; i++) {
            for (int j = 0; j < diagonal.length; j++) {
                diagonal[i][j] = random.nextInt(50);
                System.out.print(diagonal[i][j] + " ");
                if (i == j) {
                    result = result + diagonal[i][j];
                }
            }
            System.out.println();
        }
        System.out.println("Сумма чисел по диагонали матрицы = " + result);
    } // Задание 9


    /**
     * Шаги по реализации:
     * - Прочитать два int из консоли
     * - Создайте двумерный массив int (используйте целые числа, которые вы читаете по высоте и ширине консоли)
     * - Заполнить массив случайными значениями (до 100)
     * - Вывести в консоль матрицу заданного размера, но:
     * - Если остаток от деления элемента массива на 3 равен нулю - выведите знак "+" вместо значения элемента массива.
     * - Если остаток от деления элемента массива на 7 равен нулю - выведите знак "-" вместо значения элемента массива.
     * - В противном случае выведите "*"
     * <p>
     * Example:
     * - Значения с консоли - 2 и 3
     * - Массив будет выглядеть так (значения будут разными, потому что он случайный)
     * 6 11 123
     * 1 14 21
     * - Для этого значения вывод в консоли должен быть:
     * <p>
     * + * *
     * * - +
     * <p>
     * Обратите внимание, что 21% 3 == 0 и 21% 7 = 0, но выводить надо не +-, а +
     */

    public static void printMatrix() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Задание 10" + "\n" + "Введите 2 числа с консоли");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] array = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                array[i][j] = random.nextInt(100);
                if (array[i][j] % 3 == 0) {
                    System.out.print("+");
                } else if (array[i][j] % 7 == 0) {
                    System.out.print("-");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    private static int summ(int a, int b) {
        int result = 0; //если что-либо равно нулю, то всё равно нулю
        if (a == 0 || b == 0) {
            return 0;
        }
        boolean negative = false; //какой либо из множителей отрицательный?
        if (b < 0 && a < 0) {
            b = -b;
            a = -a;
        } else if (a < 0) {
            negative = true;
            a = -a;
        } else if (b < 0) {
            negative = true;
            b = -b;
        }
        for (int i = 0; i < b; i++) {
            result += a;
        }
//        if (negative) {
//            return -result;
//        }
        return negative ? -result : result;
    } //Задача 1

    private static void triangles() {
        char[][] tri = {{' ', ' ', ' ', '*'},
                {' ', ' ', '*', '*'},
                {' ', '*', '*', '*'},
                {'*', '*', '*', '*'}};
        System.out.println("Задача №2");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(tri[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 3; i >= 0; i--) {
            for (int j = 3; j >= 0; j--) {
                System.out.print(tri[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j >= 0; j--) {
                System.out.print(tri[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 3; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                System.out.print(tri[i][j] + " ");
            }
            System.out.println();
        }
    } //Задача 2

    private static void reversOddNumbers() {
        int length = 0;
        System.out.println("Задача №3");
        for (int i = 1; i <= 100; i++) { //считаем количество элементов будущего массива
            if (i % 2 != 0) {
                length++;
            }
        }
        int[] arr = new int[length];
        for (int i = 1, j = 0; i <= 100; i++) { //ищем нечётные числа и заполняем массив
            if (i % 2 != 0) {
                arr[j] = i;
                System.out.print(arr[j] + " ");
                j++;
            }
        }
        System.out.println();
        for (int i = length - 1; i >= 0; i--) { //печатаем массив в обратном направлении
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    } //Задача 3

    private static void maxOfRandomNumbers() {
        System.out.println("Задача 4");
        int[] mass = new int[12];
        Random random = new Random();
        for (int i = 0; i < mass.length; i++) {
            mass[i] = random.nextInt(15);
            System.out.print(mass[i] + " ");
        }
        System.out.println();
        int max = 0;
        int j = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] >= max) {
                j = i;
                max = mass[i];
            }
        }
        System.out.println("Максимальный элемент " + max + " , индекс его последнего вхождения в массив = " + j);
    } //Задача 4

    private static void replaceOddIndexes() {
        System.out.println("Задача 5");
        int[] mass = new int[20];
        Random random = new Random();
        for (int i = 0; i < mass.length; i++) {
            mass[i] = random.nextInt(20);
            System.out.print(mass[i] + " ");
        }
        System.out.println();
        for (int i = 1; i < mass.length; i += 2) {
            mass[i] = 0;
        }
        for (int i = 0; i < mass.length; i++) {
            System.out.print(mass[i] + " ");
        }
        System.out.println();
    } //Задача 5

    private static void searchMaxNumberAndReplace(int[] ints) {
        System.out.println("Задание 6");
        int max = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > max) {
                max = ints[i];
            }
        }
        System.out.println(Arrays.toString(ints));
        int temp = ints[0];
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == max) {
                ints[0] = ints[i];
                ints[i] = temp;
            }
        }
        System.out.println(Arrays.toString(ints));
    } //Задача 6

    private static void repeatingElement(String[] ints) {
        System.out.print("Задание 7" + "\n" + "Повторяющиеся элементы: ");
        String[] repeat = new String[ints.length];
        for (int i = 0; i < ints.length; i++) {
            if (!repeat(ints[i], repeat)) { //были ли повторяющиеся найдены
                for (int j = i + 1; j < ints.length; j++) {
                    if (ints[i] == ints[j]) {
                        repeat[i] = ints[i]; //добавляем в массив с повторками элемент
                        break;
                    }
                }
            }
        }
        boolean count = false; //был ли отправлен на вывод хоть один символ
        for (int i = 0; i < repeat.length; i++) {
            if (repeat[i] != null) { //печатаем повторки, если значение не равно null
                if (!count) {
                    System.out.print(repeat[i]);
                    count = true;
                } else {
                    System.out.print(", " + repeat[i]);
                }
            }
        }
        System.out.println();

    } //Задача 7

    public static boolean repeat(String x, String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                return true;
            }
        }
        return false;
    }//проверяет повторки для задания 7


    private static void transpositionMatrix() {
        Random random = new Random();
        int x = 5;
        System.out.println("Задание 8" + "\n" + "Получен массив:");
        int[][] matrix = new int[x][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                matrix[i][j] = random.nextInt(50);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        int temp;
        for (int i = 0; i < x; i++) {
            for (int j = i + 1; j < x; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }

        }
        System.out.println("Транспонированная матрица");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    } // Задание 8

}


//          1 2 3 4      1 6 3 1
//          6 7 8 9      2 7 3 5
//          3 3 4 5      3 8 4 6
//          1 5 6 7      4 9 5 7