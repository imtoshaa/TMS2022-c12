import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        //Задачи:
        //1) Используя тип данных char и операцию инкремента вывести на консоль все буквы английского алфавита
        printEnglishAlphabet();
        //2)Проверка четности числа
        //Создать программу, которая будет сообщать, является ли целое число, введённое пользователем,
        // чётным или нет. Ввод числа осуществлять с помощью класса Scanner.
        // Если пользователь введёт не целое число, то сообщать ему об ошибке.
        evenNumber();
        //3) Меньшее по модулю число
        //Создать программу, которая будет выводить на экран меньшее по модулю из трёх введённых
        // пользователем вещественных чисел с консоли.
        minModule();
        //4) На некотором предприятии инженер Петров создал устройство, на табло которого показывается количество секунд,
        // оставшихся до конца рабочего дня. Когда рабочий день начинается ровно в 9 часов утра — табло отображает «28800» (т.е. остаётся 8 часов),
        // когда времени 14:30 — на табло «9000» (т.е. остаётся два с половиной часа), а когда наступает 17 часов — на табло отображается «0»
        // (т.е. рабочий день закончился).
        //Программист Иванов заметил, как страдают офисные сотрудницы — им неудобно оценивать остаток рабочего дня в секундах.
        // Иванов вызвался помочь сотрудницам и написать программу, которая вместо секунд будет выводить на табло понятные фразы с информацией о том,
        // сколько полных часов осталось до конца рабочего дня. Например: «осталось 7 часов», «осталось 4 часа», «остался 1 час», «осталось менее часа».
        //Итак, в переменную n должно записываться случайное (на время тестирования программы) целое число из [0;28800],
        // далее оно должно выводиться на экран (для Петрова) и на следующей строке (для сотрудниц) должна
        // выводиться фраза о количестве полных часов, содержащихся в n секундах.
        timePetrov();
        //5) Необходимо написать программу, которая будет выводить на консоль таблицу приведения типов!
//              byte	short	char	int 	long	float	double	boolean
//    byte
//    short
//    char
//    int
//    long
//    float
//    double
//    boolean
//
//    На пересечении напишите следующие фразы:
//    ня (неявное) – если преобразование происходит автоматически,
//    я (явное) – если нужно использовать явное преобразование,
//    х – если преобразование невозможно,
//    т  - если преобразование тождественно.
//    Внимание! используйте System.out.printLn
        typeConversion();
//
        /**
         * 6) Метод должен вернуть среднее значение из массива чисел
         * (необходимо сумму всех элеменов массива разделить на длину массива)
         * <p>
         * Example:
         * array = {1,2,3,4,5}
         * Метод должен return 3.0
         */
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Задание №6" + "\n" + average(array));
        /**
         * 7) Метод должен вернуть максимальый элемент массива. Пример: array = {1,2,10,3} метод возвращает 10
         **/
        int[] array7 = {1, 2, 10, 3};
        System.out.println("Задание №7" + "\n" + max(array7));

    }

    public static double average(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }


    public static int max(int[] array) {
        /*int m = Arrays.stream(array).max().getAsInt();*/
        int m = 0;
        for (int i = 0; i < array.length; i++) { //заменил стрим на фор
            if (array[i] > m) {
                m = array[i];
            }
        }
        return m;
    }

    private static void printEnglishAlphabet() { //сделал через коды acii
        System.out.println("Задание №1");
        for (int i = 65; i < 91; i++) {
            System.out.print((char) i + " ");
        }
        System.out.println();
    }

    private static void evenNumber() {

        System.out.println("Задание №2");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число для проверки на чётность");
        if (scanner.hasNextInt()) {
            double a = scanner.nextDouble();
            if (a % 2 == 0) {
                System.out.println("Число " + (int) a + " чётное");
            } else {
                System.out.println("Число " + (int) a + " нечётное");
            }
        } else {
            System.out.println("Ошибка! Число не является целым!");
        }

    }

    private static void minModule() {
        System.out.println("Задание №3");
        Scanner scanner = new Scanner(System.in);
//        int[] arr = new int[3];
        double[] arr = new double[3];
        System.out.println("Введите 3 числа через Enter для проверки на наименьший модуль");
        for (int i = 0; i < 3; i++) {
            arr[i] = scanner.nextDouble();
        }
//        int max = Arrays.stream(arr).map(Math::abs).min().getAsInt();
// погуглил классы для работы с массивами
// также можно сделать сортировку с использованием for и if, но это не так красиво, а также занимает больше кода
        double min = arr[0];
        for (int i = 1; i < 3; i++) {
            if (Math.abs(arr[i]) <= min) {
                min = arr[i];
            }
        }
        System.out.println("Наименьшее по модулю число " + min);
    }

    private static void timePetrov() {
        System.out.println("Задание №4");
        int random = (int) (Math.random() * 28801);
        System.out.println("Таймер для программиста Петров " + random + " секунд");
        if (random / 3600 == 1) {
            System.out.println("Таймер для сотрудниц " + (random / 3600) + "час");
        }
        if (random / 3600 >= 2 && random / 3600 <= 4) {
            System.out.println("Таймер для сотрудниц " + (random / 3600) + "часа");
        }
        if (random / 3600 >= 5) {
            System.out.println("Таймер для сотрудниц " + (random / 3600) + "часов");
        }
    }

    public static void typeConversion() {
        System.out.println("Задание №5");
        String[][] table = {
                {"       ", "byte   ", "short  ", "char   ", "int    ", "long   ", "float  ", "double ", "boolean"},
                {"byte   ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       "},
                {"short  ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       "},
                {"char   ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       "},
                {"int    ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       "},
                {"long   ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       "},
                {"float  ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       "},
                {"double ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       "},
                {"boolean", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       "},
        };

        for (int i = 1; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (i == j) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 1) + "т"; //отнимает символы с конца строки. Погуглил.
                }
                if ((Objects.equals(table[i][0], "byte   ") && Objects.equals(table[0][j], "boolean")) || (Objects.equals(table[i][0], "boolean") && Objects.equals(table[0][j], "byte   "))) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 1) + "х";
                }
                if ((Objects.equals(table[i][0], "short  ") && Objects.equals(table[0][j], "boolean")) || (Objects.equals(table[i][0], "boolean") && Objects.equals(table[0][j], "short  "))) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 1) + "х";
                }
                if ((Objects.equals(table[i][0], "char   ") && Objects.equals(table[0][j], "boolean")) || (Objects.equals(table[i][0], "boolean") && Objects.equals(table[0][j], "char   "))) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 1) + "х";
                }
                if ((Objects.equals(table[i][0], "int    ") && Objects.equals(table[0][j], "boolean")) || (Objects.equals(table[i][0], "boolean") && Objects.equals(table[0][j], "int    "))) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 1) + "х";
                }
                if ((Objects.equals(table[i][0], "long   ") && Objects.equals(table[0][j], "boolean")) || (Objects.equals(table[i][0], "boolean") && Objects.equals(table[0][j], "long   "))) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 1) + "х";
                }
                if ((Objects.equals(table[i][0], "float  ") && Objects.equals(table[0][j], "boolean")) || (Objects.equals(table[i][0], "boolean") && Objects.equals(table[0][j], "float  "))) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 1) + "х";
                }
                if ((Objects.equals(table[i][0], "double ") && Objects.equals(table[0][j], "boolean")) || (Objects.equals(table[i][0], "boolean") && Objects.equals(table[0][j], "double "))) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 1) + "х";
                }
                if (Objects.equals(table[i][0], "byte   ") && Objects.equals(table[0][j], "short  ")) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(table[i][0], "byte   ") && Objects.equals(table[0][j], "int    ")) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(table[i][0], "byte   ") && Objects.equals(table[0][j], "long   ")) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(table[i][0], "byte   ") && Objects.equals(table[0][j], "double ")) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(table[i][0], "byte   ") && Objects.equals(table[0][j], "float  ")) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(table[i][0], "short  ") && Objects.equals(table[0][j], "int    ")) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(table[i][0], "short  ") && Objects.equals(table[0][j], "long   ")) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(table[i][0], "short  ") && Objects.equals(table[0][j], "double ")) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(table[i][0], "short  ") && Objects.equals(table[0][j], "float  ")) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(table[i][0], "char   ") && Objects.equals(table[0][j], "int    ")) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(table[i][0], "char   ") && Objects.equals(table[0][j], "long   ")) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(table[i][0], "char   ") && Objects.equals(table[0][j], "double ")) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(table[i][0], "char   ") && Objects.equals(table[0][j], "float  ")) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(table[i][0], "int    ") && Objects.equals(table[0][j], "long   ")) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(table[i][0], "int    ") && Objects.equals(table[0][j], "double ")) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(table[i][0], "int    ") && Objects.equals(table[0][j], "float  ")) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(table[i][0], "long   ") && Objects.equals(table[0][j], "double ")) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(table[i][0], "long   ") && Objects.equals(table[0][j], "float  ")) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(table[i][0], "float  ") && Objects.equals(table[0][j], "double ")) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(table[i][j], "       ")) {
                    table[i][j] = table[i][j].substring(0, table[i][j].length() - 1) + "я";
                }
            }
        }
        for (String[] strings : table) {
            System.out.println(Arrays.toString(strings));
        }
    }


}
